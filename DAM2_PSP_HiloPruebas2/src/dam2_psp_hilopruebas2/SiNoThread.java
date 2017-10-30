/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_hilopruebas2;

/**
 *
 * @author Alexis
 */
public class SiNoThread extends Thread{
    
    private String siNo;
    
    static int contador = 0;
    
    public SiNoThread(String s){
        super(); // esto no se para que es
        this.siNo = s;
        
    }
    
    @Override
    public void run(){
        int i;
        for (i = 0; i < 200; i++) {
            System.out.print(++contador+":"+siNo+" ");
            
        }
    }
    
}
