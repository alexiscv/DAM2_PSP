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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CountDownLatch cuentaAtras = new CountDownLatch(1);
        System.out.println("Creando Hilos");

        // Creando 50 hilos
        for (int i = 0; i < 50; i++) {

            Trabajador trabajador = new Trabajador(cuentaAtras, "Trabajador #" + i);
            trabajador.start();

        }

        // Hacemos una pausa para poder ver como es cierto que 
        // lo hilos se lanzan al realizar el countDown.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Lanzo los 50 hilos a la vez
        cuentaAtras.countDown();

        /* Otra forma de hacerlo sería crear un CountDownLatch(50) y cada vez que
        lanzo un hilo invocar al objeto CountDownLatch.countDown() para que 
        decremente, en el momento que llegue a 0 se lanzan todos los hilos pendientes
        hasta dicho momento . poniendo 50 sería todos.
         */
    }

}
