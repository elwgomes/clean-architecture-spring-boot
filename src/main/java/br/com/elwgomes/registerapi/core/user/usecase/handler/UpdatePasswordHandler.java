package br.com.elwgomes.registerapi.core.user.usecase.handler;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.usecase.command.UpdatePasswordCommand;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdatePasswordHandler implements UpdatePasswordCommand {

    private final UserRepository userRepository;

    @Override
    public User execute(UUID id, User user) throws StandardException, UserNotFoundException {
        userRepository.updatePassword(id, user);
        return user;
    }
}
