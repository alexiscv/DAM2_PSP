/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Alexis
 */
public class Sender {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Se requieres 3 argumentos (servidor, puerto, mensaje) en el main");
        } else {

            try {
                System.out.println(args[0] + "  " + args[1] + "  " + args[2]);

                // Agrupamos los valores
                InetAddress receiverHost = InetAddress.getByName(args[0]);
                int receiverPort = Integer.parseInt(args[1]);
                String message = args[2];

                // Los mostramos
                System.out.println("Host: " + receiverHost);
                System.out.println("Puerto: " + receiverPort);
                System.out.println("Mensaje: " + message);
                
                // Instanciamos un datagram socket para enviar los datos
                DatagramSocket mySocket = new DatagramSocket();
                byte[] buffer = message.getBytes();
                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
                mySocket.send(datagram);
                
                System.out.println("Datagrama enviado");
                
                mySocket.close();

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }

    }

}
