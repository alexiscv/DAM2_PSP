/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolhilosexecutor_ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Tarea implements Runnable {

    private int sleepTime;
    private String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {
            System.out.println("El hilo de la tarea " + nombre + " va a dormir durante 1 segundo.");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Este hilo ya ha dormido bastane");

    }

}
