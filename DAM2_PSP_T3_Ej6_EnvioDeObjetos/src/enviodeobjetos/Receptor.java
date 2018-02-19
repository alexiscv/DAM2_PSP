/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enviodeobjetos;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import sun.awt.image.ByteArrayImageSource;

/**
 *
 * @author Alexis
 */
public class Receptor {

    public static void main(String[] args) {

        final int longitud = 4096;
        final int puerto = 2000;
        final byte[] buffer = new byte[longitud];

        try {
            // Creamos el socket y permanecemos a la escucha
            DatagramSocket socket = new DatagramSocket(puerto);

            // Creamos un paquete, donde almacenaremos
            // la información que se nos va a enviar
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

            // Esperamos a recibir
            System.out.println("Escuchando y a la espera...");
            socket.receive(paquete);

            // Convertimos el objeto en bytes a Objeto
            ByteArrayInputStream input = new ByteArrayInputStream(paquete.getData());
            ObjectInputStream objInput = new ObjectInputStream(input);

            System.out.println("Origen: " + paquete.getAddress().getCanonicalHostName() + ": " + paquete.getPort());

            Persona p1 = (Persona) objInput.readObject();

            System.out.println("Mensaje recibido: " + p1);

            paquete.setLength(longitud);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

}
