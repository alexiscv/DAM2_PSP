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
public class HiloSale extends Thread {

    Jardin jargin;  // jardín sobre el que actua
    String nombre;

    public HiloSale(Jardin jargin, String nombre) {
        this.jargin = jargin;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        this.jargin.decrementarPersonas();
    }

}
