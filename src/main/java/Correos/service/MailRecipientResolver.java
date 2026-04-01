package Correos.service;

import Correos.config.MailRoutingProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MailRecipientResolver {

    private final MailRoutingProperties properties;

    public String[] resolveRecipients(String clientKey) {
        if (clientKey == null || clientKey.isBlank()) {
            return new String[]{properties.getTo()};
        }

        List<String> recipients = properties.getClients().get(normalize(clientKey));
        if (recipients == null || recipients.isEmpty()) {
            return new String[]{properties.getTo()};
        }

        return recipients.toArray(String[]::new);
    }

    public String getDefaultFrom() {
        return properties.getFrom();
    }

    private String normalize(String clientKey) {
        return clientKey.trim().toLowerCase(Locale.ROOT);
    }
}
