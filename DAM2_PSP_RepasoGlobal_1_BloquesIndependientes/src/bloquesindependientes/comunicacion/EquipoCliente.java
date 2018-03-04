/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.comunicacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class EquipoCliente {

    private String host = "localhost";
    private int puerto = 2000;
    private static Scanner teclado = new Scanner(System.in);
    private Cliente cliente;

    /**
     * Constructor
     */
    public EquipoCliente() {

        try {
            // Creamos el Obj. Cliente, preguntando antes el nombre
            System.out.println("Nombre del cliente: ");
            cliente = new Cliente(teclado.nextLine());

            // Creamos la conexión con el servidor
            Socket sCliente = new Socket(host, puerto);
            System.out.println("Conexión establecida");

            // Utilizamos el socket para crear los flujos
            // que nos permitirán eviar y recibir
            OutputStream salida = sCliente.getOutputStream();
            InputStream entrada = sCliente.getInputStream();            

            // Ahora envolvemos los flujos antes creados
            // Para poder manipularlos más facilmente
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);              

            // Enviamos el Obj. cliente al servidor para que le asigne un asiento
            flujoSalida.writeObject(cliente);
            System.out.println(">> : "+cliente.toString());

            // Recogemos la respuesta
            cliente = (Cliente) flujoEntrada.readObject();
            
            // Mostramos la respuesta
            System.out.println("<< : "+cliente.toString());

            // Cerramos la conexión
            sCliente.close();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EquipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Main, inicia la ejecución
     */
    public static void main(String[] args) {
        // Lanzamos el Cliente
        new EquipoCliente();
    }

}
