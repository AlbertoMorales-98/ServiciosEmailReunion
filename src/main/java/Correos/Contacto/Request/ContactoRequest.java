package Correos.Contacto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ContactoRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    private String empresa;

    @NotBlank
    private String cargo;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\s-]{7,20}$", message = "telefono debe incluir solo digitos y '+' opcional")
    private String telefono;

    @NotBlank
    private String solucion;

    @NotBlank
    private String mensaje;
}
