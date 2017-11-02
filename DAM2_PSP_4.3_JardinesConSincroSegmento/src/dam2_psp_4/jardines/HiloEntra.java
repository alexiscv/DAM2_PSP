/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.jardines;

/**
 *
 * @author Alexis
 */
public class HiloEntra extends Thread {

    Jardin jardin;  // jardín sobre el que actua
    String nombre;

    public HiloEntra(Jardin jargin, String nombre) {
        this.jardin = jargin;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        synchronized(jardin){
            jardin.incrementarPersonas();
        }
    }

}
