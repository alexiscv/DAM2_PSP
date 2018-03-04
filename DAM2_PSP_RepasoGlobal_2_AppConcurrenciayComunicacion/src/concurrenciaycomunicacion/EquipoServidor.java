/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrenciaycomunicacion;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class EquipoServidor {

    private Autobus autobus = new Autobus(3);
    
    /**
     * Constructor
     */
    public EquipoServidor() {

        try {
            // Creamos el socket del servidor
            ServerSocket sServidor = new ServerSocket(2000);

            // Creamos un bucle infinito que estará esperando
            // Conexiones de clientes
            while (true) {

                // Esperamos una petición
                Socket sCliente = sServidor.accept();

                // La derivamos al hilo, que funciona como srvidor virtual
                new PeticionCliente(sCliente, autobus).start();
                
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * Inicializamos el servidor
     *
     * @param args
     */
    public static void main(String[] args) {

        new EquipoServidor();

    }
}
