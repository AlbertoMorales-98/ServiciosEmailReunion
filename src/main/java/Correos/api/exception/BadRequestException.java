package Correos.api.exception;

public class BadRequestException extends ApiBusinessException {

    private static final int CODIGO = 400;
    private static final String NOMBRE = "Bad Request";
    private static final String DESCRIPCION = "Datos invalidos o mal formados";

    public BadRequestException() {
        super(CODIGO, NOMBRE, DESCRIPCION);
    }

    public BadRequestException(Throwable cause) {
        super(CODIGO, NOMBRE, DESCRIPCION, cause);
    }
}
