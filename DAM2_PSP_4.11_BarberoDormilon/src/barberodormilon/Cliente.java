/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberodormilon;

/**
 *
 * @author Alexis
 */
public class Cliente extends Thread {

    private String nombre;
    private Peluqueria peluqueria;

    public Cliente(String nombre, Peluqueria peluqueria) {
        this.nombre = nombre;
        this.peluqueria = peluqueria;
    }

    @Override
    public void run() {

        // Intentamos sentarnos en la sala de espera
        if (peluqueria.getSillas() != peluqueria.getSillasOcupadas()) {

            peluqueria.entrarCliente(nombre);

        }
        
        System.out.println("[end]"+nombre+".");

    }

}
