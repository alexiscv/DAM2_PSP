/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg9_productorconsumidorbuffercircular;

/**
 *
 * @author Alexis
 */
public class Productor extends Thread {
   
    int nValores;           // Valores que insertará en el buffer
    BufferCircular buffer;  // Buffer donde almacenaremos los creados

    /**
     * Constructor
     *
     * @param nombre
     * @param nValores
     */
    public Productor(String nombre, int nValores, BufferCircular b) {
        this.nValores = nValores;
        this.buffer = b;
        this.setName(nombre); // Definimos el nombre del hilo
        this.buffer.incrementaTotalValores(nValores); // Incrementamos el total de valores que se crearán en el buffer
    }

    /**
     * Método que se ejecuta al lanzar el hilo
     */
    public void run() {

        // Creamos un for que insertarán valores
        // Siendo n el número que indiquemos al crear el hilo 
        for (int i = 0; i < nValores; i++) {
            
            // Llámamos al método del buffer para añadir un valor
            buffer.put(i);            

        }
        
        System.out.println("-- " + this.getName() + " TERMINO -- ");

    }

}
