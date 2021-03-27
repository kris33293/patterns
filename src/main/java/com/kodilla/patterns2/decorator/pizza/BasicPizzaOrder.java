package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getPizzaCost() {
        return new BigDecimal(15.00);
    }

    @Override
    public String getPizzaDescription() {
        return "Ciasto + Sos pomidorowy + Ser";
    }
}
