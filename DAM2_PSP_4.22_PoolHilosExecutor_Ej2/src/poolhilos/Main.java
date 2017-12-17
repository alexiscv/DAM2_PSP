/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolhilos;

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

        // Creamos el Pool con el número de hilos que puede ejecutar simultaneamente
        ExecutorService ex = Executors.newFixedThreadPool(2);

        // Creamos un pool de 2 hilos
        // que generarán 30 tareas t
        for (int i = 0; i < 30; i++) {

            // Creamos la tarea
            Tarea t = new Tarea("Tarea #" + i);

            // Ejecutamos el Pool
            ex.execute(t);

        }
        ex.shutdown();

    }

}
