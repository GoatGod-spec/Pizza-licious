package com.pluralsight;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Contains Product items such as (Pizza, Drink, and Garlic Knots) also calculates total.
public class Order {

    private String orderId;
    private LocalDateTime dateTime;
    private ArrayList<Product> items;

    public Order(String orderId) {
        this.orderId = orderId;
        this.dateTime = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ArrayList<Product> getItems() {
        return items;
    }
    public void addItem(Product item) {
        items.add(item);
    }
    // Calculates the price of the complete order.
    public double calculateTotal(){
        double total = 0;
        for (Product p : items) {
            total += p.calculatePrice();
        }
        return total;
    }
    public void display() {
        System.out.println("Order: " + orderId);
            System.out.println("Date/Time: " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss")));
        System.out.println("Items in order: ");
        for (Product p : items) {
            System.out.println(" - " + p.toString());
        }
        System.out.printf("Total Price: $%.2f/n", calculateTotal());
    }
    public boolean isValid(){
        boolean hasPizza = items.stream().anyMatch( p -> p instanceof Pizza);
        boolean hasDrinkOrGarlicKnots = items.stream().anyMatch( p -> p instanceof Drink || p instanceof GarlicKnots);
        return hasPizza || hasDrinkOrGarlicKnots;
    }
}
