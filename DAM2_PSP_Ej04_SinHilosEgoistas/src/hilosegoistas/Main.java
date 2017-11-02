/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosegoistas;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos 3 hilos y los lanzamos
        HiloColor rojo = new HiloColor("Rojo");
        HiloColor azul = new HiloColor("Azul");
        HiloColor verde = new HiloColor("Verde");
        
        rojo.start();
        azul.start();
        verde.start();
        
    }
    
}
