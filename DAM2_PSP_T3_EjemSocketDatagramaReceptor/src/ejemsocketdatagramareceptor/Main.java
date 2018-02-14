/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemsocketdatagramareceptor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int MAX_LEN = 100;                  // Num. máximo de bytes que quiero recibir
        byte buffer[] = new byte[MAX_LEN];  // Array donde recibo los datos

        try {
            
            // Creamos el socket pasandole el puerto
            DatagramSocket socket = new DatagramSocket(2348);

            // Creamos el objeto de tipo DatagramPacket 
            // Le pasamos el array de datos y la longitud del mismo.
            DatagramPacket paquete = new DatagramPacket(buffer, MAX_LEN);
            
            // Llamamos al método receive() del socket pasandole el paquete
            socket.receive(paquete);
            /* El programa se queda esperando hasta que recibe un paquete */
            
            // Reconstruimos los datos a partir del array de datos.
            int longitud = paquete.getLength();
            System.out.println("Paquete recibido. Recibí "+longitud+" bytes.");           
            String mensaje = new String(paquete.getData(),0,longitud);
            System.out.println("Mensaje: "+mensaje);
            
            // Cerramos la conexión
            socket.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
