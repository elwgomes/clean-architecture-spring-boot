package br.com.elwgomes.registerapi.core.user.exception;

public class FieldCantBeNullException extends Exception {

    public FieldCantBeNullException(String message) {
        super(message);
    }

    public FieldCantBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

}
