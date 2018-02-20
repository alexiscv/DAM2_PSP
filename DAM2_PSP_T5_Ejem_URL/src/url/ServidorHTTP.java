/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 *
 * Para probar, cargar: 
 * http://localhost:8066 
 * http://localhost:8066/quijote
 * http://localhost:8066/a
 */
public class ServidorHTTP {

    // Clases con mensajes sobre el resultado de la conexión
    public class Mensajes {

        public static final String lineaInicial_OK = "HTTP/1.1 200 OK";
        public static final String lineaInicial_NoFound = "HTTP/1.1 404 Not Found";
        public static final String lineaInicial_BadRequest = "HTTP/1.1 400 Bad Request";
    }

    // Clases con la página de nuestro servidor web local
    public class Paginas {

        public static final String primeraCabecera = "Content-Type:text/html;charset=UTF-8";

        // Contenido index
        public static final String html_index = "<html>"
                + "<head><title>index</title></head>"
                + "<body>"
                + "<h1>¡Enhorabuena!</h1>" + "<p>Tu servidor HTTP mínimo funciona correctamente</p>"
                + "</body>"
                + "</html>";

        // Quijote
        public static final String html_quijote = "<html>"
                + "<head><title>quijote</title></head>"
                + "<body>"
                + "<h1>Así comienza el Quijote</h1>"
                + "<p>En un lugar de la Mancha, de cuyo nombre no quiero "
                + "acordarme, no ha mucho tiempo que vivía un hidalgo de los "
                + "de lanza en astillero, adarga antigua, rocín flaco y galgo "
                + "corredor. Una olla de algo más vaca que carnero, salpicón "
                + "las más noches, duelos y quebrantos (huevos con tocino) los "
                + "sábados, lentejas los viernes, algún palomino de añadidura "
                + "los domingos, consumían las tres partes de su hacienda. El "
                + "resto "
                + "della concluían sayo de velarte (traje de paño fino), "
                + "calzas de velludo (terciopelo) para las fiestas con sus "
                + "pantuflos de lo mismo, y los días de entresemana se honraba "
                + "con su vellorí (pardo de paño) de lo más fino. Tenía en su "
                + "casa una ama que pasaba de los cuarenta, y una sobrina que "
                + "no llegaba a los veinte, y un mozo de campo y plaza, que "
                + "así ensillaba el rocín como tomaba la podadera...</p>"
                + "</body>"
                + "</html>";

        // Contenido no encontrado
        public static final String html_noEncontrado = "<html>"
                + "<head><title>noEncontrado</title></head>"
                + "<body>"
                + "<h1>¡ERROR! Página no encontrada</h1>"
                + "<p>La página que solicitaste no existe en nuestro "
                + "servidor</p>"
                + "</body>"
                + "</html>";
    }

    /**
     * Procesa la petición recibida
     */
    private static void procesaPeticion(Socket socketCliente) throws IOException {

        String peticion;
        String html;

        // Flujo de entrada
        InputStreamReader isr = new InputStreamReader(socketCliente.getInputStream());

        // Espacio en memoria para la entrada de peticiones
        BufferedReader bufferLectura = new BufferedReader(isr);

        // Objeto de java.io que entre otras características, permite escribir
        // linea a linea en un flujo de salida
        PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream(), true);
        peticion = bufferLectura.readLine(); // mensaje petición cliente

        // Para compactar la petición y facilitar así su análisis, suprimimos los espacios en blanco
        // que contenga
        peticion = peticion.replaceAll(" ", "");

        // Si realmente se trata de una petición GET que la única que vamos a implementar
        if (peticion.startsWith("GET")) {

            // Extrae la subcadena entre GET y HTTP/1.1
            peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

            // Si correcponde a la página de inicio
            if (peticion.length() == 0 || peticion.equals("/")) {
                // Servimos la página
                html = Paginas.html_index;
                printWriter.println(Mensajes.lineaInicial_OK);
                printWriter.println(Paginas.primeraCabecera);
                printWriter.println("Content-Length: " + html.length() + 1);
                printWriter.println("\n");
                printWriter.println(html);

            } else if (peticion.equals("/quijote")) {
                // Si corresponde a la página del quijote
                // Servimos la página
                html = Paginas.html_quijote;
                printWriter.println(Mensajes.lineaInicial_OK);
                printWriter.println(Paginas.primeraCabecera);
                printWriter.println("Content-Length: " + html.length() + 1);
                printWriter.println("\n");
                printWriter.println(html);

            } else {
                // En cualquier otro caso
                // Servimos la página
                html = Paginas.html_noEncontrado;
                printWriter.println(Mensajes.lineaInicial_OK);
                printWriter.println(Paginas.primeraCabecera);
                printWriter.println("Content-Length: " + html.length() + 1);
                printWriter.println("\n");
                printWriter.println(html);
            }

        }

    }

    /**
     * Muestra un mensaje de Salida que confirma el arranque, y da algunas
     * indicaciones posteriores.
     */
    private static void imprimeDisponible() {

        System.out.println("El Servidor WEB se está ejecutando y permanece a la "
                + "de tu explorador preferido:\n\nhttp://localhost:8066 \npara "
                + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
                + "quijote\n para solicitar una página del Quijote,\n\nhttp://"
                + "localhost:8066/q\n para simular un error");

    }

    /**
     * Procedimiento ppal que asigna a cada petición entrante un socket de
     * cliente, por donde se enviará la respuesta una vez procesada
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            // Asociamos al servidor el puerto 8066
            ServerSocket sServidor = new ServerSocket(8066);

            imprimeDisponible();

            // Creamos el socket para el cliente
            Socket sCliente;

            // Ante una petición entrante, procesa la petición por el
            // socket cliente por donde la recibe
            while (true) { // A la espera de peticiones

                sCliente = sServidor.accept(); // Atiendo un cliente
                System.out.println(">> Atendiendo al cliente");

                procesaPeticion(sCliente);
                // Cierra la conexión entrante
                sCliente.close();
                System.out.println(">> Cliente atendido [end]");

            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorHTTP.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
