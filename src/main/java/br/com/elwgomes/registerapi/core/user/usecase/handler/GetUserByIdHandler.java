package br.com.elwgomes.registerapi.core.user.usecase.handler;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.usecase.command.GetAllUsersCommand;
import br.com.elwgomes.registerapi.core.user.usecase.command.GetUserByIdCommand;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class GetUserByIdHandler implements GetUserByIdCommand {

    private final UserRepository userRepository;

    @Override
    public Optional<User> execute(UUID id) {
        return userRepository.findById(id);
    }
}
