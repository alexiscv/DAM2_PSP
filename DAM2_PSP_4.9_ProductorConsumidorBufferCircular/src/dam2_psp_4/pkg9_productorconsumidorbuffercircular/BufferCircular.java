/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg9_productorconsumidorbuffercircular;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class BufferCircular {

    private int[] arrayBuffer;      // Array donde almacenar los n elementos dle buffer
    private int posicionActual = 0;
    private int maxElementosBuffer;
    private int totalValores = -1;   // Cuando se crea un productor se incrementa esta variable, para saber cuando freanar los hilos

    public BufferCircular(int maxElementosBuffer) {
        this.maxElementosBuffer = maxElementosBuffer;
        arrayBuffer = new int[maxElementosBuffer];
    }

    /**
     * Método para incrementar el total de valores que se espera generar
     * mediante los productores este valor se incrementa al crear un productor y
     * se reduce cuando un consumidor recoge un valor all llegar a 0 se detienen
     * los hilos
     *
     * @param n
     */
    public void incrementaTotalValores(int n) {
        totalValores = totalValores + n;
    }

    /**
     * Nos permite conocer el total de los valores Recordar que este valor se
     * decrementa cada vez que un consumidor toma un valor del buffer
     *
     * @return
     */
    public int getTotalValores() {
        return totalValores;
    }

    /**
     * Método para saber si el buffer está lleno Comprobamos si estamos en la
     * última posición del array
     */
    public boolean isFull() {

        if (posicionActual == maxElementosBuffer) {
            return true;

        } else {
            return false;

        }
    }

    /**
     * Método para saber si el buffer está lleno Comprobamos si estamos en la
     * última posición del array
     */
    public boolean isEmpty() {

        if (posicionActual == 0) {
            return true;

        } else {
            return false;

        }
    }

    /**
     * Permite almacenar un número en el buffer
     */
    public synchronized void put(int n) {

        // Comprobamos que quede espacio en el buffer
        while (isFull()) {

            try {
                System.out.println(".." + Thread.currentThread().getName() + " esperando");
                // Si está lleno, paramos el hilo
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferCircular.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Si el buffer tiene espacio libre añadimos y descontamos un espacio
        // Para descontar un espacio, sumamos 1 a la posiciónActual
        // Cuando la posiciónActual sea igual al MaxElementosBuffer, el Buffer estará lleno
        // También usamos la posición actual para saber donde añadir el valor dentro del array
        arrayBuffer[posicionActual] = n;        // Añadir valor
        System.out.println(Thread.currentThread().getName() + " PUT " + n); // Notificamos por pantalla
        posicionActual = posicionActual + 1;    // Correr una posición el array
        notifyAll();                            // Despertamos a todos los hilos

    }

    /**
     * Permite retornar un número en el buffer
     */
    public synchronized boolean get() {

        // Si no quedan números que retornar, paramos los hilos consumidores
        if (totalValores != -1) {
            
            // Comprobamos que el buffer no esté vacio
            // Es decir, tiene que tener algún valor que coger
            while (isEmpty()) {

                try {
                    System.out.println(".." + Thread.currentThread().getName() + " esperando");
                    // Si está lleno, paramos el hilo
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BufferCircular.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            // Si hay información, realizamos las operaciones.
            //System.out.println("Tomamos el valor de = "+(posicionActual-1));
            int valorQueRecoge = arrayBuffer[posicionActual - 1];
            System.out.println(Thread.currentThread().getName() + " GET " + valorQueRecoge); // Notificamos por pantalla
            posicionActual = posicionActual - 1;    // Correr una posición el array
            totalValores = totalValores - 1;        // Restamos 1 al total de valores que se deben generar, al llegar a 0 se detienen los hilos
            notifyAll();                            // Despertamos a todos los hilos

            return true;

        } else {
            return false;
        }

    }

}
