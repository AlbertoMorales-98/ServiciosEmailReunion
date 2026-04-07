package Correos.api.exception;

public class UnprocessableEntityException extends ApiBusinessException {

    private static final int CODIGO = 422;
    private static final String NOMBRE = "Unprocessable Entity";
    private static final String DESCRIPCION = "Error de validacion de datos";

    public UnprocessableEntityException() {
        super(CODIGO, NOMBRE, DESCRIPCION);
    }

    public UnprocessableEntityException(Throwable cause) {
        super(CODIGO, NOMBRE, DESCRIPCION, cause);
    }
}
