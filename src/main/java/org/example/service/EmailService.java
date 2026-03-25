package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.MeetingRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.to}")
    private String defaultRecipient;

    @Value("${app.mail.from}")
    private String defaultFrom;

    public void sendMeetingRequest(MeetingRequest request) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.setFrom(defaultFrom);
            helper.setTo(defaultRecipient);
            helper.setSubject("Nueva solicitud de reunión: " + request.getNombre());
            helper.setText(buildHtmlBody(request), true);
            helper.setReplyTo(request.getEmail());
            mailSender.send(message);
            log.info("Correo enviado correctamente a {} para {}", defaultRecipient, request.getNombre());
        } catch (MessagingException | MailException e) {
            log.error("Error al enviar correo de reunión", e);
            throw new IllegalStateException("No se pudo enviar el correo", e);
        }
    }

    private String buildHtmlBody(MeetingRequest r) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        return """
                <html>
                  <body style="font-family: 'Segoe UI', sans-serif; background:#f7f9fb; padding:24px; color:#1f2d3d;">
                    <div style="max-width:640px; margin:0 auto; background:#ffffff; border-radius:12px; box-shadow:0 10px 30px rgba(0,0,0,0.08); overflow:hidden;">
                      <div style="background:linear-gradient(135deg,#1f8ef1,#3358f4); color:#fff; padding:18px 24px;">
                        <h2 style="margin:0;">Solicitud de reunión</h2>
                        <p style="margin:4px 0 0; opacity:.9;">Recibida el %s</p>
                      </div>
                      <div style="padding:24px;">
                        %s
                      </div>
                      <div style="background:#f0f4f8; padding:16px 24px; font-size:12px; color:#5f6b7a;">
                        Este mensaje fue generado automáticamente desde el formulario de reuniones. Responde directamente para contactar al solicitante.
                      </div>
                    </div>
                  </body>
                </html>
                """.formatted(timestamp, buildDetails(r));
    }

    private String buildDetails(MeetingRequest r) {
        StringBuilder sb = new StringBuilder();
        appendRow(sb, "Nombre", r.getNombre());
        appendRow(sb, "Empresa", r.getEmpresa());
        appendRow(sb, "Cargo", r.getCargo());
        appendRow(sb, "Correo", r.getEmail());
        appendRow(sb, "Teléfono", r.getTelefono());
        appendRow(sb, "Tipo de reunión", r.getTipoReunion());
        appendRow(sb, "Solución de interés", r.getSolucion());
        appendRow(sb, "Modalidad", r.getModalidad());
        appendRow(sb, "Descripción", r.getDescripcion());
        appendRow(sb, "Fechas sugeridas", r.getFechas());
        appendRow(sb, "Horario sugerido", r.getHorario());
        appendRow(sb, "Ciudad", r.getCiudad());
        return sb.toString();
    }

    private void appendRow(StringBuilder sb, String label, String value) {
        sb.append("<div style=\"display:flex; margin-bottom:12px;\">")
                .append("<div style=\"flex:0 0 180px; font-weight:600; color:#4b5563;\">")
                .append(label)
                .append("</div>")
                .append("<div style=\"flex:1; color:#111827;\">")
                .append(value == null || value.isBlank() ? "-" : escape(value))
                .append("</div>")
                .append("</div>");
    }

    private String escape(String value) {
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
