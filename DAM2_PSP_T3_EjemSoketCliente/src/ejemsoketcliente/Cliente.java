/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemsoketcliente;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Cliente {

    private String host = "localhost";
    private int puerto = 2000;

    public Cliente() {

        try {
            // Crear la conexión con el servidor
            Socket sCliente = new Socket(host, puerto);

            // ... aquí irían las tareas que realiza el cliente, flujo E o S
            // Para permitir que el cliente pueda enviar información a la red
            //OutputStream ficheroSalida = sCliente.getOutputStream();
            // Para permitir que el cliente pueda recibir información de la red
            //InputStream ficheroEntrada = sCliente.getInputStream();
            
            // Creamos la salida sobre el socket del cliente sCliente
            OutputStream ficheroSalida = sCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(ficheroSalida);
            
            // Cargamos lo que queremos enviar
            flujoSalida.writeUTF("Hola Mundo Cruel!");
            flujoSalida.writeInt(50);
            
            System.out.println("{Enviado}");

            // Cerrar el socket de conexión
            sCliente.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
