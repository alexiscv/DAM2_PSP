/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_hilopruebas2;

/**
 *
 * @author angel
 */
public class MiHilo extends Thread{
    
    @Override
    public void run(){
        int i;
        for (i = 0; i < 200; i++) {
            System.out.print("NO ");
        }
    }
    
    
}
