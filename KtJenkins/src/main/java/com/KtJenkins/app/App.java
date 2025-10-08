package com.KtJenkins.app;

import java.util.logging.Logger;

public class App {
    // Creamos el logger asociado a esta clase
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("Bienvenidos al Kt Mvn-Jenkins-Sonarqube!");
        logger.info("Este es un proyecto de prueba para integrar Jenkins y Sonarqube con Maven usando un pipeline de Azure DevOps y un agente pool.");
        logger.info("Creado por:");
        logger.info("Ernesto Jimenez Huitron");
        logger.info("Softtek :)");
    }
}
