/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.comunicacion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class EquipoServidor {

    public static void main(String[] args) {

        /**
         * Atributos del servidor
         */
        final int puerto = 2000;

        try {

            // Creamos el socket y permanecemos a la escucha
            ServerSocket serverSocket = new ServerSocket(puerto);

            // Ejecutamos en recursivamente el servidor
            while (true) {

                // Esperamos una conexión
                System.out.println("Esperando conexión...");
                Socket skCliente = serverSocket.accept();
                System.out.println("Conexión aceptada, procesando...");

                // Cuando entre una petición
                // La derivamos a un hilo que la gestionará
                // actuando como servidor virtual
                // Le pasaremos el socket de conexión del cliente
                new PeticionCliente(skCliente, puerto).start();                
                
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

}
