/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemchatmulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Alexis
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Creamos el MulticastSocket sin especificar puerto.
            MulticastSocket socket = new MulticastSocket();

            // Creamos el grupo multicast
            InetAddress grupo = InetAddress.getByName("231.0.0.1");

            // Creamos el datagrama vacío en principio:
            // Crear el Datagrama (mensaje, tamaño msj, grupo Multicast y puerto):
            byte[] vacio = new byte[0];
            DatagramPacket paquete = new DatagramPacket(vacio, 0, grupo, 10000);

            // ... cargamos el mensaje... en una String mensaje bien por teclado o según procesa.
            String mensaje = "Hola mundo! Esto es un mensaje de prueba.";

            // Creamos el buffer a enviar
            byte[] buffer = mensaje.getBytes();

            // Pasamos los datos al datagrama y establecemos su longitud
            paquete.setData(buffer);
            paquete.setLength(buffer.length);

            // Enviamos el paquete al grupo Multicast
            socket.send(paquete);

            // Cerramos el socket
            socket.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

}
