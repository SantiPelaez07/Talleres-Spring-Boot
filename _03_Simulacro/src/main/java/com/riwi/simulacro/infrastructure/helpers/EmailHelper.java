package com.riwi.simulacro.infrastructure.helpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    //Inyección de servicio de email de la libreria
    private final JavaMailSender mailSender;

    private String readHTMLTemplate(String nameUser){
        final Path path = Paths.get("src/main/resources/emails/email_template.html");
        try(var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining(nameUser));
            return html.replace("{nameUser}", nameUser);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
        
}
