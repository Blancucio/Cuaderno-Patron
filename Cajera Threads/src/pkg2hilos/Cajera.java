package pkg2hilos;

/**
 *
 * @author Cristian Blancas
 */
public class Cajera extends Thread {

    //Creamos los atributos que tendra el cliente
    private String nombre;
    private long tiempo;
    private Cliente cliente;
    
    //CONSTRUCTOR

    public Cajera() {
    }
    
    //CONSTRUCFTOR CON PARAMETROS
    public Cajera(String nombre, long timeStamp, Cliente cliente) {
        this.nombre = nombre;
        this.tiempo = timeStamp;
        this.cliente = cliente;
    }

    //FUNCION PARA GENERAR EL TIEMPO DE ESPERA QUE CUESTA ESCANEAR CADA PRODUCTO
    private void escanearProducto(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //Funcion run que ejecuta el proceso de la cajera
    //Con esata funcion conseguiremos generar que los hilos se ejecuten a la vez
    @Override
    public void run() {
        //Imprimiremos por pantalla en tiempo inicial en el que la cajera atiende al cliente
        System.out.println(this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: " 
                + ((System.currentTimeMillis()-tiempo)/1000) + " segundos");
        
        //Recorremos el array de Compra(los productos de cada cliente) y lo que le cuesta a cada cajera escanearlos
        //Se ejecutara hasta que se hayan escaneado todos los productos
        for (int i = 0; i < cliente.getCompra().length; i++) {
            this.escanearProducto(cliente.getCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + " ->Tiempo: " + ((System.currentTimeMillis()-tiempo)/1000) + " segundos");
        }

        //Imprimieremos por pantalla el tiempo que le ha costado a la cajera procesar todos los prodcutos del cliente
        System.out.println(this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: "
                + ((System.currentTimeMillis()-tiempo)/1000) + " segundos");
    }

    //GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
