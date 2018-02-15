/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Servidor {

    private int puerto = 2000;

    public Servidor() {

        try {

            // Inicio de la escucha del servidor en un determinado puerto ServerSocket
            ServerSocket skServidor = new ServerSocket(puerto);
            System.out.println("Escuchando por el puerto " + puerto);

            for (int i = 0; i < 3; i++) {

                // Esperamos la conexión del cliente, que almacenamos en un Soket cliente
                Socket sCliente = skServidor.accept();

                System.out.println("SIRVO AL CLIENTE " + i);

                // Aquí se atenderían las peticiones del cliente (flujo E o S)
                InputStream flujoEntrada = sCliente.getInputStream();
                DataInputStream datosFlujoEntrada = new DataInputStream(flujoEntrada);

                // Leemos la entrada recibida
                String datos = datosFlujoEntrada.readUTF();
                System.out.println(datos);

                // Cerramos el cliente
                sCliente.close();

            }

            // Cerramos el servidor
            skServidor.close();

        } catch (Exception e) {
            System.out.println("Error:" + e);
        }

    }

}
