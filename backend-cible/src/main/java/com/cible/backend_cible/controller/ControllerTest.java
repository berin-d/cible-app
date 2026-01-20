package com.cible.backend_cible.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @Autowired
    private Environment environment;

    @GetMapping("/config")
    public Map<String, String> getEnvironmentDetails() {
        Map<String, String> envDetails = new HashMap<>();

        // Récupération des propriétés système
        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");

        // Ajouter les propriétés systèmes
        envDetails.put("Java Version", javaVersion);
        envDetails.put("Operating System", osName);
        envDetails.put("User Name", userName);

        // Récupération des propriétés de configuration Spring Boot
        // depuis application.properties
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");

        // Ajouter les propriétés dans la réponse
        envDetails.put("Application Name", appName);
        envDetails.put("Port Number", port);

        return envDetails;
    }
}
