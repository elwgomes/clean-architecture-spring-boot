package br.com.elwgomes.registerapi.infra.user.controller;

import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;

import java.util.Collection;

public interface UserResource {
    public UserResponse<Collection<UserDTO>> getAllUsers();
    public UserResponse<Boolean> saveUser(UserEntity entity) throws Exception;
}
