/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojoin;

/**
 *
 * @author Alexis
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Creamos los hilos, que se ejecutarán automáticamente
        // Porque así está indicado en el constructor
        Hilo hilo1 = new Hilo("A");
        Hilo hilo2 = new Hilo("B");
        Hilo hilo3 = new Hilo("C");
        
        // Mostramos el hilo que está en ejecución en este momento
        System.out.println("Hilo en ejecución: " + Thread.currentThread());        

        // Mostramos el estado de los hilos en este momento
        System.out.println("El hilo1 se está ejecutando?: " + hilo1.hilo.isAlive());
        System.out.println("El hilo2 se está ejecutando?: " + hilo2.hilo.isAlive());
        System.out.println("El hilo3 se está ejecutando?: " + hilo3.hilo.isAlive());

        // Necesitamos detener el trascurso del hilo main hasta que se ejecuten los hilos 1,2 y 3
        // Lo hacemos con JOIN
        try {
            hilo1.hilo.join();
            hilo2.hilo.join();
            hilo3.hilo.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo principal");

        }

        // Mostramos el estado de los hilos en este momento
        System.out.println("El hilo1 se está ejecutando?: " + hilo1.hilo.isAlive());
        System.out.println("El hilo2 se está ejecutando?: " + hilo2.hilo.isAlive());
        System.out.println("El hilo3 se está ejecutando?: " + hilo3.hilo.isAlive());

    }

}
