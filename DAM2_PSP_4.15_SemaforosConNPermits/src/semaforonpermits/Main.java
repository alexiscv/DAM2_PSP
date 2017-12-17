/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforonpermits;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos el semaforo que actuará como cesta
        Semaphore cesta = new Semaphore(6);
        
        // Creamos a los jugadores
        Jugador j1 = new Jugador(cesta);
        Jugador j2 = new Jugador(cesta);
        Jugador j3 = new Jugador(cesta);
        
        // Los lanzamos
        j1.start();
        j2.start();
        j3.start();
        
    }
    
}
