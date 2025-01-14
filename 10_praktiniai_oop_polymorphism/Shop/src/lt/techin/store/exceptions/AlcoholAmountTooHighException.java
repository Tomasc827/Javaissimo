package lt.techin.store.exceptions;

public class AlcoholAmountTooHighException extends RuntimeException {
    public AlcoholAmountTooHighException(String message) {
        super(message);
    }
}
