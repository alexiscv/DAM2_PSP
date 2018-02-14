/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejclientetpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Cliente {

    private String host = "localhost";
    private int puerto = 2000;

    public Cliente() {

        try {
            // Creamos la conexión con el servidor
            Socket sCliente = new Socket(host, puerto);

            // Enviamos el mensaje
            // Para ello tenemos que crear un fichero de datos, que envolveremos
            // con un flujo de datos, este flujo, nos permitirá
            // almacenar de manera sencilla información en el fichero.
            InputStream ficheroEntrada = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(ficheroEntrada);
            
            // Mostramos por pantalla
            System.out.println(flujoEntrada.readUTF());

            // Cerramos la conexión
            sCliente.close();

        } catch (Exception e) {
            System.out.println("Error, quizás el servidor no esté disponible.");
            System.out.println("Error: "+e);
        }

    }

}
