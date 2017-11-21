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
        
        Productor p = new Productor(datosCompartidos, "Productor #1", 5);
        Productor p2 = new Productor(datosCompartidos, "Productor #2", 5);
        Consumidor c = new Consumidor(datosCompartidos, "Consumidor #1", 5);
        Consumidor c2 = new Consumidor(datosCompartidos, "Consumidor #2", 5);
        
        p.start();
        //p2.start();
        c.start();
        //c2.start();
        
    }
    
}
