/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidornosincro;

/**
 *
 * @author Alexis
 */
public class Consumidor extends Thread {

    DatosCompartidos datosCompartidos;
    String nombre;
    int numValores;

    public Consumidor(DatosCompartidos datosCompartidos, String nombre, int numValores) {
        this.datosCompartidos = datosCompartidos;
        this.nombre = nombre;
        this.numValores = numValores;
        this.setName(nombre);
    }

    @Override
    public void run() {

        for (int i = 0; i < numValores; i++) {

            // Intentamos recoger una cadena
            datosCompartidos.recogerCadena();

            // Cedemos el turno
            yield();

        }

        System.out.println("Se acaba el hilo " + nombre);

    }

}
