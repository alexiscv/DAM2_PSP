/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemchatmulticast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author Alexis Desde este programa enviaremos mensajes por teclado a los
 * clientes
 */
public class Servidor {

    public static void main(String[] args) {

        System.out.println("Iniciando servidor Multicast...");

        try {
            // Creamos el MulticastSocket sin especificar puerto.
            MulticastSocket socket = new MulticastSocket();

            // Creamos el grupo multicast
            InetAddress grupo = InetAddress.getByName("231.0.0.1");

            // Creamos el datagrama vacío en principio:
            // Crear el Datagrama (mensaje, tamaño msj, grupo Multicast y puerto):
            byte[] vacio = new byte[0];
            DatagramPacket paquete = new DatagramPacket(vacio, 0, grupo, 10000);

            // Mientras no escribamos salir
            String mensaje = "";
            while (!mensaje.equals("salir")) {
                // Cargamos el mensaje por teclado
                BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(System.in));
                mensaje = bufferLectura.readLine();

                // Creamos el buffer a enviar
                byte[] buffer = mensaje.getBytes();

                // Pasamos los datos al datagrama y establecemos su longitud
                paquete.setData(buffer);
                paquete.setLength(buffer.length);

                // Enviamos el paquete al grupo Multicast
                socket.send(paquete);
            }
            // Cerramos el socket
            socket.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

}
