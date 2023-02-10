
package pkg2hilos;

/**
 *
 * @author Cristian Blancas
 */
public class Cliente {
    
    //Creamos los atributos que tendra el cliente
    private String nombre;
    private int compra [];

    //CONSTRUCTOR
    public Cliente() {
    }
    
    //CONSTRUCFTOR CON PARAMETROS
    public Cliente(String nombre, int[] compra) {
        this.nombre = nombre;
        this.compra = compra;
    }

    //GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCompra() {
        return compra;
    }

    public void setCompra(int[] compra) {
        this.compra = compra;
    }
    
    
    
}
