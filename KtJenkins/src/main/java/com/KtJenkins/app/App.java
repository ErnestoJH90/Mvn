package com.KtJenkins.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            // Crear un FileHandler para escribir en "app.log", con append activado
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter()); // Formato legible

            // Añadir el FileHandler al logger
            logger.addHandler(fileHandler);

            // Opcional: evitar que se impriman mensajes duplicados en consola
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Bienvenidos al Kt Mvn-Jenkins-Sonarqube!");
        logger.info("Este es un proyecto de prueba para integrar Jenkins y Sonarqube con Maven usando un pipeline de Azure DevOps y un agente pool.");
        logger.info("Creado por:");
        logger.info("Ernesto Jimenez Huitron");
        logger.info("Softtek :)");
    }
}
