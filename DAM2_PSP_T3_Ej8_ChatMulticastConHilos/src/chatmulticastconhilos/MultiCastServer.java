/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticastconhilos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Alexis
 */
public class MultiCastServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Uniendose al chat multicast...");
        String host = "231.0.0.1";
        int puerto = 1000;
        String mensaje = new String();

        try {

            // Creamos el socket MultiCast
            MulticastSocket socket = new MulticastSocket(1000);

            // Creamos el grupo multicast
            InetAddress grupo = InetAddress.getByName(host);

            // Comprobamos que el host sea un host válido para el multicast
            if (!grupo.isMulticastAddress()) {
                System.out.println("Error: La IP: " + grupo + " no es una ip multicast de Clase D");
                System.exit(0);
            }

            System.out.println("// Dirección IP válida");

            // Creamos un hilo ChatThread
            // Este hilo funciona como cliente, los mensajes que enviemos desde
            // El Main, los capturará y mostrata el cliente, hasta que escribamos salir
            // Los mensajes también serán recibidos por el resto de Clientes del MultiCast
            new ChatThread(socket).start();

            // Nos unimos al grupo
            socket.joinGroup(grupo);
            System.out.println("// Cliente se ha unido al Grupo");

            // Creamos el datagrama vacío en principio:
            // Crear el Datagrama (mensaje, tamaño msj, grupo Multicast y puerto):
            byte[] vacio = new byte[0];
            DatagramPacket paquete = new DatagramPacket(vacio, vacio.length, grupo, puerto);

            // Mientras no escribamos salir
            while (!mensaje.equals("salir")) {

                // Leemos capturamos el mensaje a enviar
                System.out.println(">");
                BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(System.in));
                mensaje = bufferLectura.readLine();
                System.out.println("-> Mensaje: " + mensaje + " Longitud: " + mensaje.length());

                // Creamos un buffer donde almacenar el mensaje
                byte[] buffer = mensaje.getBytes();

                // Cargamos en el datagrama que había creado vacío, el buffer y su tamaño               
                paquete.setData(buffer);
                paquete.setLength(buffer.length);

                // Enviamos el mensaje
                socket.send(paquete);

            }

            // Cerramos la conexión
            System.out.println("-- Saliendo del Chat");
            socket.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

}
