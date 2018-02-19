/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Alexis
 */
public class LecturaFicheroATravesURLConectionGrabandoFileHTML {

    public static void main(String[] args) {

        /**
         * Ejemplo de lectura de una página web y escribir a un fichero HTML
         */
        try {
            // Se abre la conexión
            URL url = new URL("http://www.chuidiang.com");
            URLConnection conexion = url.openConnection();

            // Lectura
            InputStream flujoEntrada = url.openStream();

            // Creamos un flujo de salida asociado al destino
            FileOutputStream flujoOutFile = new FileOutputStream("pagina.html");

            // buffer para ir leyendo
            byte[] buffer = new byte[1000];

            // Primera lectura y bucle hasta el final de lo leido en la url
            int leido = flujoEntrada.read(buffer);

            while (leido > 0) {

                // leo en el buffer
                flujoOutFile.write(buffer, 0, leido);

                // grabo en el fichero
                leido = flujoEntrada.read(buffer);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
