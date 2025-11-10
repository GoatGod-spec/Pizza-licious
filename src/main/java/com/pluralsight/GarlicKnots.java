package com.pluralsight;

public class GarlicKnots extends Product{

    public GarlicKnots(String name, double price){
        super(name, price);
    }
    @Override
    public double calculatePrice() {
        return price;
    }
}
