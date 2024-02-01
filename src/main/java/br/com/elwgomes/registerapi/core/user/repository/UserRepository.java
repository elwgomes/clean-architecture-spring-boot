package br.com.elwgomes.registerapi.core.user.repository;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    public Collection<User> getAllUsers();
    public void saveUser(User user);
    public void deleteUser(UUID id);
    public Optional<User> findById(UUID id);

    public User updatePassword(UUID id, User user) throws StandardException, UserNotFoundException;
}
