/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidornosincro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class DatosCompartidos {

    private int cadena;
    public boolean datoDisponible = false;

    /**
     * Permite almacenar una cadena
     *
     * @param cadena
     */
    public synchronized void almacenarCadena(int cadena) {

        // Creamos un bucle para que mientas haya un dato disponible,
        // este continuamente dentro, esperando a que el dato sea cogido
        while (datoDisponible == true) {

            try {
                System.out.println("..Esperando a que el dato sea recogido.");
                Thread.yield(); // Cedemos el turno a otro hilo
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error Interrupted. #1");

            }

        }

        // Si no entramos al bucle es porque no hay disponible ningun dato, y deberemos
        // de almacenar uno nuevo y pasar la variable a disponible=true
        this.cadena = cadena;

        // Pasamos datosDisponible a true
        datoDisponible = true;

        // Despertamos a todos los hilos
        notifyAll();

    }

    /**
     * Permite recoger el valor de cadena
     *
     * @return
     */
    public synchronized int recogerCadena() {

        // Creamos un bucle que nos permita detener el hilo si cuando intenta
        // recoger un dato, este no está disponible
        if (datoDisponible == false) {

            try {
                System.out.println("..No hay datos disponible, esperando..");
                Thread.yield(); // Decemos el turno a otro hilo
                wait(); // Y esperamos            
            } catch (Exception e) {
                System.out.println("Error Interrupted. #2");

            }

        }

        // Pasamos datosDisponible a false
        datoDisponible = false;

        // Si no hemos entrado en el bucle, retornamos el valor y notificamos
        // Al resto de hilos
        notifyAll();
        return this.cadena;

    }

}
