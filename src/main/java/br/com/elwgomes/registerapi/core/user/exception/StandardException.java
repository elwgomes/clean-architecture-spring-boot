package br.com.elwgomes.registerapi.core.user.exception;

public class StandardException extends Exception {

    public StandardException(String message) {
        super(message);
    }

    public StandardException(String message, Throwable cause) {
        super(message, cause);
    }

}
