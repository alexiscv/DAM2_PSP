/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidornosincro;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatosCompartidos datosCompartidos = new DatosCompartidos();
        
        Productor p = new Productor(datosCompartidos, "Pro.", 5);
        Consumidor c = new Consumidor(datosCompartidos, "Con.", 5);
        
        p.start();
        c.start();
        
    }
    
}
