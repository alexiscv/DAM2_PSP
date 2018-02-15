/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Alexis
 */
public class Receiver {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Se requiere 1 argumento en el main.");

        } else {
            int port = Integer.parseInt(args[0]);
            final int MAX_LEN = 10; // Máxima longitud del byte del datagrama a ser recibido

            try {

                // Instanciamos un datagrama socket para recibir el dato
                DatagramSocket mySocket = new DatagramSocket(port);
                byte[] buffer = new byte[MAX_LEN];
                DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
                mySocket.receive(datagram);
                String message = new String(buffer);
                System.out.println(message);
                mySocket.close();

            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }

    }

}
