
package pkg2hilos;

/**
 *
 * @author Cristian Blancas
 */
public class Main {

    public static void main(String[] args) {
        
        //VERSION 1
        /*
        //Creamos 1 cliente
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{1, 3, 5});
        
        //Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
        //Creamos la cajera
        Cajera cajera1 = new Cajera("Cajera 1", initialTime, cliente1);
        
        //Lanzamos el programa
        cajera1.start();
        */
        
        // VERSION 2
        
        //Creamos 2 clientes
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{1, 3, 5});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{8 , 3 , 1});

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        //Creamos 2 cajeras para que atiendan a los clientes
        Cajera cajera1 = new Cajera("Cajera 1", initialTime, cliente1);
        Cajera cajera2 = new Cajera("Cajera 2", initialTime, cliente2);

        //Lanzamos el programa
        cajera1.start();
        cajera2.start();
        
        System.out.println("Programa iniciado");

    }

}
