package com.pluralsight;

public abstract class Product {

    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public abstract double calculatePrice();

    @Override
    public String toString(){
        return String.format("%s | $%.2f", name, price);
    }
}
