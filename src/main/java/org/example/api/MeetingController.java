package org.example.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.api.dto.MeetingRequest;
import org.example.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reuniones")
@RequiredArgsConstructor
public class MeetingController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody MeetingRequest request) {
        emailService.sendMeetingRequest(request);
        return ResponseEntity.accepted().body("Solicitud recibida, se enviará un correo con los datos.");
    }
}
