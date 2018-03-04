/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.concurrencia;

/**
 *
 * @author Alexis
 */
public class Cliente {

    private String nombre;
    private int numPlaza = -99;

    /**
     * Constructor
     */
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPlaza() {
        return numPlaza;
    }

    public void setNumPlaza(int numPlaza) {
        this.numPlaza = numPlaza;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", numPlaza=" + numPlaza + '}';
    }

}
