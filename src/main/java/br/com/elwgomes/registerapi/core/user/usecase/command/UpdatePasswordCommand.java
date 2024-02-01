package br.com.elwgomes.registerapi.core.user.usecase.command;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;

import java.util.UUID;

public interface UpdatePasswordCommand {
    public User execute(UUID id, User user) throws StandardException, UserNotFoundException;
}
