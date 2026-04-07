package Correos.api.exception;

public class InternalServerErrorException extends ApiBusinessException {

    private static final int CODIGO = 500;
    private static final String NOMBRE = "Internal Server Error";
    private static final String DESCRIPCION = "Error interno del servidor";

    public InternalServerErrorException() {
        super(CODIGO, NOMBRE, DESCRIPCION);
    }

    public InternalServerErrorException(Throwable cause) {
        super(CODIGO, NOMBRE, DESCRIPCION, cause);
    }
}
