/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoservidorsincro;

/**
 *
 * @author PCCOM
 */
public class Servidor{

    int contador;
    
    public void acceder(){
        contador++;
        System.out.println("-- Acceso al servidor.");
        System.out.println(Thread.currentThread().getName()+" ha accedido al servidor.");
        System.out.println("Se ha accedido al servidor "+contador+" veces");
        System.out.println("");
    }
    
}
