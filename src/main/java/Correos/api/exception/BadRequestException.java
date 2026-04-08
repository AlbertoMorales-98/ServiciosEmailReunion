package Correos.api.exception;

public class BadRequestException extends ApiBusinessException {

    private static final int STATUS = 400;
    private static final String MESSAGE = "Datos invalidos o mal formados";

    public BadRequestException() {
        super(STATUS, MESSAGE);
    }

    public BadRequestException(Throwable cause) {
        super(STATUS, MESSAGE, cause);
    }
}
