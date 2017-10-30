/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_ejhilos1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alexis
 */
public class DAM2_PSP_EjHilos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cuantos hilos deseas crear?");

        // Número de hilos que vamos a crear
        int nHilos = teclado.nextInt();

        // Bucle para crearlos
        for (int i = 0; i < nHilos; i++) {

            // Creamos el hilo
            Hilo hilo = new Hilo("HILO #" + i);

            // Iniciamos el hilo
            //hilo.start();
        }

        /**
         * Segunda forma de crear un hilo esta vez implementamos Runnable
         */
        for (int i = 0; i < nHilos; i++) {
            HiloForma2 claseRunnable = new HiloForma2("HILO F2 #" + i); // Creamos un objeto Runnable
            Thread hilo2 = new Thread(claseRunnable);                   // Creamos el hilo
            //hilo2.start();                                              // Ejecutamos el hilo
        }

        /**
         * Tercera forma de crear un hilo esta vez implementamos Runnable y
         * dentro de la clase, iniciamos el hilo
         */
        for (int i = 0; i < nHilos; i++) {
            HiloForma3 hilo3 = new HiloForma3("HILO F3 #" + i);     // Creamos el hilo
            hilo3.start();                                          // Ejecutamos el hilo
        }

    }

}
