/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soketservidor;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Servidor {

    static final int puerto = 2000;

    public Servidor() {
        try {

            // Inicio de la escucha del servidor en un determinado puerto ServerSocket
            ServerSocket skServidor = new ServerSocket(puerto);
            System.out.println("Escuchando el puerto " + puerto);
            
            // Espero a que se conecte un cliente y creo un nuevo socket para el cliente
            Socket sCliente = skServidor.accept();
            
            // Aquí se atenderían las peticiones del cliente (flujo E o S)
            InputStream ficheroEntrada = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(ficheroEntrada);
            
            // Leemos los datos
            String datos = flujoEntrada.readUTF();
            int numero = flujoEntrada.readInt();
            System.out.println("Se ha recibido: "+datos+numero);
            
            // Cerramos...
            sCliente.close();   // Cierro el socket del cliente
            skServidor.close(); // Cierro el socket por el que se ofrece el servicio y acaba el prog.

        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

}
