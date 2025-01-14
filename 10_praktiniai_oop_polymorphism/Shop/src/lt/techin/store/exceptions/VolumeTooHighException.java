package lt.techin.store.exceptions;

public class VolumeTooHighException extends RuntimeException {
    public VolumeTooHighException(String message) {
        super(message);
    }
}
