package com.example.main;

import com.example.assistant.Assistant;
import com.example.displayComparation.Display;
import com.example.textParser.FileReader;
import com.example.textParser.TextData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nChoose a task:");
            System.out.println("1. Add Displays and Use Assistant");
            System.out.println("2. Perform Text Analysis on a .txt file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scan.nextInt();
            scan.nextLine(); // Clear the buffer
            
            switch (choice) {
                case 1:
                    handleDisplaysAndAssistant(scan);
                    break;
                case 2:
                    if (args.length < 1) {
                        System.out.println("Error: Please provide the path to the .txt file as a command-line argument.");
                    } else {
                        performTextAnalysis(args[0]);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Task 1: Add Displays and Use Assistant
    private static void handleDisplaysAndAssistant(Scanner scan) {
        int numberOfDisplays = 3;
        List<Display> displays = new ArrayList<>();

        for (int i = 0; i < numberOfDisplays; i++) {
            System.out.println("Entering details for Display " + (i + 1) + ":");
            Display display = new Display();
            displayDescription(display, scan);
            displays.add(display);
        }

        System.out.println("Do you want to use the assistant? Answer options: yes/no");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter Assistant's name:");
            String assistantName = scan.nextLine();
            Assistant assistant = new Assistant(assistantName);
            for (Display display : displays) {
                assistant.assignDisplay(display);
            }
            assistant.assist();
            assistant.buyDisplay();
        } else {
            System.out.println("Okay, proceeding without an assistant.");
        }
    }

    // Task 2: Perform Text Analysis on a .txt file
    private static void performTextAnalysis(String filePath) {
        try {
            FileReader fileReader = new FileReader();
            String data = fileReader.readFileIntoString(filePath);
            TextData textData = new TextData(data);

            System.out.println("Text Analysis:");
            System.out.println("Text: " + textData.getText());
            System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of Letters: " + textData.getNumberOfLetters());
            System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method for entering display details
    static void displayDescription(Display display, Scanner scan) {
        System.out.println("Enter the width of your Display:");
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer for width:");
            scan.next();
        }
        int width = scan.nextInt();

        System.out.println("Enter the height of your Display:");
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer for height:");
            scan.next();
        }
        int height = scan.nextInt();

        System.out.println("Enter the ppi of your Display:");
        while (!scan.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a float for PPI:");
            scan.next();
        }
        float ppi = scan.nextFloat();
        scan.nextLine();

        System.out.println("Enter the model of your Display:");
        String model = scan.nextLine();

        display.setDisplayDetails(width, height, ppi, model);
    }
}
