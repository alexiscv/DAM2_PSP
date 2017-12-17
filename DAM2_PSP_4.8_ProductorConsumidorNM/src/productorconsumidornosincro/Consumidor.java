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

    public Consumidor(DatosCompartidos datosCompartidos, String nombre) {
        this.datosCompartidos = datosCompartidos;
        this.nombre = nombre;
        this.setName(nombre);
    }

    @Override
    public void run() {

        int contador = 0;
        while (datosCompartidos.isParar() == false) {

            if (datosCompartidos.recogerCadena("<-- " + nombre + " regoce un dato")) {
                contador++; // Incrementamos el número de valores recogidos/consumidos 
            }

        }

        System.out.println("Se acaba el hilo " + nombre + " // He recogido " + contador + " elementos");

    }

}
