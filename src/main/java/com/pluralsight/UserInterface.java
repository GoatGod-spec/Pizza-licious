package com.pluralsight;

import java.util.List;
import java.util.ArrayList;

public class UserInterface {

    private Order currentOrder;

    public void display() {
        System.out.println("\n--- Welcome to Goated Pizza ----");

        String mainMenu = """                
                Hello there, What would you like to do?
                1) Start a New Order
                0) Exit
                """;

        boolean ordering = true;

        while (ordering) {
            System.out.println(mainMenu);

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

                Pizza pizza = new Pizza("Custom Pizza",0, size, crust, new ArrayList<>(), stuffedCrust);

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
                System.out.println("\n--- Pizza was added to your order! \nPrice: $%.2\n", pizza.calculatePrice());
            }
        }
    }
}
