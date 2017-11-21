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

        int nDatos = 2;

        DatosCompartidos datosCompartidos = new DatosCompartidos();

        Productor p = new Productor(datosCompartidos, "PRO#1", 3);
        Productor p2 = new Productor(datosCompartidos, "PRO#2", 1);
        Consumidor c = new Consumidor(datosCompartidos, "C#1");
        Consumidor c2 = new Consumidor(datosCompartidos, "C#2");
        Consumidor c3 = new Consumidor(datosCompartidos, "C#3");

        p.start();
        p2.start();
        c.start();
        c2.start();
        c3.start();

    }

}
