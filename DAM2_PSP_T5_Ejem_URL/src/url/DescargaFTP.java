/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Alexis
 */
public class DescargaFTP {

    //objeto de la clase FTPClient de Apache, con diversos métodos para
    //interactuar y recuperar un archivo de un servidor FTP
    private static FTPClient clienteFTP;
    //flujo de salida para la escritura de datos en un fichero
    private static FileOutputStream ficheroObtenido;
    //URL del servidor
    private static String servidorURL = "ftp.rediris.es";
    //ruta relativa (en Servidor FTP) de la carpeta que contiene
    //el fichero que vamos a descargar
    private static String rutaFichero = "debian";
    //nombre del fichero (aunque carece de extensión, se trata de un fichero de
    //texto que puede abrise con el bloc de notas)
    private static String nombreFichero = "FILE_FTP_DESCARGADO";
    //usuario
    private static String usuario = "anonymous";
    //contraseña
    private static String password = "";
    //array de carpetas disponibles
    private static String[] nombreCarpeta;

    public static void main(String[] args) {

        try {

            int reply;

            //creación del objeto cliente FTP
            clienteFTP = new FTPClient();

            //conexión del cliente al servidor FTP
            clienteFTP.connect("ftp.rediris.es");

            //omprobación de la conexión
            reply = clienteFTP.getReplyCode();

            //si la conexión  es satisfactoria
            if (FTPReply.isPositiveCompletion(reply)) {

                //abre una sesión con el usuario anónimo
                clienteFTP.login(usuario, password);

                //lista las carpetas de primer nivel del servidor FTP
                System.out.println("Carpetas disponibles en el Servidor:");

                nombreCarpeta = clienteFTP.listNames();
                
                for (int i = 0; i < nombreCarpeta.length; i++) {
                    System.out.println(nombreCarpeta[i]);
                }

                //nombre que el que va a recuperarse
                ficheroObtenido = new FileOutputStream(nombreFichero);

                //mensaje
                System.out.println("\nDescargando el fichero " + nombreFichero + " de "
                        + "la carpeta " + rutaFichero);

                //recupera el contenido del fichero en el Servidor, y lo escribe en el
                //nuevo fichero del directorio del proyecto            
                clienteFTP.retrieveFile("/" + rutaFichero + "/", ficheroObtenido);

                //cierra el nuevo fichero
                ficheroObtenido.close();

                //cierra la conexión con el Servidor
                clienteFTP.disconnect();

                // Notificamos
                System.out.println("Descarga finalizada correctamente");

            } else {
                //desconecta
                clienteFTP.disconnect();
                System.err.println("FTP ha rechazado la conexión esblecida");
                System.exit(1);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
