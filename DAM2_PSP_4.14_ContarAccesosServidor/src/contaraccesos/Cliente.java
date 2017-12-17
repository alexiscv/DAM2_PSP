/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaraccesos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Cliente extends Thread {

    private Servidor servidor;
    private Semaphore semaforo;

    public Cliente(Servidor servidor, Semaphore semaforo) {
        this.servidor = servidor;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        for (int i = 0; i < 2; i++) {

            // Capturo el recurso
            try {
                semaforo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Accedo
            servidor.acceder();

            // Librero el recurso
            semaforo.release();

            // Paso el turno en el CPU
            yield();

        }

    }

}
