package lt.techin;

public class UpperCharacterLimitException extends RuntimeException {
    public UpperCharacterLimitException(String message) {
        super(message);
    }
}
