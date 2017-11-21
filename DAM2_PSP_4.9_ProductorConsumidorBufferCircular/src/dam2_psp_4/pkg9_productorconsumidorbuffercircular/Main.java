/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg9_productorconsumidorbuffercircular;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos el buffer, que es el recurso compartido
        BufferCircular buffer = new BufferCircular(4);
        
        // Creamos los productores
        Productor p1 = new Productor("P1", 8, buffer);
        Productor p2 = new Productor("P2", 8, buffer);
        
        // Creamos los consumidores
        Consumidor c1 = new Consumidor("CONS1", buffer); 
        Consumidor c2 = new Consumidor("CONS2", buffer); 
        
        p1.start(); // Lanzamos el hilo
        p2.start(); // Lanzamos el hilo
        c1.start(); // Lanzamos el hilo
        c2.start(); // Lanzamos el hilo

    }

}
