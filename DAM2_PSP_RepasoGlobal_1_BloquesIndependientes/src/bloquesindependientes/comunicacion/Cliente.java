/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloquesindependientes.comunicacion;

import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class Cliente implements Serializable {

    private String nombre;
    private int plaza;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", plaza=" + plaza + '}';
    }

}
