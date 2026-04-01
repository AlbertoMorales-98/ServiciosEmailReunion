package Correos.Reunion.api;

import Correos.api.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import Correos.Reunion.api.dto.MeetingRequest;
import Correos.Reunion.service.EmailServiceReunion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/reuniones")
@RequiredArgsConstructor
public class MeetingController {

    private final EmailServiceReunion emailServiceReunion;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody MeetingRequest request) {
        emailServiceReunion.sendMeetingRequest(request);
        ApiResponse response = new ApiResponse(
                HttpStatus.ACCEPTED.value(),
                "Solicitud de reunion recibida y procesada."
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
