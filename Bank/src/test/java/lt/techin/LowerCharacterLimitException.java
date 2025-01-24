package lt.techin;

public class LowerCharacterLimitException extends RuntimeException {
    public LowerCharacterLimitException(String message) {
        super(message);
    }
}
