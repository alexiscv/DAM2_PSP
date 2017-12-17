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
public class Peluqueria {

    private final int totalSillas;
    private int sillasOcupadas = 0;
    private final int clientesPorJornada;
    private int clientesQueHanVenido = 0;
    private boolean sillonOcupado = false;
    private boolean corteHaTerminado;
    private int clientesAtendidos = 0;

    public Peluqueria(int totalSillas, int clientesPorJornada) {
        this.totalSillas = totalSillas;
        this.clientesPorJornada = clientesPorJornada;
    }

    public int getSillas() {
        return totalSillas;
    }

    public int getSillasOcupadas() {
        return sillasOcupadas;
    }

    public int getClientesPorJornada() {
        return clientesPorJornada;
    }

    public int getClientesQueHanVenido() {
        return clientesQueHanVenido;
    }

    public boolean isSillonOcupado() {
        return sillonOcupado;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public synchronized boolean entrarCliente(String nombre) {

        // Por cada intento incrementamos el nº de clientes que han venido
        clientesQueHanVenido++;

        // Si todas las sillas están ocupadas, el cliente se vá
        if (sillasOcupadas == totalSillas) {
            System.out.println("PELUQUERIA LLENA: " + nombre + " se va sin ser atendido.");
            return false;
        } else {

            // Si hay sitio libre, sentamos al cliente
            System.out.println("--> " + nombre + " se sienta a esperar.");
            sillasOcupadas++;

            // Despues de sentarse, comprueba si el peluquero está ocupado
            while (sillonOcupado) {
                // Mientras el sillón esté ocupado, espera
                try {
                    System.out.println(nombre + " está esperando.");
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("!Error al esperar.");
                }
            }

            // Si el sillón no está ocupado se sienta en el Sillón y libera su silla de espera
            System.out.println("--> " + nombre + " se sienta en el SILLÓN y deja su silla de espera libre.");
            sillonOcupado = true;
            sillasOcupadas--;

            // y despierta al peluqiero para que le corte el pelo            
            System.out.println(nombre + " despierta al peluquero!!!");
            corteHaTerminado = false;
            notifyAll();

            // Esperamos mientras el peluquero hace su trabajo
            while (!corteHaTerminado) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("!Error al esperar mientras nos cortan el pelo.");
                }
            }

            // He terminado, aviso al siguiente cliente
            notify();

            // Y nos vamos
            return true;
        }

    }

    public synchronized void peluqueroAtenderCliente() {

        while (!sillonOcupado) {

            // No hay nadie, así que nos dormimos
            System.out.println("No hay nadie a quien atender... zzZZzzZZZzZZ");

            // Esperamos hasta que nos despierten
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Si el sillón está ocupado
        System.out.println("// Corte de pelo en curso, espere //");

        // Cortamos el pelo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("!Error cortando el pelo");
        }

        // Liberamos el sillón y despertamos a los hilos
        terminarCorte();

    }

    /**
     * Método para despertar a los hilos clientes
     */
    public void terminarCorte() {
        clientesAtendidos++;
        System.out.println("  .. Corte terminado.");
        corteHaTerminado = true;
        sillonOcupado = false;
        notifyAll();
    }

}
