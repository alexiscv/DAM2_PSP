/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author Alexis
 */
public class HTTPClient1 {

    public static void main(String[] args) {

        try {

            // InetSocketAddress para especificar un timeout para el socket del cliente
            SocketAddress sockaddr = new InetSocketAddress("www.yahoo.com", 80);

            // Creamos el nuevo Socket
            Socket s = new Socket();

            // Conectamos
            s.connect(sockaddr, 10000);

            // 
            BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream());
            StringBuffer req = new StringBuffer();
            req.append("GET / HTTP/1.1\n");
            req.append("Host: www.yahoo.com\n");
            req.append("Accept-Language: en-US,en;q=0.5\n");
            req.append("\n\n");

            socketOut.print(req);
            socketOut.flush();
            String line;

            while ((line = bufferLectura.readLine()) != null) {

                System.out.println(line);

            }

            bufferLectura.close();
            socketOut.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);

        }

    }

}
