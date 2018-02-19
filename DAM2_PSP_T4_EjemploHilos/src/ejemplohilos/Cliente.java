/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Cliente {

    static final String host = "localhost";
    static final int puerto = 2000;

    public Cliente() {

        try {
            Socket skCliente = new Socket(host, puerto);

            // Creo los flujos de entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(skCliente.getOutputStream());

            // Tareas que realiza el cliente
            String datos = flujoEntrada.readUTF();
            System.out.println(">> " + datos);

            // Cerramos el socket
            skCliente.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static void main(String[] args) {

        new Cliente();
        new Cliente();

    }

}
