
package patronbuilder.abstract_builder;


public abstract class PizzaBuilder {
    protected Pizza pizza;
    
    public Pizza getPizza(){
        return pizza;
    }
    
    public void cearNuevaPizza(){
        this.pizza= new Pizza();
    }
    
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
    
    
    
}
