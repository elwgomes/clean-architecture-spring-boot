package br.com.elwgomes.registerapi.core.user.usecase.command;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.FieldCantBeNullException;
import br.com.elwgomes.registerapi.core.user.exception.UserAlreadyExistsException;

public interface SaveUserCommand {
    public void execute(User user) throws UserAlreadyExistsException, FieldCantBeNullException;
}
