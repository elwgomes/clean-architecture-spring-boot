package br.com.elwgomes.registerapi.infra.user.controller.impl;

import br.com.elwgomes.registerapi.core.user.exception.UserAlreadyExistsException;
import br.com.elwgomes.registerapi.core.user.usecase.command.GetAllUsersCommand;
import br.com.elwgomes.registerapi.core.user.usecase.command.SaveUserCommand;
import br.com.elwgomes.registerapi.infra.user.controller.UserResource;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController implements UserResource {

    private final GetAllUsersCommand getAllUsersCommand;
    private final SaveUserCommand saveUserCommand;

    private final UserRepositoryMapperImpl mapper;

    @Override
    @GetMapping
    public UserResponse<Collection<UserDTO>> getAllUsers() {
        return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "OK",
                getAllUsersCommand.execute()
                        .stream()
                        .map(mapper::mapDomainToDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    @PostMapping
    public UserResponse<Boolean> saveUser(@RequestBody UserEntity entity) throws Exception {
        try {
            saveUserCommand.execute(mapper.mapToDomain(entity));
        } catch (UserAlreadyExistsException e) {
            throw new Exception(e);
        }
        return new UserResponse<>("success", String.valueOf(HttpStatus.OK), "New user has been created.");
    }
}
