package Correos.Contacto.Service;

import Correos.Contacto.Request.ContactoRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceContacto {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoHtml(ContactoRequest request) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo("alberto.morales@dpr.icu");
        helper.setSubject("Nueva Solicitud: " + request.getSolucion());

        String html = "<div style='font-family: Arial; border: 1px solid #ddd; padding: 20px;'>" +
                "<h2>Detalles del Contacto</h2>" +
                "<p><b>Nombre:</b> " + request.getNombre() + "</p>" +
                "<p><b>Empresa:</b> " + request.getEmpresa() + "</p>" +
                "<p><b>Cargo:</b> " + request.getCargo() + "</p>" +
                "<p><b>Email:</b> " + request.getEmail() + "</p>" +
                "<p><b>Teléfono:</b> " + request.getTelefono() + "</p>" +
                "<p><b>Solución:</b> " + request.getSolucion() + "</p>" +
                "<p><b>Mensaje:</b> " + request.getMensaje() + "</p>" +
                "</div>";

        helper.setText(html, true);
        mailSender.send(message);
    }

}
