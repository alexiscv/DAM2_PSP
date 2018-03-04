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
import java.util.Scanner;

/**
 *
 * @author Alexis
 */
public class EquipoCliente {

    private static Scanner teclado = new Scanner(System.in);

    /**
     * Construcctor
     */
    public EquipoCliente() {

        // Creamos el Obj. Cliente
        System.out.println("Nombre del cliente:");
        Cliente cliente = new Cliente(teclado.nextLine());

        try {
            // Creamos el socket de conexión
            Socket sCliente = new Socket("localhost", 2000);

            // Utilizamos el socket para crear los flujos
            // que nos permitirán eviar y recibir
            OutputStream salida = sCliente.getOutputStream();
            InputStream entrada = sCliente.getInputStream();

            // Ahora envolvemos los flujos antes creados
            // Para poder manipularlos más facilmente
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);

            // Enviamos el Obj. al servidor
            flujoSalida.writeObject(cliente);

            // Esperamos la respuesta
            // Cuando llegue, recomponemos el objeto
            cliente = (Cliente) flujoEntrada.readObject();

            
            if (cliente.getPlaza() != -1) {
                // Imprimimos el cliente
                System.out.println(cliente.toString());
                
            } else {
                // El bus está lleno
                System.out.println("== BUS LLENO ==");

            }
            
            // Cerramos la conexión
            sCliente.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * Ejecución del Obj.
     *
     * @param args
     */
    public static void main(String[] args) {

        new EquipoCliente();

    }

}
