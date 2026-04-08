package Correos.api.exception;

public class InternalServerErrorException extends ApiBusinessException {

    private static final int STATUS = 500;
    private static final String MESSAGE = "Error interno del servidor";

    public InternalServerErrorException() {
        super(STATUS, MESSAGE);
    }

    public InternalServerErrorException(Throwable cause) {
        super(STATUS, MESSAGE, cause);
    }
}
