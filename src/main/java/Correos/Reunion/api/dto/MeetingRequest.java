package Correos.Reunion.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String empresa;

    @NotBlank
    private String cargo;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\s-]{7,20}$", message = "telefono debe incluir solo dígitos y '+' opcional")
    private String telefono;

    @NotBlank
    private String tipoReunion;

    @NotBlank
    private String solucion;

    @NotBlank
    private String modalidad;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String fechas;

    @NotBlank
    private String horario;

    @NotBlank
    private String ciudad;
}
