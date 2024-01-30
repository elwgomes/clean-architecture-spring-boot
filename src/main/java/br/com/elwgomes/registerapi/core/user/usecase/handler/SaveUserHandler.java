package br.com.elwgomes.registerapi.core.user.usecase.handler;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.core.user.exception.FieldCantBeNullException;
import br.com.elwgomes.registerapi.core.user.exception.UserAlreadyExistsException;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.repository.validator.UserValidatorRepository;
import br.com.elwgomes.registerapi.core.user.usecase.command.SaveUserCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveUserHandler implements SaveUserCommand {

    private final UserRepository userRepository;
    private final UserValidatorRepository validator;


    @Override
    public void execute(User user) throws UserAlreadyExistsException, FieldCantBeNullException {
        if (validator.isUserNameNull(user.getUsername()) || validator.isDocumentNull(user.getDocument()) || validator.isEmailNull((user.getEmail()))) {
            throw new FieldCantBeNullException("One or more mandatory fields were not provided.");
        }
        if (validator.doesUserExists(user.getUsername(), user.getDocument(), user.getEmail())) {
            throw new UserAlreadyExistsException("User already exists.");
        }
        userRepository.saveUser(user);
    }

}
