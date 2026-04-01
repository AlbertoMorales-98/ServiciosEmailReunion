package Correos.Contacto.Controller;

import Correos.Contacto.Request.ContactoRequest;
import Correos.Contacto.Service.EmailServiceContacto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacto")
@RequiredArgsConstructor
public class ContactoController {

    private final EmailServiceContacto emailServiceContacto;

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody ContactoRequest request) {
        try {
            emailServiceContacto.enviarCorreoHtml(request);
            return ResponseEntity.accepted().body("Correo enviado con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al enviar: " + e.getMessage());
        }
    }
}
