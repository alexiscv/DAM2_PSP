/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.concurrencia;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Alexis
 */
public class PeticionCliente extends Thread {

    /**
     * Los parametros del hilo serán el autobus, el cliente y la barrera
     */
    CyclicBarrier barrera;
    Cliente cliente;
    Autobus autobus;

    /**
     * Contructor Lo llamaremos desde el Main, pasandole todos los elementos
     */
    public PeticionCliente(CyclicBarrier barrera, Cliente cliente, Autobus autobus) {
        this.barrera = barrera;
        this.cliente = cliente;
        this.autobus = autobus;
    }

    /**
     * Arrancamos el Hilo
     */
    @Override
    public void run() {

        // Notificamos
        System.out.println("-> Cliente " + cliente.getNombre() + " LANZADO");

        // Lo primero que haremos, será frenar le hilo
        // Continuará cuando se levante la barrera
        try {
            barrera.await();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // Realizamos la petición
        autobus.solicitarAsiento(cliente);

        System.out.println("TERMINA El cliente " + cliente.getNombre() + ".");

    }

}
