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
public class MainEjemplo2 {

    public static void main(String[] args) {

        try {

            InetAddress host = InetAddress.getByName("www.google.com");
            
            // Da la IP
            System.out.println("HOST: " + host);

            // Da el nombre
            System.out.println("IP: " + host.getHostAddress());

        } catch (UnknownHostException ex) {
            Logger.getLogger(MainEjemplo2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
