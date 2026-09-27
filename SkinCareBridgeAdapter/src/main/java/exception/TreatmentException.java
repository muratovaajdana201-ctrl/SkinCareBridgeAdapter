package exception;

public class TreatmentException extends RuntimeException {

    public TreatmentException(String message) {
        super(message);
    }

    public TreatmentException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}
