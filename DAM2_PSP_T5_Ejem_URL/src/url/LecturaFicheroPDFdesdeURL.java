/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Alexis
 */
public class LecturaFicheroPDFdesdeURL {

    public static void main(String[] args) {

        try {

            // Se abre la conexión
            URL url = new URL("http://alberguesasturias.com/robots.txt");
            URLConnection conexion = url.openConnection();

            // Lectura
            InputStream flujoEntrada = url.openStream();

            // Crea un flujo de salida asociado a destino
            FileOutputStream flujoOutFile = new FileOutputStream("documento.txt");

            // Buffer para ir leyendo
            byte[] buffer = new byte[1000];

            // Primera lectura y bucle hasta el final
            int leido = flujoEntrada.read(buffer);

            while (leido > 0) {

                // Escribo
                flujoOutFile.write(buffer, 0, leido);

                // Leo
                leido = flujoEntrada.read(buffer);

            }

            File path = new File("documento.txt");
            Desktop.getDesktop().open(path);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
