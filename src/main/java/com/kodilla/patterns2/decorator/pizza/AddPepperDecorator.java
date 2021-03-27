package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddPepperDecorator extends  AbstractPizzaOrderDecorator{

    public AddPepperDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPizzaCost(){
        return super.getPizzaCost().add(new BigDecimal(5));
    }

    @Override
    public String getPizzaDescription(){
        return super.getPizzaDescription().concat(" + Papryka");
    }
}
