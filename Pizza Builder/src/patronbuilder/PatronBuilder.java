
package patronbuilder;

import patronbuilder.abstract_builder.PizzaBuilder;
import patronbuilder.concrete_builder.HawaiiPizzaBuilder;
import patronbuilder.concrete_builder.PicantePizzaBuilder;
import patronbuilder.director.Cocina;
import patronbuilder.PIZZA_FACTORY;

public class PatronBuilder {

    public static void main(String[] args) {
        Cocina cocina = Cocina.getInstance();
        
        //PATRÓN FACTORÍA
        /*
        PizzaBuilder hawaianPizza = new HawaiiPizzaBuilder();
        PizzaBuilder picantePizza = new PicantePizzaBuilder();
        */
        
        PizzaBuilder hawaianPizza = PIZZA_FACTORY.getInstance(PIZZA_FACTORY.HAWAII_PIZZA);
        PizzaBuilder picantePizza = PIZZA_FACTORY.getInstance(PIZZA_FACTORY.PICANTE_PIZZA);
        
        
        picantePizza.buildRelleno();
        //VINCULACIÓN DINAMICA
        
        
                
        cocina.setPizza(hawaianPizza);
        cocina.contruirPizza();
        
        cocina.setPizza(picantePizza);
        
    
    
    
    }
    
}
