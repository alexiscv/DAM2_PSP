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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos el servidor
        Servidor servidorWeb = new Servidor();
        
        // Creamos los 4 terminales que accederán 10 veces al servidor
        // Accesos
        for (int i = 0; i < 10; i++) {
            new HiloTerminal("Terminal #"+i,servidorWeb).start();
            
        }
        
    }
    
}
