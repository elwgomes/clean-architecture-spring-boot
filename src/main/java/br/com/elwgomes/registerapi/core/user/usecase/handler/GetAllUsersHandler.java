package br.com.elwgomes.registerapi.core.user.usecase.handler;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.usecase.command.GetAllUsersCommand;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetAllUsersHandler implements GetAllUsersCommand {

    private final UserRepository userRepository;

    @Override
    public Collection<User> execute() {
        return userRepository.getAllUsers();
    }
}
