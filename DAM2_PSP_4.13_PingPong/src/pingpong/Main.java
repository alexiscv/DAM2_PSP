/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore pelota = new Semaphore(1);
        
        HiloPingPong jugador1 = new HiloPingPong("PING", pelota);
        HiloPingPong jugador2 = new HiloPingPong("PONG", pelota);
        
        jugador1.start();
        jugador2.start();
        
    }
    
}
