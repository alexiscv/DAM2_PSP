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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos la peluquería
        Peluqueria peluqueria = new Peluqueria(5, 10);

        // Creamos el peluquero
        Peluquero peluquero = new Peluquero(peluqueria);

        // Creamos los clientes
        Cliente cliente1 = new Cliente("Anakin", peluqueria);
        Cliente cliente2 = new Cliente("Jar Jar", peluqueria);
        Cliente cliente3 = new Cliente("Obi Wan", peluqueria);
        Cliente cliente4 = new Cliente("Leia", peluqueria);
        Cliente cliente5 = new Cliente("Boba Fet", peluqueria);
        Cliente cliente6 = new Cliente("Han Solo", peluqueria);
        Cliente cliente7 = new Cliente("Chewaka", peluqueria);
        Cliente cliente8 = new Cliente("Lando", peluqueria);
        Cliente cliente9 = new Cliente("Yoda", peluqueria);
        Cliente cliente10 = new Cliente("Palpatine", peluqueria);
        
        // Iniciamos los Hilos
        peluquero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();
        cliente9.start();
        cliente10.start();
    }

}