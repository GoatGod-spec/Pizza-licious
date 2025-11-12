package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class ToppingsHelper {

    public static void displayOptions(String[] options, String title) {
        System.out.println(title);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println("0) Skip");
    }

    public static List<String> selectMultiple(String[] options, String title) {
        List<String> selected = new ArrayList<>();

        displayOptions(options, title);

        String input = ConsoleHelper.promptForString("Enter numbers separated by a comma (0 to skip)");

        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int index = Integer.parseInt(part) - 1;

                if (index >= 0 && index < options.length) {
                    selected.add(options[index]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again");
            }
        }
        return selected;
    }

    public static String selectSingle(String[] options, String title) {
        displayOptions(options, title);

        String input = ConsoleHelper.promptForString("Enter your choice");

        try {
            int index = Integer.parseInt(input) - 1;

            if (index >= 0 && index < options.length) {
                return options[index];
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try again");
        }
        System.out.println("No selection made.");
        return null;
    }

    public static boolean chooseYesNo(String question) {
        System.out.println("/n" + question);
        System.out.println("1) Yes");
        System.out.println("2) No");

        while (true) {
            int choice = ConsoleHelper.promptForInt("Enter your choice (1 or 2");
            if (choice == 1) return true;
            if (choice == 2) return false;
            System.out.println("INVALID CHOICE. Please enter 1 for Yes or 2 for No.");
        }
    }
}