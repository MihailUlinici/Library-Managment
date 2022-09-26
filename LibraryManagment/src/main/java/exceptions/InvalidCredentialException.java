package exceptions;

public class InvalidCredentialException extends Throwable {
    public InvalidCredentialException(String errorMessages) {
        super(errorMessages);
    }
}
