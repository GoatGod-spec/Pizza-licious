package com.pluralsight;

public class Topping extends Product{

    private String type;

    public Topping(String name, double price, String type) {
        super(name, price);
        this.type = type;

    }
    public String getType() {
        return type;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
            return name + " (" + type + ")";
    }
}
