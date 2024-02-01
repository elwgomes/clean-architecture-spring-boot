package br.com.elwgomes.registerapi.core.user.usecase.command;

import br.com.elwgomes.registerapi.core.user.domain.User;

import java.util.Optional;
import java.util.UUID;


public interface GetUserByIdCommand {
    public Optional<User> execute(UUID id);
}
