package Correos.api.exception;

public class UnprocessableEntityException extends ApiBusinessException {

    private static final int STATUS = 422;
    private static final String MESSAGE = "Error de validacion de datos";

    public UnprocessableEntityException() {
        super(STATUS, MESSAGE);
    }

    public UnprocessableEntityException(Throwable cause) {
        super(STATUS, MESSAGE, cause);
    }
}
