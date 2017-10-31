/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojoin;

import static java.lang.Thread.*;

/**
 *
 * @author Alexis
 */
public class Hilo implements Runnable {

    String nombre;

    // Para crear un hilo implementando Runnable 
    // necesitamos hacer estos dos pasos
    //
    // Creamos el hilo
    Thread hilo;

    // Lo iniciamos
    // Creamos un método start para simular la llamda normal 
    // de un hilo craedo con extends y dentro de este método
    // creamos el hilo real, referenciando al propio objeto Hilo (esta clase)
    // y llamamos al start() que realmente pertenece al hilo.
    public void start() {
        hilo = new Thread(this);
        hilo.start();
    }

    // .. fin
    // Constructor
    public Hilo(String nombre) {
        this.nombre = nombre;
        this.start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            try {
                System.out.println("Hilo " + nombre + " i=" + i + ".");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupción del hilo "+nombre);

            }

        }
        
        System.out.println("SALIENDO DEL HILO: "+nombre);

    }

}
