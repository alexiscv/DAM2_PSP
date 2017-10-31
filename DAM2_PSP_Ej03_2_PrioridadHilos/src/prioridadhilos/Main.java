/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridadhilos;

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

        try {

            // Asignamos la máxima prioridad al proceso MAIN
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

            // Creamos dos hilos con distinta prioridad
            Hilo hiloHight = new Hilo("NormalHight", Thread.NORM_PRIORITY + 2);
            Hilo hiloLow = new Hilo("NormalLow", Thread.NORM_PRIORITY - 2);

            // Los lanzamos
            hiloHight.start();
            hiloLow.start();

            // Detenemos el método MAIN 10 Segundos
            Thread.sleep(1000);

            // Paramos los hilos NH y NL
            hiloHight.stop();
            hiloLow.stop();

            // Mostramos si están vivos y su estado
            System.out.println("El HILO HIGHT ESTÁ VIVO?:" + hiloHight.hilo.isAlive() + " ESTADO: " + hiloHight.hilo.getState());
            System.out.println("El HILO LOW ESTÁ VIVO?:" + hiloLow.hilo.isAlive() + " ESTADO: " + hiloLow.hilo.getState());

            // Rorzamos a que antes de continuar el proceso main se ejecuten
            // y finalicen hiloLOW y hiloHIGH  -- join()
            // Los lanzamos
            hiloHight.hilo.join();
            hiloLow.hilo.join();

            // Mostramos si están vivos y su estado
            System.out.println("El HILO HIGHT ESTÁ VIVO?:" + hiloHight.hilo.isAlive() + " ESTADO: " + hiloHight.hilo.getState());
            System.out.println("El HILO LOW ESTÁ VIVO?:" + hiloLow.hilo.isAlive() + " ESTADO: " + hiloLow.hilo.getState());

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
