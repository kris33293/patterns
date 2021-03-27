package com.kodilla.patterns2.decorator.pizza;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    public void testPizzaPreparation() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new AddHamDecorator(theOrder);
        theOrder = new AddOnionDecorator(theOrder);
        theOrder = new AddPepperDecorator(theOrder);
        //When
        String description = theOrder.getPizzaDescription();
        //Then
        assertEquals("Ciasto + Sos pomidorowy + Ser + Szynka + Cebula + Papryka", description);
    }
}
