/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Alexis
 */
public class DataTimeCliente {

    public static void main(String[] args) {

        byte[] buffer = new byte[256];

        try {

            // Creamos el socket para la conexión
            DatagramSocket socket = new DatagramSocket();

            // Creamos el mensaje que vamos a enviar al servidor
            // El mensaje lo tenemos que enviar en bytes
            String mensaje = "Cliente Conectado.";
            buffer = mensaje.getBytes();

            // Creamos el paquete que enviaremos por la red
            // El paquete llevará los datos, la longitud de los datos
            // la dirección de destino y el porto de escucha
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, host, 9090);
            System.out.println("Cliente solicitando conexión...");

            // Enviamos el paquete a traves del socket
            socket.send(paquete);

            // Ahora esperamos la respuesta del servidor
            System.out.println("Mensaje enviado. Esperando respuesta del servidor...");

            // Reseteamos el paquete creando una nueva instancia y cargar en el los datos
            // Que nos ha enviado el servidor
            paquete = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete);
            System.out.println("Servidor: " + new String(paquete.getData()));

            // Cerramos
            socket.close();

        } catch (IOException e) {
            System.out.println("Error " + e);

        }

    }

}
