/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Trabajador extends Thread {

    CountDownLatch x;
    String nombre;

    public Trabajador(CountDownLatch x, String nombre) {
        this.x = x;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        // Hacemos que el hilo espere a que la cuenta llegue a 0
        try {
            x.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Ejecutando " + nombre);

    }

}
