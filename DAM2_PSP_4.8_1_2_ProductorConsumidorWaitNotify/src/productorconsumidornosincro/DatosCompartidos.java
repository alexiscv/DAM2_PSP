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

    private String cadena;
    public boolean datoDisponible = false;
    private boolean isParar = false;

    /**
     * Para cambiar isParar y detener los hilos consumidores
     */
    public void parar() {
        this.isParar = true;
    }

    /**
     * Para saber el valor de isParar
     *
     * @return
     */
    public boolean isParar() {
        return this.isParar;
    }

    /**
     * Permite almacenar una cadena
     *
     * @param cadena
     */
    public synchronized void almacenarCadena(String cadena) {

        // Creamos un bucle para que mientas haya un dato disponible,
        // este continuamente dentro, esperando a que el dato sea cogido
        while (datoDisponible == true) {

            try {
                System.out.println("       ALMACEN LLENO: Esperando a que el dato sea recogido.");
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
     */
    public synchronized boolean recogerCadena() {

        // Creamos un bucle que nos permita detener el hilo si cuando intenta
        // recoger un dato, este no está disponible
        if (datoDisponible == false) {

            try {
                System.out.println("       ..No hay datos disponible, esperando..");
                Thread.yield(); // Decemos el turno a otro hilo
                wait(); // Y esperamos            
            } catch (Exception e) {
                System.out.println("Error Interrupted. #2");

            }

        } else {

            // Pasamos datosDisponible a false para indicar que no hay datos disponibles
            // Y que es necesario generar un nuevo dato.
            datoDisponible = false;

            // Si no hemos entrado en el bucle, retornamos el valor y notificamos
            // Al resto de hilos
            System.out.println("<-- " + Thread.currentThread().getName() + " : Recojo -> " + cadena);
            notifyAll();

            return true;
        }

        return false;

    }

}
