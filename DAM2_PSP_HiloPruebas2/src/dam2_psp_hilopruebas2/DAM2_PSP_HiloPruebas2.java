/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_hilopruebas2;

/**
 *
 * @author angel
 */
public class DAM2_PSP_HiloPruebas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int i;

        // Flujo simple que ejecuta el thread
        MiHilo hilo = new MiHilo(); // Creamos el hilo
        //hilo.start();             // Ejecutamos el hilo, start() llama a -> run();

        // Llamamos al otro hilo
        HiloHola hilo2 = new HiloHola();
        //hilo2.start();
        
        // Llamamos al hilo con parametros con 2 instancias distintas
        System.out.println("-------------");
        SiNoThread s = new SiNoThread("SI");
        SiNoThread n = new SiNoThread("NO");
        
        s.start();
        n.start();
        
        System.out.println("-------------");

        // For ejecutado por el main
        /*for (i = 0; i < 200; i++) {
            System.out.println("SI ");

        }*/

    }

}
