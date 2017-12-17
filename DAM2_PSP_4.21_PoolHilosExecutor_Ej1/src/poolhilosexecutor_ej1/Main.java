/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolhilosexecutor_ej1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Comienza la ejecución.");

        // Creamos el Pool con el número de hilos que puede ejecutar simultaneamente
        ExecutorService ex = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {

            // Si descomentamos esta linea veremos que aunque el bucle va 
            // creando las tareas, no se ejecutan hasta que el pool lo ordena
            //System.out.println("Vuelta " + i);

            // Creamos el hilo
            Tarea t = new Tarea("Tarea #" + i);

            // Ejecutamos el Pool
            ex.execute(t);

        }
        ex.shutdown();

    }

}
