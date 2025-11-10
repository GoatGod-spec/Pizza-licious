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
    private static double getBasePrice(String size){
        switch (size) {
            case "8":
                return 8.50;
            case "12":
                return 12;
            case "16":
                return 16.50;
            default: return 0;
        }
    }
}
