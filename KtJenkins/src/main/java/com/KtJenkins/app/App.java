package com.KtJenkins.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static FileHandler fileHandler;

    public static void main(String[] args) {
        setupLogger();

        logger.severe("Mensaje SEVERE (error grave)");
        logger.warning("Mensaje WARNING (advertencia)");
        logger.info("Bienvenidos al Kt Mvn-Jenkins-Sonarqube!");
        logger.info("Este es un proyecto de prueba para integrar Jenkins y Sonarqube con Maven usando un pipeline de Azure DevOps y un agente pool.");
        logger.info("Creado por:");
        logger.info("Ernesto Jimenez Huitron");
        logger.info("Softtek :)");

        // Cerramos el handler para asegurarnos que el log se guarde
        if (fileHandler != null) {
            fileHandler.close();
        }
    }

    private static void setupLogger() {
        try {
            // Creamos el FileHandler en modo append = true
            fileHandler = new FileHandler("Reports.txt", true);

            // Formateador simple para que sea legible
            fileHandler.setFormatter(new SimpleFormatter());

            // Evitamos handlers duplicados limpiando los que tenga el logger
            Handler[] handlers = logger.getHandlers();
            for (Handler handler : handlers) {
                logger.removeHandler(handler);
            }

            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // No imprimir en consola también
            logger.setLevel(Level.INFO);
            fileHandler.setLevel(Level.INFO);

        } catch (IOException e) {
            System.err.println("Error configurando logger: " + e.getMessage());
            e.printStackTrace();
        }
    }
}