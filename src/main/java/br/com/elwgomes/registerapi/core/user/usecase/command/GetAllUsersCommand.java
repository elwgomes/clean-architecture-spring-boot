package br.com.elwgomes.registerapi.core.user.usecase.command;

import br.com.elwgomes.registerapi.core.user.domain.User;

import java.util.Collection;

public interface GetAllUsersCommand {
    public Collection<User> execute();
}
