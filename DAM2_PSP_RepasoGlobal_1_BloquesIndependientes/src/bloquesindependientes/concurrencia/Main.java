/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.concurrencia;

import static java.lang.Thread.sleep;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos el autobus
        Autobus autobus = new Autobus(2);

        // Creamos una barrera de 10 hilos
        CyclicBarrier barrera = new CyclicBarrier(2);

        // Creamos los clientes
        for (int i = 0; i < 3; i++) {

            // Creamos el Cliente y lanzamos el Hilo de peticion
            new PeticionCliente(barrera, new Cliente("C" + i), autobus).start();

        }

        try {
            System.out.println("Levantamos la barrera");
            // Levantamos la barrera con el await del hilo Main
            barrera.await();

            // Esperamos 2 segundos y mostramos los asientos del autobus
            sleep(5000);
            autobus.verAsientos();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
