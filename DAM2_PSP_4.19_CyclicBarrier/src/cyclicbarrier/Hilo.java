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
public class Hilo extends Thread {

    CyclicBarrier barreraInicio, barreraFin;
    int i;

    public Hilo(CyclicBarrier barreraInicio, CyclicBarrier barreraFin, int i) {
        this.barreraInicio = barreraInicio;
        this.barreraFin = barreraFin;
        this.i = i;
    }

    @Override
    public void run() {

        try {

            System.out.println("Iniciamos el hilo " + i);
            // Detenemos el hilo
            // Que se iniciará cuando se generen 10 hilos
            barreraInicio.await(); 
            
            System.out.println("hilo " + i + " ejecutandose");
            
            // Detenemos el programa hasta que finalice el otro barrier
            barreraFin.await();

        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
