package com.KtJenkins.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static FileHandler fileHandler;

    public static void main(String[] args) {

        try {
            fileHandler = new FileHandler("Reports.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

            logger.setUseParentHandlers(false);

            logger.setLevel(Level.INFO);
            fileHandler.setLevel(Level.INFO);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al crear FileHandler", e);
        }

        logger.severe("Mensaje SEVERE (error grave)");
        logger.warning("Mensaje WARNING (advertencia)");
        logger.info("Bienvenidos al Kt Mvn-Jenkins-Sonarqube!");
        logger.info("Este es un proyecto de prueba para integrar Jenkins y Sonarqube con Maven usando un pipeline de Azure DevOps y un agente pool.");
        logger.info("Creado por:");
        logger.info("Ernesto Jimenez Huitron");
        logger.info("Softtek :)");

        if (fileHandler != null) {
            fileHandler.close();
        }
    }
}
