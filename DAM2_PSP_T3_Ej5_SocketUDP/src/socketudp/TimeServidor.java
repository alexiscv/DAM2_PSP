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
import java.net.SocketAddress;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class TimeServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Datos del servidor
        byte buffer[] = new byte[256];  // Array donde recibo los datos

        try {

            while (true) {

                System.out.println("Escuchando y esperando al cliente...");

                // Creamos el socket pasandole el puerto
                DatagramSocket socket = new DatagramSocket(9090);

                // Creamos el objeto de tipo DatagramPacket
                // Le pasamos el array de datos y la longitud del mismo.
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                // Llamamos al método receive() del socket pasandole el paquete
                socket.receive(paquete);
                /* El programa esperará hasta recibir un paquete */

                // Cuando nos lleguen, reconstruimos los datos a partir del array de datos
                System.out.println(new String(buffer)); // Mensaje que nos ha enviado el cliente

                // Recogemos la IP del cliente
                InetAddress direccionCliente = paquete.getAddress();
                int puertoCliente = paquete.getPort();

                // Recogemos la hora del servidor y los datos del cliente
                // La fecha la tenemos que almacenar en el buffer
                // pasandola a bytes
                String fechaActual = new Date().toString();
                buffer = fechaActual.getBytes();

                // Enviamos la hora al cliente
                paquete = new DatagramPacket(buffer, buffer.length, direccionCliente, puertoCliente);
                socket.send(paquete);

                // Cerramos
                socket.close();

            }

        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }

}
