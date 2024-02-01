package br.com.elwgomes.registerapi.infra.user.persistence.impl;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.repository.validator.UserValidatorRepository;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
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
        // encode password before saves on db
        String encryptedPasswd = new BCryptPasswordEncoder().encode(user.getPassword());
        // set encoded password
        user.setPassword(encryptedPasswd);
        // save user
        jpaRepository.save(mapper.mapToEntity(user));
    }

    @Override
    public void deleteUser(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(UUID id) {
        Optional<UserEntity> entity = jpaRepository.findById(id);
        return entity.map(mapper::mapToDomain);
    }

    @Override
    public User updatePassword(UUID id, User user) throws StandardException, UserNotFoundException {
        Optional<UserEntity> obj = jpaRepository.findById(id);

        if (!obj.isPresent()) {
            throw new UserNotFoundException("User not found.");
        }
        UserEntity entity = obj.get();
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new StandardException("Something goes wrong");
        }
        String encryptedPasswd = new BCryptPasswordEncoder().encode(user.getPassword());
        entity.setPassword(encryptedPasswd);
        return mapper.mapToDomain(jpaRepository.save(entity));
    }

    @Override
    public Boolean doesUserExists(String username, String document, String email) {
        return jpaRepository.existsByUsernameOrDocumentOrEmail(username, document, email);
    }

    @Override
    public Boolean isUserNameNull(String username) {
        return username == null || username.isBlank() || username.isEmpty();
    }

    @Override
    public Boolean isDocumentNull(String document) {
        return document == null || document.isBlank() || document.isEmpty();
    }

    @Override
    public Boolean isEmailNull(String email) {
        return email == null || email.isBlank() || email.isEmpty();
    }
}
