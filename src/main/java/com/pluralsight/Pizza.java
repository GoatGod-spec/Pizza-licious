package com.pluralsight;

import java.util.ArrayList;

public class Pizza extends Product{

    private String size;
    private String crustType;
    private ArrayList<Topping> toppings;
    private Boolean stuffedCrust;

    public Pizza(String name, double price, String size, String crustType, ArrayList<Topping> toppings, Boolean stuffedCrust) {
        super(name, price);
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
        this.stuffedCrust = stuffedCrust;
    }

    public String getSize() {
        return size;
    }

    public String getCrustType() {
        return crustType;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public Boolean getStuffedCrust() {
        return stuffedCrust;
    }

    private static double getBasePrice(String size) {
        switch (size) {
            case "8":
                return 8.50;
            case "12":
                return 12;
            case "16":
                return 16.50;
            default:
                return 0;
        }
    }

    public void addTopping(Topping topping) {

        toppings.add(topping);
    }



    @Override
    public double calculatePrice(){
        double total = price;
       for (Topping t : toppings){
            total += t.calculatePrice();
        }
        return total;

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crustType='" + crustType + '\'' +
                ", toppings=" + toppings +
                ", stuffedCrust=" + stuffedCrust +
                '}';
    }
    public int getSizeInt() {
        return switch (size.toLowerCase()) {
            case "8" -> 0;
            case "12" -> 1;
            case "16" -> 2;
            default -> throw new IllegalArgumentException("Invalid size: " + size);
        };
    }
}