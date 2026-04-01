package Correos.Contacto.Request;

import lombok.Data;

@Data
public class ContactoRequest {
    private String nombre;
    private String empresa;
    private String cargo;
    private String email;
    private String telefono;
    private String solucion;
    private String mensaje;
}
