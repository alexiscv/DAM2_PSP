/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrenciaycomunicacion;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Alexis Este hilo se encagará de hacer las funciones de Servidor
 * Virtual Gestionando por separado todas las opciones que recibe el servidor.
 */
public class PeticionCliente extends Thread {

    Socket sCliente;
    private Autobus autobus;

    /**
     * Constructor
     */
    public PeticionCliente(Socket sCliente, Autobus autobus) {
        this.sCliente = sCliente;
        this.autobus = autobus;

    }

    /**
     * Método Run
     */
    @Override
    public void run() {

        try {
            // Utilizamos el socket para crear los flujos
            // que nos permitirán eviar y recibir
            OutputStream salida = sCliente.getOutputStream();
            InputStream entrada = sCliente.getInputStream();

            // Ahora envolvemos los flujos antes creados
            // Para poder manipularlos más facilmente
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);

            // Leemos el Obj. enviado por el Equipo Cliente y que nos ha reenviado el E.Servidor
            Cliente cliente = (Cliente) flujoEntrada.readObject();
            
            // Solicitamos una plaza en el autobús para este cliente
            autobus.solicitarPlaza(cliente);
            
            // Enviamos el Obj. Cliente con su plaza al Equipo Cliente
            flujoSalida.writeObject(cliente);
            
            // Cerramos el socket y el hilo muere
            sCliente.close();            
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
