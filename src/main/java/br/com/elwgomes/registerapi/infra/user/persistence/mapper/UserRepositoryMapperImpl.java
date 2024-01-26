package br.com.elwgomes.registerapi.infra.user.persistence.mapper;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.infra.user.controller.dto.UserDTO;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;

public class UserRepositoryMapperImpl implements UserRepositoryMapper<User, UserEntity, UserDTO> {

    @Override
    public User mapToDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getRole()
        );
    }

    @Override
    public UserEntity mapToEntity(User domain) {
        return new UserEntity(
                domain.getId(),
                domain.getUsername(),
                domain.getPassword(),
                domain.getDocument(),
                domain.getEmail(),
                domain.getRole()
        );
    }

    @Override
    public UserDTO mapEntityToDto(UserEntity entity) {
        return new UserDTO(
                entity.getUsername(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getRole()
        );
    }

    @Override
    public UserDTO mapDomainToDto(User domain) {
        return new UserDTO(
                domain.getUsername(),
                domain.getDocument(),
                domain.getEmail(),
                domain.getRole()
        );
    }

}
