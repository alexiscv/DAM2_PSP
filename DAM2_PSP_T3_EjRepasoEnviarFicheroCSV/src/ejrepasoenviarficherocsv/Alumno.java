/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejrepasoenviarficherocsv;

import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class Alumno implements Serializable{

    private String nombre;
    private String apellido;
    private int nota1, nota2, nota3;

    public Alumno(String nombre, String apellido, int nota1, int nota2, int nota3) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + '}';
    }

}
