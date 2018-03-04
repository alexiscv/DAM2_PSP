/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.comunicacion;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class PeticionCliente extends Thread {

    /**
     * Atributos
     */
    private Socket sCliente;
    private int puerto;
    static int nAsiento = 0;

    /**
     * Constructor del hilo
     *
     * @param sCliente
     * @param puerto
     */
    public PeticionCliente(Socket sCliente, int puerto) {
        this.sCliente = sCliente;
        this.puerto = puerto;
    }

    /**
     * Ejecución del hilo
     */
    @Override
    public void run() {

        try {
            // Utilizamos el socket para crear los flujos
            // que nos permitirán eviar y recibir
            InputStream entrada = sCliente.getInputStream();
            OutputStream salida = sCliente.getOutputStream();

            // Ahora envolvemos los flujos antes creados
            // Para poder manipularlos más facilmente
            ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);

            System.out.println("-- Hilo Servidor virtual --");

            // Recogemos el Obj. recibido
            Cliente cliente = (Cliente) flujoEntrada.readObject();

            // Calculamos y asignamos un asiento
            System.out.println("Asiento actual = " + nAsiento);
            nAsiento = nAsiento + 1;
            System.out.println("Asigno el asiento = " + nAsiento);
            cliente.setPlaza(nAsiento);

            // Lo enviamos de vuelta al EquipoCliente
            flujoSalida.writeObject(cliente);

            // Notificamos
            System.out.println("// >> Fin del hilo.");

            // Cerramos la conexión
            sCliente.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
