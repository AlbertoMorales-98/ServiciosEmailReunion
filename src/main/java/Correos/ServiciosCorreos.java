package Correos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "Correos")
public class ServiciosCorreos {

    public static void main(String[] args) {
        SpringApplication.run(ServiciosCorreos.class, args);
    }
}
