/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaraccesos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        Servidor servidor = new Servidor();

        Cliente c1 = new Cliente(servidor, semaforo);
        Cliente c2 = new Cliente(servidor, semaforo);
        Cliente c3 = new Cliente(servidor, semaforo);
        Cliente c4 = new Cliente(servidor, semaforo);
        Cliente c5 = new Cliente(servidor, semaforo);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

    }

}
