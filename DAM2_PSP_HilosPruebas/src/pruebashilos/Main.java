/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebashilos;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Para ejecutar nuestro hilo
        MiHilo elHilo = new MiHilo();
        elHilo.start();
        
        // Podemos seguir codificando el resto del código...
        // Este print se ejecutará aunque el código del hilo aún no haya terminado.
        System.out.println("Yo sigo a lo mio");
        
        
    }
    
}
