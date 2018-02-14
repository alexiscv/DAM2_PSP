/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejservidortpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            System.out.println("Escuchando el puerto " + puerto);
            
            // Vamos a aceptar 3 peticiones antes de cerrar el servidor
            for (int i = 0; i < 3; i++) {

                // Espero a que se conecte un cliente y creo un nuevo socket para el cliente
                Socket sCliente = skServidor.accept();
                System.out.println("Sirvo al Cliente " + i);

                // Comunicación con el Cliente            
                // 1.- Fichero que se enviará al cliente
                OutputStream ficheroSalida = sCliente.getOutputStream();

                // 2.- Flujo de datos para cargar información al fichero
                DataOutputStream flujoSalida = new DataOutputStream(ficheroSalida);

                // 3.- Cargamos el contenido
                flujoSalida.writeUTF("Hola cliente "+i);   
                
                // Cierro el cliente
                sCliente.close();

            }

            // Cerramos el servidor
            skServidor.close();            

            System.out.println("-- Se han atendido las 3 peticiones. Cerramos el servicio --");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
