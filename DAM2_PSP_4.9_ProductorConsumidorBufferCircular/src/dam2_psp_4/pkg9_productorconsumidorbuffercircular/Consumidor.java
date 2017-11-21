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
public class Consumidor extends Thread {

    int nValores;           // Valores que insertará en el buffer
    BufferCircular buffer;  // Buffer donde almacenaremos los creados

    /**
     * Constructor
     *
     * @param nombre
     * @param nValores
     */
    public Consumidor(String nombre, BufferCircular b) {
        this.buffer = b;
        this.setName(nombre); // Definimos el nombre del hilo
    }

    /**
     * Método que se ejecuta al lanzar el hilo
     */
    public void run() {

        // Recogemos valores hasta que sea necesario
        while (buffer.get()) {

            System.out.println("TotalValores: " + buffer.getTotalValores());

        }

        System.out.println("-- " + this.getName() + " TERMINO -- ");

    }

}
