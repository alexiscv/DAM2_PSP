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
                
                // Hacemos que se duerma, así que abandonará el procesador para que entre otro hilo
                wait();

            } catch (InterruptedException e) {
                System.out.println("Error Interrupted. #1");

            }

        }

        // Si no entramos al bucle es porque no hay disponible ningun dato, y deberemos
        // de almacenar uno nuevo y pasar la variable a disponible=true
        this.cadena = cadena;
        
        // Mostramos la cadena almacenada por pantalla
        System.out.println("Almacenado "+ cadena);

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
    public synchronized String recogerCadena() {

        // Creamos un bucle que nos permita detener el hilo si cuando intenta
        // recoger un dato, este no está disponible
        if (datoDisponible == false) {

            try {
                System.out.println("       ..No hay datos disponible, esperando..");
                
                // Hacemos que se duerma, así que abandonará el procesador para que entre otro hilo
                wait();
                
            } catch (Exception e) {
                System.out.println("Error Interrupted. #2");

            }

        }

        // Pasamos datosDisponible a false
        datoDisponible = false;
        
        // Mostramos la cadena recogida por pantallas
        System.out.println("Recogida "+ cadena);

        // Si no hemos entrado en el bucle, retornamos el valor y notificamos
        // Al resto de hilos
        notifyAll();
        return this.cadena;

    }

}
