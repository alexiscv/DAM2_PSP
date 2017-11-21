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
public class Productor extends Thread {

    DatosCompartidos datosCompartidos;
    String nombre;
    int numValores;
    int valoresGenerados = 0;

    public Productor(DatosCompartidos datosCompartidos, String nombre, int numValores) {
        this.datosCompartidos = datosCompartidos;
        this.nombre = nombre;
        this.numValores = numValores;
        this.setName(nombre);
    }

    @Override
    public void run() {

        // Incrementamos el total de los valores que se deben generar entre todos los productores
        datosCompartidos.totalDatos(numValores);

        for (int i = 0; i < numValores; i++) {

            datosCompartidos.almacenarCadena("Dato de " + nombre + " (" + i + ")");
            valoresGenerados++;

        }

        System.out.println("       >> Se acaba el hilo " + nombre + " He generado " + valoresGenerados + " valores");

    }

}
