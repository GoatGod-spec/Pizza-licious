package com.pluralsight;

public class Drink extends Product{

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super(flavor + size, getPriceBySize(size));
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }
    private static double getPriceBySize(String size) {
        switch (size.toLowerCase()){
            case "small":
                return 1.50;
            case "medium":
                return 2.00;
            case "large":
                return 2.50;
            default:
                return 0.0;
        }
    }
    @Override
    public double calculatePrice(){
        return price;
    }
}
