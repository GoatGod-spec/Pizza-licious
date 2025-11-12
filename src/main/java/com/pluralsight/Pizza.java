package com.pluralsight;

import java.util.ArrayList;

public class Pizza {

    private String size;
    private String crustType;
    private ArrayList<Topping> toppings;
    private Boolean stuffedCrust;

    public Pizza(String size, String crustType, ArrayList<Topping> toppings, Boolean stuffedCrust) {
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

    private double getMeatPrice(String size, int extraMeat) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case "8":
                basePrice = 1.00;
                extraPrice = .50;
                break;
            case "12":
                basePrice = 2.00;
                extraPrice = 1.00;
                break;
            case "16":
                basePrice = 3.00;
                extraPrice = 1.50;
                break;
        }
        return basePrice + (extraPrice * extraMeat);
    }

    private double getCheesePrice(String size, int extraCheese) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case "8":
                basePrice = .75;
                extraPrice = .30;
                break;
            case "12":
                basePrice = 1.50;
                extraPrice = .60;
                break;
            case "16":
                basePrice = 2.25;
                extraPrice = .90;
                break;
        }
        return basePrice + (extraPrice * extraCheese);
    }
    @Override
    public double calculatePrice(){
        double total = price;
        for (Topping t = toppings){
            String category = t.getCategory();

            switch (category.toLowerCase()){
                case "meat":
                    total += getMeatPrice(size, t.getExtra());
                    break;
                case "cheese":
                    total += getCheesePrice(size, t.getExtra());
                    break;
            }
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
}