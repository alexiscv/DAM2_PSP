/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdatagramaemisor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Creamos un objeto que representa la dirección IP
            InetAddress hostReceptor = InetAddress.getByName("localhost");

            // Creamos el socket
            DatagramSocket socket = new DatagramSocket();

            // Creamos el mensaje y lo representamos en un array de bytes
            String mensaje = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de... FIN";
            byte[] datos = mensaje.getBytes(); // Transformar la cadena a bytes

            // Creamos el obj. de tipo DatagramPacket pasándole los datos, su longitud, la dirección
            // y el puerto donde enviar el datagrama
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, hostReceptor, 2348);

            // Enviamos usando el socket, al que pasamos el paquete
            socket.send(paquete);

            // Cerramos
            socket.close();
            System.out.println("-- Fin del envio --");
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
