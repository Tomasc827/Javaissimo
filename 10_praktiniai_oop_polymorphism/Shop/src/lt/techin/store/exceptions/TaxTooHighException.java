package lt.techin.store.exceptions;

public class TaxTooHighException extends RuntimeException {
    public TaxTooHighException(String message) {
        super(message);
    }
}
