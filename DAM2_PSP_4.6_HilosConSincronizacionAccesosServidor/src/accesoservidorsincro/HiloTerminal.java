/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoservidorsincro;

/**
 *
 * @author PCCOM
 */
public class HiloTerminal extends Thread {

    Servidor servidor;

    /**
     * COnstructor
     *
     * @param nombre
     * @param servidor
     */
    public HiloTerminal(String nombre, Servidor servidor) {
        this.setName(nombre);
        this.servidor = servidor;
    }

    @Override
    public void run() {

        // Accedemos de forma sincronizada para acaparar el recurso
        synchronized (servidor) {
            servidor.acceder();
        }

    }

}
