package Correos.api.exception;

public class MethodNotAllowedException extends ApiBusinessException {

    private static final int STATUS = 405;
    private static final String MESSAGE = "Metodo HTTP no permitido";

    public MethodNotAllowedException() {
        super(STATUS, MESSAGE);
    }

    public MethodNotAllowedException(Throwable cause) {
        super(STATUS, MESSAGE, cause);
    }
}
