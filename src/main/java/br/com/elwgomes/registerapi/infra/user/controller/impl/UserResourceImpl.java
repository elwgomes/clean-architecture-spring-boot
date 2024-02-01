package br.com.elwgomes.registerapi.infra.user.controller.impl;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserAlreadyExistsException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;
import br.com.elwgomes.registerapi.core.user.usecase.command.*;
import br.com.elwgomes.registerapi.infra.user.controller.UserResource;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final GetAllUsersCommand getAllUsersCommand;
    private final GetUserByIdCommand getUserByIdCommand;
    private final SaveUserCommand saveUserCommand;
    private final DeleteUserCommand deleteUserCommand;
    private final UpdatePasswordCommand updateUserCommand;

    private final UserRepositoryMapperImpl mapper;

    @Override
    @GetMapping
    public UserResponse<Collection<UserDTO>> getAllUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream().findFirst().map(Object::toString).orElse("");
        System.out.println(authentication);
        if ("ROLE_ADMIN".equals(role)) {
            return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "OK", getAllUsersCommand.execute().stream().map(mapper::mapDomainToDtoFullDetails).collect(Collectors.toList()));
        }
        return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "OK", getAllUsersCommand.execute().stream().map(mapper::mapDomainToDto).collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    public UserResponse<Boolean> saveUser(@RequestBody @Valid UserEntity entity) throws Exception {
        try {
            saveUserCommand.execute(mapper.mapToDomain(entity));
        } catch (UserAlreadyExistsException e) {
            throw new Exception(e);
        }
        return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "New user has been created.");
    }

    @Override
    @DeleteMapping("{id}")
    public UserResponse<Boolean> deleteUser(@PathVariable("id") UUID id) throws UserNotFoundException {
        try {
            deleteUserCommand.execute(id);
        } catch (UserNotFoundException exception) {
            throw new UserNotFoundException(exception.getMessage());
        }
        return new UserResponse<>("error", String.valueOf(HttpStatus.NO_CONTENT), "User has been deleted.");
    }

    @Override
    @GetMapping("{id}")
    public UserResponse<Optional<UserDTO>> findUserById(@PathVariable("id") UUID id) throws UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream().findFirst().map(Object::toString).orElse("");
        if ("ROLE_ADMIN".equals(role)) {
            return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "OK", getUserByIdCommand.execute(id).map(mapper::mapDomainToDtoFullDetails));
        }
        return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "OK", getUserByIdCommand.execute(id).map(mapper::mapDomainToDto));
    }

    @Override
    @PutMapping("{id}")
    public UserResponse<Boolean> updatePassword(@PathVariable("id") UUID id, @RequestBody UserEntity entity) throws StandardException, UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream().findFirst().map(Object::toString).orElse("");
        UUID authenticatedUserId = ((UserEntity) authentication.getPrincipal()).getId();
        if ("ROLE_ADMIN".equals(role) || id.equals(authenticatedUserId)) {
            updateUserCommand.execute(id, mapper.mapToDomain(entity));
            return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "Password updated successfully.");
        }
        return new UserResponse<>("error", String.valueOf(HttpStatus.FORBIDDEN), "You don't have permission to update this user's password.");
    }

}
