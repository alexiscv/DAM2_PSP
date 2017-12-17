/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Exchanger<String> v_exchanger = new Exchanger<>();
        
        Amigo amigo1 = new Amigo("amigo1", v_exchanger);
        Amigo amigo2 = new Amigo("amigo2", v_exchanger);
        
        amigo1.start();
        amigo2.start();        
        
    }
    
}
