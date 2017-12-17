/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class HiloPingPong extends Thread {

    private String sonidoJugador;
    private Semaphore pelota;
    static private String ultimoSonido = "";

    public HiloPingPong(String nombre, Semaphore pelota) {
        this.sonidoJugador = nombre;
        this.pelota = pelota;
    }

    @Override
    public void run() {

        int i = 0;

        while (i <= 10) {

            // Si no es el mimso jugador, golpeamos y contamos el golpe
            if (!ultimoSonido.equals(sonidoJugador)) {

                i++;

                // Adquirimos el recurso
                try {
                    pelota.acquire();

                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Emitimos nuestro sonido
                System.out.println(sonidoJugador + " ");

                // Guardamos nuestro sonido para que el siguiente sonido
                // no sea el nuestro
                ultimoSonido = sonidoJugador;

                // Liberamos el recurso
                pelota.release();

                // Pasamos el turno
                yield();

            }

        }

    }

}
