package br.com.elwgomes.registerapi.core.user.repository.validator;

public interface UserValidatorRepository {
    public Boolean doesUserExists(String username, String document, String email);
    public Boolean isUserNameNull(String username);
    public Boolean isDocumentNull(String document);
    public Boolean isEmailNull(String email);
}
