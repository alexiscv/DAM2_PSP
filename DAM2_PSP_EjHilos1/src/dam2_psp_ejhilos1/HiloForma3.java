/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_ejhilos1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class HiloForma3 implements Runnable{
    
    // Peculiaridad forma 3
    // Creamos un HILO
    Thread hiloForma3;
    
    // LO INICIAMOS
    public void start(){
        hiloForma3 = new Thread(this);
        hiloForma3.start();
        
    }
    // Fin peculiaridad
    
    String nombreHilo;
    int tiempoDormido;

    public HiloForma3(String nombreHilo) {
        this.nombreHilo = nombreHilo;
        
        //genero un tiempo aleatorio entre 1000 y 6000 milisengundos (1 y 6 seg)
        //tiempo = (int) (Math.random()*(max-min))+min
        this.tiempoDormido = ((int) (Math.random() * 5000) + 1000);
    }

    @Override
    public void run() {
        
        System.out.println("HILO "+nombreHilo+" se va a dormir: "+tiempoDormido+"segs...");
        
        try {
            Thread.sleep(tiempoDormido);
        } catch (InterruptedException ex) {
            System.out.println("Error al dormir el hilo: "+nombreHilo);
        }
        
        System.out.println("HILO "+this.nombreHilo+" SE HA DESPERTADO");        
        
    }
    
}
