
package patronbuilder.director;

import patronbuilder.abstract_builder.Pizza;
import patronbuilder.abstract_builder.PizzaBuilder;


public class Cocina {
    private static Cocina cocina;
    private PizzaBuilder pizzaBuilder;
    
    private Cocina(){
        
    }
     //SINGLETON
    public static Cocina getInstance(){
        if(cocina==null){
            cocina = new Cocina();
        }
        return cocina;
    }
    
    
   
    
    
    public void setPizza(PizzaBuilder pizzaBuilder){
        this.pizzaBuilder =pizzaBuilder;
    }
    
    public void contruirPizza(){
        this.pizzaBuilder.cearNuevaPizza();
        this.pizzaBuilder.buildMasa();
        this.pizzaBuilder.buildSalsa();
        this.pizzaBuilder.buildRelleno();
    }
    
    public Pizza getPizza(){
        return this.pizzaBuilder.getPizza();
    }
}
