/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcpcliente;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Alexis
 */
public class Cliente {
    
    private String host = "localhost";
    private int puerto = 2000;
    
    public Cliente() {
        
        try {
            // Conexión con el servidor
            Socket sCliente = new Socket(host, puerto);

            // Preparar emboltorio para los datos
            OutputStream flujoSalida = sCliente.getOutputStream();
            DataOutputStream datosFlujoSalida = new DataOutputStream(flujoSalida);
            
            // Generamos el contenido y mostramos un mensaje por pantalla
            int n = (int)(Math.random()*10)+1;
            System.out.println("Mensaje a enviar al servidor. Salio un "+n);
            
            // Cargamos los datos
            datosFlujoSalida.writeUTF("Mensaje de salida que el cliente envia al servidor, He pensado en el número  " + n);
            
            // Cerrar conexión
            sCliente.close();
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
    }
    
}
