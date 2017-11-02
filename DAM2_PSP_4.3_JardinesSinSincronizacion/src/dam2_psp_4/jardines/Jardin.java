/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.jardines;

/**
 *
 * @author angel
 */
public class Jardin {

    int personas = 0;

    /**
     * Constructor
     * @param personas 
     */
    public Jardin( int personas ) {
        this.personas = personas;
    }    
    
    /**
     * Añade una persona al jardín
     */
    public void incrementarPersonas() {
        personas++;
        System.out.println(Thread.currentThread().getName()+" -> Una persona entra. Personas totales: "+personas);
    }

    /**
     * Elimina una persona del jardin
     */
    public void decrementarPersonas() {
        personas--;
        System.out.println(Thread.currentThread().getName()+" -> Una persona sale. Personas totales: "+personas);
    }

}
