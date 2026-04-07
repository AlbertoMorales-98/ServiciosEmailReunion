package Correos.api.exception;

public class NotFoundException extends ApiBusinessException {

    private static final int CODIGO = 404;
    private static final String NOMBRE = "Not Found";
    private static final String DESCRIPCION = "Recurso no encontrado";

    public NotFoundException() {
        super(CODIGO, NOMBRE, DESCRIPCION);
    }

    public NotFoundException(Throwable cause) {
        super(CODIGO, NOMBRE, DESCRIPCION, cause);
    }
}
