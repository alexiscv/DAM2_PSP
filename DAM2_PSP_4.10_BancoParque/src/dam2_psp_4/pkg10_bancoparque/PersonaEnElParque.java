/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_psp_4.pkg10_bancoparque;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class PersonaEnElParque extends Thread {

    private Persona persona;
    private int tiempoSentada;
    private Banco banco;

    /**
     * Constructor
     *
     * @param persona
     * @param tiempoSentada
     */
    public PersonaEnElParque(Persona persona, int tiempoSentada, Banco banco) {
        this.persona = persona;
        this.tiempoSentada = tiempoSentada;
        this.banco = banco;

    }

    @Override
    public void run() {

        // Mientras no nos podamos sentar, intentaremos hacerlo.
        while (!banco.sentarse(persona.getNombre())) {
            
            // Intentaremos sentarnos hasta conseguirlo

        }

        // Cuando estemos sentados, esperamos el tiempo necesario
        try {
            sleep(tiempoSentada);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonaEnElParque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Y despues nos levantamos.
        banco.levantarse(persona.getNombre());

    }

}
