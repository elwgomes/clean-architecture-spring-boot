package br.com.elwgomes.registerapi.infra.user.controller;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UserResource {
    public UserResponse<Collection<UserDTO>> getAllUsers();
    public UserResponse<Boolean> saveUser(UserEntity entity) throws Exception;
    public UserResponse<Boolean> deleteUser(UUID id) throws UserNotFoundException;
    public UserResponse<Optional<UserDTO>> findUserById(UUID id) throws UserNotFoundException;
    public UserResponse<Boolean> updatePassword(UUID id, UserEntity entity) throws StandardException, UserNotFoundException;

}
