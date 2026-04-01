package Correos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app.mail")
public class MailRoutingProperties {

    private String to;
    private String from;
    private Map<String, List<String>> clients = new HashMap<>();

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Map<String, List<String>> getClients() {
        return clients;
    }

    public void setClients(Map<String, List<String>> clients) {
        this.clients = clients;
    }
}
