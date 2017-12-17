/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedrapapeltijera;

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

        // Creamos la cuenta atras
        CountDownLatch cuentaAtras = new CountDownLatch(1);

        // Creamos a los jugadores y los lanzamos
        Jugador j1 = new Jugador("Paco", cuentaAtras);
        j1.start();

        Jugador j2 = new Jugador("Mariano", cuentaAtras);
        j2.start();

        // Hacemos una pausa para poder ver como es cierto que 
        // lo hilos se lanzan al realizar el countDown.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Arrancamos los hilos
        cuentaAtras.countDown();
        
        // Esperamos al resto de hilos
        try {
            j1.join();
            j2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Miramos quien ha ganado
        if (j1.getNumero() > j2.getNumero()) {
            System.out.println(j1.getNombre() + " ha ganado");

        } else if (j1.getNumero() < j2.getNumero()) {
            System.out.println(j2.getNombre() + " ha ganado");

        } else {
            System.out.println("Empate.");

        }

    }

}
