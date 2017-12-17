/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidornosincro;

/**
 *
 * @author Alexis
 */
public class DatosCompartidos {

    private String cadena;
    private boolean datoDisponible = false;
    private boolean isParar = false;
    private int nDatos = 0;

    /**
     * Nos permite incrementar el total de datos a crear según se creen
     * Productores
     *
     * @param n
     */
    public synchronized void totalDatos(int n) {
        nDatos = nDatos + n;
        System.out.println("       ..Creado " + Thread.currentThread().getName() + " debe generar " + n + " datos (Total " + datosRestantes() + ")");
    }

    /**
     * Devulve el valor de nDatos
     *
     * @return
     */
    public synchronized int datosRestantes() {
        return this.nDatos;
    }

    /**
     * Nos permite decrementar en 1 el valor de nDatos
     */
    public synchronized void restarDato() {
        nDatos--;
    }

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
                wait();

            } catch (InterruptedException e) {
                System.out.println("Error Interrupted. #1");

            }

        }

        // Mensaje por pantalla
        System.out.println("--> " + Thread.currentThread().getName() + " : Almaceno -> " + cadena);

        // Si no entramos al bucle es porque no hay disponible ningun dato, y deberemos
        // de almacenar uno nuevo y pasar la variable a disponible=true
        this.cadena = cadena;

        // Restamos 1 al total de datos generados, para que cuando lleguemos a 0 poder detener los hilos
        this.restarDato();

        // Pasamos datosDisponible a true
        datoDisponible = true;

        // Despertamos a todos los hilos
        notifyAll();

        // Si ya hemos generados el total de datos detenemos los hilos consumidores
        if (nDatos == 0) {
            parar();
        }

    }

    /**
     * Permite recoger el valor de cadena
     *
     * @return
     */
    public synchronized boolean recogerCadena(String cadena) {

        // Creamos un bucle que nos permita detener el hilo si cuando intenta
        // recoger un dato, este no está disponible
        if (datoDisponible == false) {

            try {
                System.out.println("       ..No hay datos disponible, esperando..");
                wait(); // Y esperamos            
            } catch (InterruptedException e) {
                System.out.println("Error Interrupted. #2");

            }

        } else {

            // Si no hay datos disponibles puede ser por dos razones
            // Puede ser que aún no se haya generado un dato a recoger
            // O puede ser que los hilos productores ya hayan terminado de producir datos
            // Si ya no se van a producir más datos tenemos que detener los hilos colectores
            // Comprobamos entonces que aún no se haya mandado parar de recolectar
            if (!isParar()) {
                
                // Recogemos                
                System.out.println(cadena);
                
                // Pasamos datosDisponible a false para indicar que no hay datos disponibles
                // Y que es necesario generar un nuevo dato.
                datoDisponible = false;

                // Si no hemos entrado en el bucle, retornamos el valor y notificamos
                // Al resto de hilos
                notifyAll();

                return true;
                
            }
        }

        return false;

    }

}
