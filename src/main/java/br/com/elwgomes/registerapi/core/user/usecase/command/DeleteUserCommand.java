package br.com.elwgomes.registerapi.core.user.usecase.command;

import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;

import java.util.UUID;

public interface DeleteUserCommand {
    public void execute(UUID id) throws UserNotFoundException;
}
