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
public class Servidor extends Thread {

    Socket skCliente;
    static final int Puerto = 2000;

    public Servidor(Socket skCliente) {
        this.skCliente = skCliente;
    }

    @Override
    public void run() {
        try {
            // Creo los flujos de entrada y salida
            DataInputStream flujoEntrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(skCliente.getOutputStream());

            // Atender petición del cliente
            flujoSalida.writeUTF(">> Se ha conectado el cliente de forma correcta.");

            // Se cierra la conexión
            skCliente.close();
            System.out.println("[x] Cliente desconectado.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
