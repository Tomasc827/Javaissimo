package lt.techin.store.exceptions;

public class NameTooLongException extends RuntimeException {
    public NameTooLongException(String message) {
        super(message);
    }
}
