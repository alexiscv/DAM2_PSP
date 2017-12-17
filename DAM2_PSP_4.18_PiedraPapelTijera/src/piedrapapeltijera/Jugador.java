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
public class Jugador extends Thread {

    private String nombre;
    private CountDownLatch x;
    private int numero;

    public Jugador(String nombre, CountDownLatch x) {
        this.nombre = nombre;
        this.x = x;
    }

    @Override
    public void run() {

        try {
            // Nos paramos hasta que el CountDownLatch nos llame
            x.await();

        } catch (InterruptedException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Elegimos un número entre el 1 y el 3
        // Para simplificar el ejercicio, ganará el número más alto
        numero = (int) (Math.random() * 3) + 1;

        System.out.println(nombre + " he sacado " + numero);

    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

}
