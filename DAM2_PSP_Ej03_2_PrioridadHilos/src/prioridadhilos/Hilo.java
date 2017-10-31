/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridadhilos;

/**
 *
 * @author Alexis
 */
public class Hilo implements Runnable {

    // Atributos
    Thread hilo;
    int contador = 0;
    volatile boolean running = true;
    // Esta  variable  booleana  la  utilizaremos  para  crear  un  bucle  infinito  y  volatile 
    // asegura  que  el  valor  de  la  variable  será  examinado  en  cada  una  de  las iteraciones. 
    // Sin  el  uso de volátile, Java  es libre para  optimizar el  bucle de  tal manera que el valor de ejecución
    // se lleva a cabo en un registro de la CPU, y no necesariamente es de nuevo examen con cada iteración. El uso de volátile
    // impide esta optimización que hace el Java, diciendo que la ejecución de Java puede cambiar de  manera que no está
    // directamente relacionada  con la  apariencia del código

    // Contructor
    public Hilo(String nombre, int prioridad) {
        // Creamos el hilo
        hilo = new Thread(this);

        hilo.setName(nombre);
        hilo.setPriority(prioridad);

    }

    @Override
    public void run() {

        while (running) {

            this.contador++;

        }
        System.out.println("hilo: "+Thread.currentThread().getName()+" contador="+contador);

    }

    // Como estamos implementando Runnable hay que crear un método start()
    public void start() {
        hilo.start();
    }

    /**
     * Método para detener el bucle infinito
     */
    public void stop() {
        running = false;
    }

}
