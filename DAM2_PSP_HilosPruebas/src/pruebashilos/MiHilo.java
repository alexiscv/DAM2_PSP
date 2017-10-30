/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebashilos;

/**
 *
 * @author Alexis
 */
public class MiHilo extends Thread {

    // CREAR HILO
    // Para crear un hilo extendemos de Thread
    // Y tenemos que definir el método run()
    @Override
    public void run() {
        // Aquí definimos nuestro código
        //
        // INFO GENERAL
        //
        // Suele ser una costumbre bastante habitual que dentro del método run() 
        // haya un bucle infinito, de forma que el método run() no termina nunca. 
        //
        // DENETAR UN HILO
        //
        // Para detener un hilo, implementamos un método que detenga ese bucle infinito.
        // 
        // SINCRONIZAR HILOS
        //
        // Para evitar que dos hilos trabajen con un mismo recurso usamos synchronized
        // synchronized (fichero){ fichero.println("En un lugar de la Mancha..."); }
        // De esta manera, el fichero queda protegido, hasta que termina de ejecutarse el código entre llaves.
        // También se pueden sincronizar métodos
        // public synchronized void println(String cadena) { fichero.println(cadena);  }
        // Obviamente también se pueden sincronizar listas para no borrar o añadir info con un hilo mientras la recorremos con otro hilo
        /* 
            LinkedList lista = new LinkedList();
            ...
            synchronized (lista)
            {
               for (int i=0;i<lista.size(); i++)
                  System.out.println(lista.get(i));
            } 
        */
        //
        // BLOQUEAR HILOS
        //
        // Todos los objetos java tienen el método wait() que deja bloqueado al hilo que lo llama y el método notify(), que desbloquea a los hilos bloqueados por wait()
        /*
        Imaginemos que nuestro hilo quiere retirar datos de una lista y si no hay datos, quiere esperar a que los haya. El hilo puede hacer algo como esto
        
        synchronized(lista);
        {
           if (lista.size()==0)
              lista.wait();

           dato = lista.get(0);
           lista.remove(0);
        }
        
        En primer lugar hemos hecho el synchronized(lista) para "apropiarnos" del objeto lista. Luego, si no hay datos, hacemos el lista.wait(). 
        Una vez que nos metemos en el wait(), el objeto lista queda marcado como "desocupado", de forma que otros hilos pueden usarlo. Cuando despertemos y salgamos del wait(), 
        volverá a marcarse como "ocupado."
        
        Nuestro hilo se desbloquerá y saldrá del wait() cuando alguien llame a lista.notify().
        
        */
        
        // ENCAPSULAMIENTO
        // Para no tener que indicar todo esto en cada hilo y para seguir el principio de encapsulación, deberiamos crear clases que manejasen todos estos métodos, por ejemplo
        /*
        public class MiListaSincronizada
        {
           private LinkedList lista = new LinkedList();

           public synchronized void addDato(Object dato)
           {
              lista.add(dato);
              lista.notify();
           }

           public synchronized Object getDato()
           {
              if (lista.size()==0)
                 wait();
              Object dato = lista.get(0);
              lista.remove(0);
              return dato;
           }
        } 
        */
        
        // Listo, nuestros hilos ya no deben preocuparse de nada. El hilo que espera por los datos hace esto
        // Object dato = listaSincronizada.getDato();
        //
        // y eso se quedará bloqueado hasta que haya algún dato disponible. Mientras, el hilo que guarda datos sólo tiene que hacer esto otro
        // listaSincronizada.addDato(dato);
        // 
        // INTERRUMPIR
        // Puede darse el caso de que un hilo se quede en espera wait() de otro proceso y ese proceso cierre la conexión y ese hilo no pueda salir del wait
        // si interrumpimos un hilo que espraba un dato, intentará recoger ese dato y verá que no existe, entonces debemos estar preparados para mostrar un error o actuar
        // en consecuencia. Por ejemplo
        /*
        while (true)
        {
           if (listaSincronizada.size() == 0)
              wait();

           // Debemos comprobar que efectivamente hay datos.
           if (listaSincronizada.size() > 0)
           {
              // Hay datos, los tratamos
              Object dato=listaSincronizada.get(0);
              listaSincronizada.remove(0);
              // tratar el dato.
           }
           else
           {
              // No hay, datos se debe haber cerrado la conexion
              // así que nos salimos.
              return;
           }
        } 
        */
        
        // Como vemos arriba, la aplicación entra a wait() si no hay datos, pero si por alguna razón saliese del wait antes de tener datos, debemos interrumpir el hilo
        // lectorDatos.interrupt();

    }

}
