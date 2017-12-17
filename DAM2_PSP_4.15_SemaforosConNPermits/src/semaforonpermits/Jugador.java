/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforonpermits;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Jugador extends Thread {

    private Semaphore semaforo;

    public Jugador(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        // Intentamos coger palillos de la cesta
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName() + " JUGADA #" + i);

            // Solicitaremos n palillos
            int numPalillosACoger = (int) (Math.random() * 3) + 1;

            // Comprobamos que existan ese numero de recursos disponibles
            if (semaforo.availablePermits() > numPalillosACoger) {

                // Solicitamos los recursos necesarios
                try {
                    semaforo.acquire(numPalillosACoger);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Notificamos
                System.out.println(Thread.currentThread().getName() + " coge " + numPalillosACoger);
                System.out.println("  -> Quedan" + semaforo.availablePermits());

                // Esperamos un tiempo T
                int tiempoEspera = (int) (Math.random() * 1000) + 500;

                // .. esperando
                try {
                    sleep(tiempoEspera);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Devolvemos n palillos
                int numPalillosADevolver = (int) (Math.random() * numPalillosACoger) + 1;
                semaforo.release(numPalillosADevolver);
                System.out.println(Thread.currentThread().getName() + " devuelve " + numPalillosADevolver);
                System.out.println("  -> Quedan" + semaforo.availablePermits());

            } else {

                // Notificamos que no podemos recoger
                System.out.println("   .. " + Thread.currentThread().getName() + " no puede coger " + numPalillosACoger);

            }

            // Pasamos turno
            yield();

            // Para garantizar que este hilo no vuelve a entrar
            // Lo dormimos medio segundo
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
