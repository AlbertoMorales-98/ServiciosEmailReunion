package Correos.Contacto.Controller;

import Correos.Contacto.Request.ContactoRequest;
import Correos.Contacto.Service.EmailServiceContacto;
import Correos.api.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/contacto")
@RequiredArgsConstructor
public class ContactoController {

    private final EmailServiceContacto emailServiceContacto;

    @PostMapping
    public ResponseEntity<ApiResponse> enviar(@Valid @RequestBody ContactoRequest request) {
        emailServiceContacto.enviarCorreoHtml(request);
        return ResponseEntity.ok(new ApiResponse(200, "La peticion fue exitosa"));
    }
}
