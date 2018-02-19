/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejrepasoenviarficherocsv;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Alexis
 */
public class Receptor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int longitud = 4096;
        final int puerto = 2000;
        final byte[] buffer = new byte[longitud];

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aprobados.dat"));

            while (true) {

                Alumno alumno = null;   // En cada iteración creamos el alumno

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

                // Convertimos el objeto en bytes a Objeto
                // Reconstruimos el Alumno
                alumno = (Alumno) objInput.readObject();

                // Comprobamos si el alumno es NULL
                // En ese caso, terminamos, ya no hay nada que recibir.
                if (alumno == null) {
                    System.out.println("-- Cerrando servidor --");
                    break;

                } else {
                    // Leemos la entrada recibida
                    System.out.println("-> Se ha recibido: " + alumno);

                    // Mostramos y grabamos el alumno
                    System.out.println("// Origen: " + paquete.getAddress().getCanonicalHostName() + ": " + paquete.getPort());                    
                    oos.writeObject(alumno);
                }

                // Cerramos el cliente
                socket.close();

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error " + e);
        }

    }

}
