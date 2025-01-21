package lt.techin.exceptions;

public class NameOrIdTooShortException extends RuntimeException {
    public NameOrIdTooShortException(String message) {
        super(message);
    }
}
