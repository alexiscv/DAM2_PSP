/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg10_bancoparque;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Banco {

    private int plazas;
    private int plazasOcupadas = 0;

    /**
     * Constructor
     *
     * @param plazas
     */
    public Banco(int plazas) {
        this.plazas = plazas;
    }

    /**
     * Método para ocupar una plaza
     *
     * @return
     */
    public synchronized boolean sentarse(String nombre) {

        // Si no hay plazas, esperamos
        if (plazasOcupadas == plazas) {

            // Notificamos que no hay plazas disponibles
            System.out.println("... " + nombre + " intenta sentarse, pero el banco está lleno.");

            // Esperamos a que alguien se levante
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            // Ocupamos una plaza
            plazasOcupadas = plazasOcupadas + 1;

            // Notificamos por pantalla
            System.out.println(nombre + " Se ha sentado.");

            // Retornamos true, para indicar que nos hemos sentado 
            return true;

        }

        return false;

    }

    /**
     * Método para liberar una plaza del banco
     */
    public synchronized void levantarse(String nombre) {

        // Notificamos por pantalla
        System.out.println(nombre + " Se ha levantado.");

        // Libramos una plaza
        plazasOcupadas = plazasOcupadas - 1;

        // Despetamos a todos los hilos
        notifyAll();
    }

    /**
     * Devuelve el número de palzas disponibles
     *
     * @return
     */
    public int getPlazas() {
        return plazas;
    }

    /**
     * Devuelve el número de plazas ocupadas
     *
     * @return
     */
    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

}
