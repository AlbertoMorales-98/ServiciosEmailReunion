package Correos.api.exception;

import Correos.api.ApiResponse;

public abstract class ApiBusinessException extends RuntimeException {

    private final int codigo;
    private final String nombre;
    private final String descripcion;

    protected ApiBusinessException(int codigo, String nombre, String descripcion) {
        super(nombre);
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    protected ApiBusinessException(int codigo, String nombre, String descripcion, Throwable cause) {
        super(nombre, cause);
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public ApiResponse toResponse() {
        return new ApiResponse(codigo, nombre, descripcion);
    }
}
