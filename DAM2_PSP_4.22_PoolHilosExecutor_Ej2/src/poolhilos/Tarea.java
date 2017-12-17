/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Tarea implements Runnable {

    private String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        String cadena = nombre + ": ";

        for (int i = 0; i < 10; i++) {

            int n = (int) (Math.random() * 50) + 1;

            if (i != 9) {
                cadena = cadena + String.valueOf(n) + ", ";
            } else {
                cadena = cadena + String.valueOf(n);
            }

        }

        // Hacemos una pausa, para poder apreciar el Pool
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(cadena);

    }

}
