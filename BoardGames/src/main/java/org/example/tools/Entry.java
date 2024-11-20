package org.example.tools;

import org.example.categories.Category;
import org.example.categories.ChanceCategory;
import org.example.categories.RolCategory;
import org.example.categories.StrategyCategory;
import org.example.exceptions.IncorrectCategoryException;
import org.example.exceptions.IncorrectDifficultyException;
import org.example.exceptions.StringException;
import org.example.models.DifficultyLevel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

    public static int readInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        int validInput = 0;
        while (!isValidInput) {
            try {
                validInput = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error. " + message);
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return validInput;
    }

    public static String readString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        String validInput = null;
        while (!isValidInput) {
            try {
                validInput = stringReadLineAndCheck(scanner);
                isValidInput = true;
            } catch (StringException e) {
                System.out.println("Format error. " + e.getMessage());
            }
        }
        scanner.reset();
        return validInput;
    }

    public static double readDouble(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        double validInput = 0;
        while(!isValidInput) {
            try {
                validInput = scanner.nextDouble();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error. " + message);
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return validInput;
    }

    public static Category readCategory(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        Category validInput = null;
        while (!isValidInput) {
            try {
                validInput = checkValidCategory(stringReadLineAndCheck(scanner));
                isValidInput = true;
            } catch (StringException | IncorrectCategoryException e) {
                System.out.println("Format error. " + e.getMessage());
            }
        }
        scanner.reset();
        return validInput;
    }

    public static DifficultyLevel readDifficulty(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        DifficultyLevel validInput = null;
        while (!isValidInput) {
            try {
                validInput = checkValidDifficulty(stringReadLineAndCheck(scanner));
                isValidInput = true;
            } catch (StringException | IncorrectDifficultyException e) {
                System.out.println("Format error. " + e.getMessage());
            }
        }
        scanner.reset();
        return validInput;
    }

    private static String stringReadLineAndCheck(Scanner scanner) throws StringException {
        String line = scanner.nextLine();
        if (line.isEmpty()) throw new StringException("Input string is empty.");
        else return line;
    }

    private static Category checkValidCategory(String input) throws IncorrectCategoryException {
        if (input.equalsIgnoreCase("rol")) {
            return new RolCategory();
        } else if (input.equalsIgnoreCase("strategy")) {
            return new StrategyCategory();
        } else if (input.equalsIgnoreCase("chance")) {
            return new ChanceCategory();
        } else {
            throw new IncorrectCategoryException("Category doesn't match with the options.");
        }
    }

    private static DifficultyLevel checkValidDifficulty(String input) throws IncorrectDifficultyException {
        try {
            return DifficultyLevel.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IncorrectDifficultyException("Difficulty level doesn't match with the options. ");
        }
    }
}