/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronbuilder.concrete_builder;

import patronbuilder.abstract_builder.PizzaBuilder;

/**
 *
 * @author A10-PC116
 */
public class PicantePizzaBuilder extends PizzaBuilder{

    @Override
    public void buildMasa() {
        super.pizza.setMasa("doble");
    }

    @Override
    public void buildSalsa() {
        super.pizza.setSalsa("Carbonara|Picanto");
    }

    @Override
    public void buildRelleno() {
        super.pizza.setRelleno("pepperoni+beicon+jalapenyos");
    }
    
}
