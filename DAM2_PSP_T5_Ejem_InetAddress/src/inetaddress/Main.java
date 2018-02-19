/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Main {

    public static void main(String[] args) {

        try {
            InetAddress Address = InetAddress.getLocalHost();
            System.out.println(Address); // Nombre del equipo local

            Address = InetAddress.getByName("www.educastur.es");
            System.out.println(Address); // Devuelve la ip del dominio

            // Para ver todas las ips de dicho dominio
            InetAddress sW[] = InetAddress.getAllByName("www.google.es");

            for (int i = 0; i < sW.length; i++) {

                System.out.println(sW[i]);

            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
