package com.swiggy;

import java.util.Scanner;

public class InputTaking {

    private final Scanner scanner;

    public InputTaking() {
        this.scanner = new Scanner(System.in);
    }

    public int getRowsInput() {
        System.out.println("Enter the number of rows (or type 'stop' to exit)");
        return getPositiveIntegerInput();
    }

    public int getColumnsInput() {
        System.out.println("Enter the number of columns (or type 'stop' to exit)");
        return getPositiveIntegerInput();
    }

    public double getPercentageInput() {
        System.out.println("Enter the percentage of alive cells (0-100, or type 'stop' to exit)");
        return getPercentage();
    }

    private double getPercentage() {
        while (true) {
            String input = scanner.next();
            if(input.equalsIgnoreCase("stop")) {
                System.exit(0);
            }
            try {
                double value = Double.parseDouble(input);
                if (value >= 0 && value <= 100) return value / 100.0;
                else System.out.println("Please enter a percentage between 0 and 100");
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid percentage or 'stop' to exit");
            }
        }
    }

    private int getPositiveIntegerInput() {
        while (true) {
            String input = scanner.next();
            if(input.equalsIgnoreCase("stop")) {
                System.exit(0);
            }
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
                else System.out.println("Please enter positive integer.");
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer or 'stop' to exit");
            }
        }
    }
}
