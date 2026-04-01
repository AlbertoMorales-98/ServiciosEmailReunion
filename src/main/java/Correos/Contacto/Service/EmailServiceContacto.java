package Correos.Contacto.Service;

import Correos.Contacto.Request.ContactoRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceContacto {
    private final JavaMailSender mailSender;

    @Value("${app.mail.to}")
    private String defaultRecipient;

    @Value("${app.mail.from}")
    private String defaultFrom;

    public void enviarCorreoHtml(ContactoRequest request) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(defaultFrom);
            helper.setTo(defaultRecipient);
            helper.setReplyTo(request.getEmail());
            helper.setSubject("Nueva solicitud: " + request.getSolucion());

            String html = "<div style='font-family: Arial; border: 1px solid #ddd; padding: 20px;'>" +
                    "<h2>Detalles del Contacto</h2>" +
                    "<p><b>Nombre:</b> " + escape(request.getNombre()) + "</p>" +
                    "<p><b>Empresa:</b> " + escape(request.getEmpresa()) + "</p>" +
                    "<p><b>Cargo:</b> " + escape(request.getCargo()) + "</p>" +
                    "<p><b>Email:</b> " + escape(request.getEmail()) + "</p>" +
                    "<p><b>Telefono:</b> " + escape(request.getTelefono()) + "</p>" +
                    "<p><b>Solucion:</b> " + escape(request.getSolucion()) + "</p>" +
                    "<p><b>Mensaje:</b> " + escape(request.getMensaje()) + "</p>" +
                    "</div>";

            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException | MailException e) {
            throw new IllegalStateException("No se pudo enviar el correo de contacto.", e);
        }
    }

    private String escape(String value) {
        if (value == null || value.isBlank()) {
            return "-";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
