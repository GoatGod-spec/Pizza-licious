package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleHelper {

    private static Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input Empty. Please try again.");
            }
        }
        return input;
    }
    public static int promptForInt(String prompt){
        int result = 0;
        boolean valid = false;

        // keep asking until get a valid integer
        while (!valid) {
            System.out.print(prompt + ": ");

            // checks if input has an integer
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            }
            else {
                System.out.println("Invalid input. Please enter a integer.");
                scanner.nextLine();
            }
        }
        return result;
    }
    public static float promptForFloat(String prompt){
        System.out.print(prompt);
        float result = scanner.nextFloat();
        scanner.nextLine();
        return result;
    }
    public static long promptForLong(String prompt){
        System.out.print(prompt);
        long result = scanner.nextLong();
        scanner.nextLine();
        return result;
    }
    public static LocalDate promptForDate(String prompt){
        while(true){
            try{
                System.out.print(prompt + ":");
                String dateAsString = scanner.nextLine();
                return LocalDate.parse(dateAsString);
            }
            catch(Exception ex){
                System.out.println("INVALID ENTRY! Please enter a valid date (YYYY-MM-DD");
            }
        }
    }
    public static double promptForDouble(String prompt){
        double result = 0;
        boolean valid = false;

        while (!valid){
            System.out.print(prompt + "+ ");
            String input = scanner.nextLine().trim();

            try {
                result = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e){
                System.out.println("Invalid input, Please enter a valid number.");
            }
        }
        return result;
    }
}
