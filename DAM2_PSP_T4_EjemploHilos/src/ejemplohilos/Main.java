/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Main {

    public static void main(String[] args) {

        int puerto = 2000;

        try {

            // Inicio del servidor en el puerto
            ServerSocket skServidor = new ServerSocket(puerto);
            System.out.println("Escucho el puerto " + puerto);

            while (true) {
                // Se conecta un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado.");

                // Atiendo al cliente mediante un thread
                new Servidor(skCliente).start();

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
