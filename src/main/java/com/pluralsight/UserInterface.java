package com.pluralsight;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class UserInterface {

    private Order currentOrder;

    public void display() {
        System.out.println("\n--- Welcome to Goated Pizza ----");

        boolean ordering = true;

        while (ordering) {
            showMainMenu();

            int choice = ConsoleHelper.promptForInt("Select from one of the options");
            switch (choice) {
                case 1 -> addPizza();
                case 2 -> addDrink();
                case 3 -> addGarlicKnots();
                case 4 -> {
                    checkout();
                    ordering = false;
                }
                case 0 -> {
                    System.out.println("\n--- Thank you for being the Goat and visiting Goated Pizza. Have a nice day! ---");
                    ordering = false;
                }
                default -> System.out.println("INVALID COMMAND! Please select one of the follow options.");
            }
        }
    }
    private void showMainMenu(){
        System.out.println("""                
                Hello there, What would you like to do?
                1) Start a New Order
                0) Exit
                """);
    }
    private void startNewOrder(){
        currentOrder = new Order();

        boolean ordering = true;

        while (ordering) {
            showOrderMenu();

            int command = ConsoleHelper.promptForInt("Enter your command here: ");

            switch (command) {
                case 1 -> addPizza();
                case 2 -> addDrink();
                case 3 -> addGarlicKnots();
                case 4 -> {
                    checkout();
                    ordering = false;
                }
                case 0 -> {
                    System.out.println("\n--- Thank you for being the Goat and visiting Goated Pizza. Have a nice day! ---");
                    ordering = false;
                }
                default -> System.out.println("INVALID COMMAND! Please select one of the follow options.");
            }
        }
    }
    private void showOrderMenu() {
        System.out.println("""
            (Order Menu)
            1) Add Sandwich
            2) Add Drink
            3) Add Chips
            4) Checkout
            0) Cancel Order
            """);
    }
    private void addPizza(){
        System.out.println("\n--- Add Pizza ---");

        String size = ToppingsHelper.selectSingle(MenuSelection.Pizza.sizes, "Choose Pizza Size (inches)");

        if (size == null) {
            System.out.println("Pizza cancelled");
            return;
        }
        String crust = ToppingsHelper.selectSingle(MenuSelection.Pizza.crustType, "Choose Crust Type");

        if(crust == null) {
            System.out.println("Pizza cancelled");
            return;
        }
        boolean stuffedCrust = ToppingsHelper.chooseYesNo("Would you like Stuffed Crust in your Pizza?");

        Pizza pizza = new Pizza("Custom Pizza", size, crust, new ArrayList<>(), stuffedCrust);

        boolean orderToppings = true;

        while (orderToppings) {
            System.out.println("""                
                Hello, What toppings would you like to add?
                1) Meats
                2) Cheeses
                3) Regular Toppings
                4) Sauces
                5) Sides
                0) Finish
                """);
            int toppingCommand = ConsoleHelper.promptForInt("Enter an option");

            switch (toppingCommand){
                case 1 -> addMeats(pizza);
                case 2 -> addCheeses(pizza);
                case 3 -> addRegToppings(pizza);
                case 4 -> addSauces(pizza);
                case 5 -> addSides(pizza);
                case 0 -> orderToppings = false;
                default -> System.out.println("INVALID, Choose from one of the options");
            }
        }
        currentOrder.addItem(pizza);
        //todo was looking for an Item (product?) but giving it a pizza...

        System.out.printf("\n--- Pizza was added to your order! \nPrice: $%.2\n", pizza.calculatePrice());
        //todo this was not building
    }

    private void addRegToppings(Pizza pizza){
        List<String> regTopping = ToppingsHelper.selectMultiple(MenuSelection.Toppings.regToppings, "What kind of regular toppings would you like?");
        System.out.println(regTopping);
        for (String rt : regTopping){ // : = in
            Topping regT = new Topping(rt,0,"Regular Topping");
            pizza.addTopping(regT);
        }
    }


    private void addMeats(Pizza pizza){
        List<String> toppings = ToppingsHelper.selectMultiple(MenuSelection.Toppings.meats, "What kind of meat toppings would you like?");
        System.out.println(toppings);
        double price = 0;
        switch(pizza.getSize().toLowerCase()) {
            case "small" -> price = 1.00;
            case "medium" -> price = 2.00;
            case "large" -> price = 3.00;
        }
        for (String rt : toppings){ // : = in
            Topping regT = new Topping(rt, price,"meat");
            pizza.addTopping(regT);
        }
    }
    private void addCheeses (Pizza pizza){
        List<String> toppings = ToppingsHelper.selectMultiple(MenuSelection.Toppings.cheeses, "What kind of cheese would you like?");
        System.out.println(toppings);
        double price = 0;
        switch(pizza.getSize().toLowerCase()) {
            case "small" -> price = .75;
            case "medium" -> price = 1.50;
            case "large" -> price = 2.25;
        }
        for (String rt : toppings){ // : = in
            Topping regT = new Topping(rt, price,"cheese");
            pizza.addTopping(regT);
        }
    }
    private void addSauces(Pizza pizza){
        List<String> toppings = ToppingsHelper.selectMultiple(MenuSelection.Toppings.sauces, "What kind of sauce would you like?");
        System.out.println(toppings);
        for (String rt : toppings){ // : = in
            Topping regT = new Topping(rt, 0,"sauce");
            pizza.addTopping(regT);
        }
    }
    private void addSides(Pizza pizza){
        List<String> toppings = ToppingsHelper.selectMultiple(MenuSelection.Toppings.sauces, "What sides would you like?");
        System.out.println(toppings);
        for (String rt : toppings) { // : = in
            Topping regT = new Topping(rt, 0, "side");
            pizza.addTopping(regT);
        }
    }
    private String getSelectionOrCancel(String[] options, String title){
        String selection = ToppingsHelper.selectSingle(options, title);

        if (selection == null){
            System.out.println(" Selection cancelled.");
        }
        return selection;
    }
    private void addDrink() {
        System.out.println("\n--- Add Drink ---");
        String size = getSelectionOrCancel(MenuSelection.Drink.sizes, "Choose Drink Size");
        if (size == null) return;

        String flavor = getSelectionOrCancel(MenuSelection.Drink.flavors, "Choose Drink flavor");
        if (flavor == null) return;

        Drink drink = new Drink(flavor, size);
        currentOrder.addItem(drink);

        System.out.printf("Drink added! Price: $%.2f\n", drink.calculatePrice());
    }
    private void addGarlicKnots() {
    }
    private void checkout(){
        System.out.println("""
                (Order Summary)
                """);
        if (currentOrder.getItems().isEmpty()){
            System.out.println("Order isn't existing, Please add items");
            return;
        }

        //currentOrder.displayOrder();
        ////todo no display order
        System.out.printf("Total is: $%.2f\n", currentOrder.calculateTotal());

        boolean saveReceipt = ToppingsHelper.chooseYesNo("Would you like me to upload your receipt?");

        if (saveReceipt) {
            //ReceiptManager.saveReceipt(currentOrder);
        }
        System.out.println("Order Complete, Thank you for dining with us.");
    }
}