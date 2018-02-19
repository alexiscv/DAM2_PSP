/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticastconhilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class ChatThread extends Thread {

    private MulticastSocket socket;

    /**
     * Constructor
     *
     * @param socket
     */
    public ChatThread(MulticastSocket socket) {
        this.socket = socket;
    }

    /**
     * Método run Se ejecuta al iniciar al hilo
     */
    @Override
    public void run() {

        String mensaje = "";
        try {

            while (!mensaje.equals("salir")) {

                // Creamos un buffer para crear el datagrama
                byte[] buffer = new byte[1000];

                // Capturamos el datagrama donde almacenaremos el paquete capturado
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                // Recibimos el paquete utilizando el socket
                socket.receive(paquete);

                // Eliminamos los espacio en blanco generados por el exceso de espacio en el buffer
                mensaje = (new String(buffer).trim());

                // Mostramos el mensaje
                System.out.println("\n\nRecibido: \"" + mensaje + "\"\nMensaje Longitud: " + mensaje.length());
                
            }

        } catch (IOException ex) {
            Logger.getLogger(ChatThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerramos el socket
            System.out.println("-- Fin dle hilo");
            socket.close();
        }

    }

}
