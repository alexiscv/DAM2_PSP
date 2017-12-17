/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numeroHilos = 10;

        final CyclicBarrier barreraInicio = new CyclicBarrier(numeroHilos + 1);
        final CyclicBarrier barreraFin = new CyclicBarrier(numeroHilos + 1);

        // Creamos los 10 hilos
        for (int i = 0; i < numeroHilos; i++) {

            Hilo h = new Hilo(barreraInicio, barreraFin, i);
            h.start();

            // Hacemos una pausa
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Cuando sale del bucle los hilos están creados pero frenados
        try {
            barreraInicio.await(); // Fuerza el cyclicBarrier 11, y hace que se ejecuten los hilos
            System.out.println("Levanto la barrera de inicio, todos los hilos han arrancado y los ejecuto");
            Thread.sleep(500);

            barreraFin.await(); // Fuerza el cyclicBarrier 11, y hace que se ejecuten los hilos
            System.out.println("Levanto la barrera de Fin, todos los hilos han arrancado y los ejecuto");
            Thread.sleep(500);

        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Fin
        System.out.println("Finalizando programa");

    }

}
