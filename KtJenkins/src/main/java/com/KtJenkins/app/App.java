package com.KtJenkins.app;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenidos al Kt Mvn-Jenkins-Sonarqube!");
        System.out.println("Softtek Ernesto Jimenez Huitron");
        System.out.println(":)");

        // Mostrar imagen en ventana
        JFrame frame = new JFrame("Imagen en Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Cambia la ruta por la ubicación de tu imagen
                ImageIcon icon = new ImageIcon("C:\\Users\\ernesto.jimenez\\OneDrive - Softtek\\Documents\\Pictures\\Firma2.jpeg");
                JLabel label = new JLabel(icon);
                frame.getContentPane().add(label);
                frame.pack();
                frame.setVisible(true);
            }
        }