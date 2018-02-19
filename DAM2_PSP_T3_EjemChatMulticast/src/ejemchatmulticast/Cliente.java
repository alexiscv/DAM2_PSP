/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemchatmulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Alexis
 */
public class Cliente {

    public static void main(String[] args) {

        try {

            // Creamos un socket multicast en el puerto 10000
            MulticastSocket socket = new MulticastSocket(10000);
            
            // Configuramos el grupo (IP) a la que nos conectaremos, al Multicast
            InetAddress grupo = InetAddress.getByName("231.0.0.1");

            // Cada uno de los clientes que ejecute la clase se une al grupo Multicast
            socket.joinGroup(grupo);
            
            // Leemos los paquetes enviados por el servidor multicast
            String mensaje = new String();
            while(!mensaje.equals("salir")){
            
                // Los paquetes enviados son de 256 bytes de máximo (es aceptable)
                byte[] buffer = new byte[256];
                
                // Creamos el datagrama en el que recibiremos el paquete del socket
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                
                // Recibimos el paquete del socket
                socket.receive(paquete);
                
                // Adaptamos la información al tamaño de lo que se envió
                // Por si envió menos de 256
                byte[] buffer2 = new byte[paquete.getLength()];
                
                // Copiamos los datos en el nuevo array de tamaño adecuado:
                System.arraycopy(paquete.getData(), 0, buffer2, 0, paquete.getLength());
                
                // Vemos los datos recibidos por pantalla:
                mensaje = new String(buffer2);
                System.out.println(mensaje);
            
            }
            // Salimos del grupo multicast
            socket.leaveGroup(grupo);
            
            // Cerramos el socket de comunicación
            socket.close();
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

}
