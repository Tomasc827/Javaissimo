package lt.techin;

public class NotEnoughChangeExceptions extends RuntimeException {
    public NotEnoughChangeExceptions(String message) {
        super(message);
    }
}
