package Correos.Reunion.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import Correos.Reunion.api.dto.MeetingRequest;
import Correos.Reunion.service.EmailServiceReunion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reuniones")
@RequiredArgsConstructor
public class MeetingController {

    private final EmailServiceReunion emailServiceReunion;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody MeetingRequest request) {
        emailServiceReunion.sendMeetingRequest(request);
        return ResponseEntity.accepted().body("Solicitud recibida, se enviará un correo con los datos.");
    }
}
