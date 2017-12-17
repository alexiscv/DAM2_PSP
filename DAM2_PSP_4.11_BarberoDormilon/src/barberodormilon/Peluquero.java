/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberodormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Peluquero extends Thread {

    private Peluqueria peluqueria;
    private boolean finJornada = false;

    public Peluquero(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }

    @Override
    public void run() {

        // Mientras los clientes que han venido no sean los mismos que han de ser atendidos 
        // a lo largo de la jornada, el peluquero debe trabajar
        while (!finJornada) {

            // Comprobamos que hay clientes a los que hay que cortar el pelo
            if (peluqueria.isSillonOcupado()) {

                peluqueria.peluqueroAtenderCliente();

            }
            if (peluqueria.getClientesPorJornada() == peluqueria.getClientesQueHanVenido() && peluqueria.getSillasOcupadas() == 0 && !peluqueria.isSillonOcupado()) {

                System.out.println("[End]: Clientes/Jornada: " + peluqueria.getClientesPorJornada()
                        + " | Han venido: " + peluqueria.getClientesQueHanVenido()
                        + " | Atendidos: " + peluqueria.getClientesAtendidos()
                        + " | Sillas ocupadas: " + peluqueria.getSillasOcupadas()
                        + " | Sillón ocupado: " + peluqueria.isSillonOcupado()
                );

                finJornada = true;

            }

        }

        // Si ha terminado su jornada...
        System.out.println("Mi jornada ha terminado, me voy a dormir a mi casa.");
        System.out.println("-- Peluquería cerrada --");

    }

}
