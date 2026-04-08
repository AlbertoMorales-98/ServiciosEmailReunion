package Correos.api.exception;

public class NotFoundException extends ApiBusinessException {

    private static final int STATUS = 404;
    private static final String MESSAGE = "Recurso no encontrado";

    public NotFoundException() {
        super(STATUS, MESSAGE);
    }

    public NotFoundException(Throwable cause) {
        super(STATUS, MESSAGE, cause);
    }
}
