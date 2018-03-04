/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrenciaycomunicacion;

/**
 *
 * @author Alexis
 */
public class Autobus {

    private int nPlazas;
    private Cliente[] plazas;
    private boolean atendiendoPeticion = false;

    /**
     * Constructor
     *
     * @param nPlazas
     */
    public Autobus(int nPlazas) {
        this.nPlazas = nPlazas;
        this.plazas = new Cliente[nPlazas];
    }

    /**
     * Autobus es el recurso compartido así que creamos un método syncronized al
     * que solo podrá acceder un hilo al mismo tiempo y en el que retendremos al
     * hilo hasta que pueda solicitar una plaza
     */
    public synchronized void solicitarPlaza(Cliente cliente) {

        try {

            // Si hay otro Cliente realizando la petición, esperamos
            while (atendiendoPeticion) {
                System.out.println(cliente.getNombre() + " ha intentado solicitar asiendo, pero hay otro Cliente antes, esperamos...");
                wait();
            }

            // Bloqueamos el recurso
            atendiendoPeticion = true;

            // Si podemos hacer la petición...
            // Fingimos que la operación dura medio segundo
            // Para comprobar que hacen el resto de hilos
            System.out.println("[i] " + cliente.getNombre() + " pidiendo plaza...");
            wait(500);

            // Lo primero es saber si hay plazas
            // Si no las hay
            if (plazasLibres() == plazas.length) {
                // El bus está completo, lo notificamos
                System.out.println("== El Bus está Lleno ==");

                // Asignamos -1 para que el hilo se cierre
                cliente.setPlaza(-1);

            } else {
                // Si hay plazas
                // Sentamos al cliente y le asignamos un asiento
                int plaza = plazasLibres();

                // Sentamos al cliente
                plazas[plaza] = cliente;

                // Asignamos la plaza
                System.out.println(">> Asignamos la plaza " + plaza + " al cliente " + cliente.getNombre());
                cliente.setPlaza(plaza);

            }

            // Desbloqueamos el recurso y
            // Despertamos al resto de Hilos
            atendiendoPeticion = false;
            notifyAll();

        } catch (Exception e) {
        }

    }

    /**
     * Nos permite saber cuantas plazas libres hay
     */
    private int plazasLibres() {

        // Recorremos el array de plazas, buscando un null
        // Y calculando la posición
        int i = 0;

        // Mientras i sea inferior al número máx de plazas
        // Y haya una plaza vacía
        while (i < plazas.length && plazas[i] != null) {
            i++;
        }

        return i;

    }

    /**
     * Ver quien ocupa cada asiento
     */
    public void verAsientos() {
        for (int i = 0; i < plazas.length; i++) {

            System.out.print("-> Plaza[" + i + "]: ");

            if (plazas[i] != null) {
                System.out.println(plazas[i].toString());
            } else {
                System.out.println("-");
            }

        }
    }

}
