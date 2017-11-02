/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.jardines;

/**
 *
 * @author angel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos los hilos que cuentan y restan
        Jardin jardin = new Jardin(100);

        // Entran 10 personas
        for (int i = 0; i < 10; i++) {
            new HiloEntra(jardin,"Entra"+i).start();

        }

        // Salen 15
        for (int j = 0; j < 15; j++) {
            new HiloSale(jardin,"Entra"+j).start();

        }

    }

}
