/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg10_bancoparque;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos el banco
        Banco banco = new Banco(2);

        // Creamos las personas
        Persona p1 = new Persona("Anakin");
        Persona p2 = new Persona("Obi Wan");
        Persona p3 = new Persona("Padme");
        Persona p4 = new Persona("Leia");
        Persona p5 = new Persona("Chewaka");

        // Creamos los hilos
        PersonaEnElParque personaEnElParque1 = new PersonaEnElParque(p1, 5000, banco);
        PersonaEnElParque personaEnElParque2 = new PersonaEnElParque(p2, 15000, banco);
        PersonaEnElParque personaEnElParque3 = new PersonaEnElParque(p3, 4000, banco);
        PersonaEnElParque personaEnElParque4 = new PersonaEnElParque(p4, 2000, banco);
        PersonaEnElParque personaEnElParque5 = new PersonaEnElParque(p5, 8000, banco);

        // Lanzamos los hilos
        personaEnElParque1.start();
        personaEnElParque2.start();
        personaEnElParque3.start();
        personaEnElParque4.start();
        personaEnElParque5.start();

    }

}
