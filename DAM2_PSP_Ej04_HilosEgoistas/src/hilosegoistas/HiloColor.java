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
public class HiloColor extends Thread{

    String nomColor;

    /**
     * Constructor
     *
     * @param nomColor
     */
    public HiloColor(String nomColor) {
        this.nomColor = nomColor;
    }
   

    /**
     * Método run para iniciar el hilo
     */
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            
            System.out.println(nomColor+i);

        }

    }

}
