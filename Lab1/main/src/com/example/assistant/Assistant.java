package com.example.assistant;

import com.example.displayComparation.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays = new ArrayList<>();

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
    }

    public void assignDisplay(Display display) {
        assignedDisplays.add(display);
    }

    public void assist() {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                assignedDisplays.get(i).compareSize(assignedDisplays.get(j));
                assignedDisplays.get(i).compareSharpness(assignedDisplays.get(j));
            }
        }
    }

    public Display buyDisplay() {
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays are assigned to buy.");
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the display you want to buy: ");
        int choice;

        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt() - 1; 
            if (choice >= 0 && choice < assignedDisplays.size()) {
                break;
            } else {
                System.out.println("Invalid choice. Please select a number from the list.");
            }
        }

        Display selectedDisplay = assignedDisplays.remove(choice);
        System.out.println("Bought display: " + selectedDisplay);
        return selectedDisplay;
    }
}
