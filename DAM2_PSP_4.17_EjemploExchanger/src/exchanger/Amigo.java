/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Amigo extends Thread {

    private final String nombre;
    private final Exchanger<String> cita;

    public Amigo(String nombre, Exchanger<String> cita) {
        this.nombre = nombre;
        this.cita = cita;
    }

    @Override
    public void run() {

        try {
            
            sleep((int) (10 * Math.random()));
            System.out.println(nombre + " esperando...");

            // Se queda esperando a otro objeto del mismo tipo
            // hasta que llega el segundo y se produce el intercambio
            String intercambio = cita.exchange("regalo de " + nombre);
            System.out.println(nombre + " : " + intercambio);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Amigo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
