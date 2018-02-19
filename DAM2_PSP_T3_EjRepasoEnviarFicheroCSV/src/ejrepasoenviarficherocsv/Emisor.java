/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejrepasoenviarficherocsv;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

/**
 *
 * @author Alexis
 */
public class Emisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File fichero = new File("alumnos.csv");
        FileReader fr;
        BufferedReader br;
        String linea;
        ObjectOutputStream objOut = null;

        try {

            // Conseguimos la dirección IP del nombre de host
            InetAddress direccionIP = InetAddress.getByName("localhost");

            // Creamos el socket de conexión
            DatagramSocket socket = new DatagramSocket();

            // Abrimos el fichero y lo leemos linea a linea
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            // Mientras la línea no sea vacía...
            while ((linea = br.readLine()) != null) {

                // Tokenizamos cada línea
                Alumno alumno = null;
                StringTokenizer tokens = new StringTokenizer(linea, ",");

                // Recogemos los tokens de la línea, para cargarlos en un obj. alumno
                // y así poder trabajar con sus datos
                while (tokens.hasMoreTokens()) {
                    String nombre = tokens.nextToken();
                    String apellido = tokens.nextToken();
                    int nota1 = Integer.parseInt(tokens.nextToken());
                    int nota2 = Integer.parseInt(tokens.nextToken());
                    int nota3 = Integer.parseInt(tokens.nextToken());

                    alumno = new Alumno(nombre, apellido, nota1, nota2, nota3);
                }

                // Calculamos la nota media del alumno
                int notaMedia = alumno.getNota1() + alumno.getNota2() + alumno.getNota3() / 3;

                // Mostramos el resultado
                if (notaMedia >= 5) {
                    System.out.println("Enviando alumno " + alumno.getNombre());

                    // Convertimos el obj. Alumno a bytes
                    ByteArrayOutputStream objetoByte = new ByteArrayOutputStream(4096);
                    objOut = new ObjectOutputStream(objetoByte);
                    objOut.writeObject(alumno);

                    // Creamos el paquete donde almacenar la información
                    DatagramPacket paquete = new DatagramPacket(objetoByte.toByteArray(), objetoByte.size(), direccionIP, 2000);

                    // Envío la información al servidor
                    socket.send(paquete);
                    System.out.println("Enviado -> " + alumno.toString());
                    
                    sleep(2000);

                } else {
                    System.out.println("El alumno no ha aprobado. " + alumno.toString());

                }

            }
            
            // Enviamos un null para que el servidor se cierre
            Alumno alumno = null;
            ByteArrayOutputStream objetoByte = new ByteArrayOutputStream(4096);
            objOut = new ObjectOutputStream(objetoByte);
            objOut.writeObject(alumno);
            DatagramPacket paquete = new DatagramPacket(objetoByte.toByteArray(), objetoByte.size(), direccionIP, 2000);
            socket.send(paquete);

            // Cerramos el socket
            socket.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
