/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Alexiss
 */
public class LecturaFicheroATravesURLConection1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Ejemplo de lectura de una página web y mostrar su código por pantalla
         */
        try {
            // Se abre la conexión
            URL url = new URL("http://www.chuidiang.com");
            URLConnection conexion = url.openConnection();

            // Lectura
            InputStream flujoEntrada = url.openStream();
            BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            char[] buffer = new char[1000];
            int leido;

            while ((leido = bufferLectura.read(buffer)) > 0) {

                System.out.println(new String(buffer, 0, leido));

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
