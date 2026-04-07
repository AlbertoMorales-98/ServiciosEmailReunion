package Correos.api.exception;

public class MethodNotAllowedException extends ApiBusinessException {

    private static final int CODIGO = 405;
    private static final String NOMBRE = "Method Not Allowed";
    private static final String DESCRIPCION = "Metodo HTTP no permitido";

    public MethodNotAllowedException() {
        super(CODIGO, NOMBRE, DESCRIPCION);
    }

    public MethodNotAllowedException(Throwable cause) {
        super(CODIGO, NOMBRE, DESCRIPCION, cause);
    }
}
