/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enviodeobjetos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Alexis
 */
public class Emisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Persona p = new Persona("Alexis", 32);
        String host = "localhost";
        ObjectOutputStream objOut = null;
        int puerto = 2000;

        try {

            // Conseguimos la dirección IP del nombre de host
            InetAddress direccionIP = InetAddress.getByName(host);

            // Creamos el socket de conexión
            DatagramSocket socket = new DatagramSocket();

            // Convertimos el objeto a bytes
            ByteArrayOutputStream objetoByte = new ByteArrayOutputStream(4096);
            objOut = new ObjectOutputStream(objetoByte);
            objOut.writeObject(p);

            // Creamos el paquete donde almacenar la información
            DatagramPacket paquete = new DatagramPacket(objetoByte.toByteArray(), objetoByte.size(), direccionIP, puerto);

            // Enviamos el paquete, usando el socket
            socket.send(paquete);
            System.out.println("Enviado -> " + p.toString());
            
            // Cerrar socket
            socket.close();

        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }

}
