package br.com.elwgomes.registerapi.core.user.repository;

import br.com.elwgomes.registerapi.core.user.domain.User;

import java.util.Collection;

public interface UserRepository {
    public Collection<User> getAllUsers();
    public void saveUser(User user);
}
