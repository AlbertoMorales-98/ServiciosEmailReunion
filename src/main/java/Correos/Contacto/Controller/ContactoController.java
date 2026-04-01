package Correos.Contacto.Controller;

import Correos.Contacto.Request.ContactoRequest;
import Correos.Contacto.Service.EmailServiceContacto;
import Correos.api.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/contacto")
@RequiredArgsConstructor
public class ContactoController {

    private final EmailServiceContacto emailServiceContacto;

    @PostMapping
    public ResponseEntity<ApiResponse> enviar(@Valid @RequestBody ContactoRequest request) {
        emailServiceContacto.enviarCorreoHtml(request);
        ApiResponse response = new ApiResponse(
                HttpStatus.ACCEPTED.value(),
                "Solicitud de contacto recibida y procesada.",
                "/api/contacto",
                OffsetDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
