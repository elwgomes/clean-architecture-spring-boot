package br.com.elwgomes.registerapi.infra.user.persistence.impl;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.repository.validator.UserValidatorRepository;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository, UserValidatorRepository {

    private final UserJpaRepository jpaRepository;
    private final UserRepositoryMapperImpl mapper;

    @Override
    public Collection<User> getAllUsers() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) {
        jpaRepository.save(mapper.mapToEntity(user));
    }

    @Override
    public Boolean doesUserExists(String username, String document, String email) {
        return jpaRepository.existsByUsernameOrDocumentOrEmail(username, document, email);
    }
}
