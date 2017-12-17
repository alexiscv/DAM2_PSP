/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaraccesos;

/**
 *
 * @author Alexis
 */
public class Servidor {

    private int accesos = 0;

    public void acceder() {

        System.out.println(Thread.currentThread().getName()+" está accediendo al servidor...");
        accesos++;
        System.out.println("  ..Se ha accedido "+accesos+" veces.");

    }

}
