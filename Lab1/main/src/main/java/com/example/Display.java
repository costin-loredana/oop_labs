package com.example;
import java.util.Scanner;
public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;
    private int area() {
        return this.width * this.height;
    }  // we need this method in order to compare the size of the screens

    private boolean isLargerThan(Display m) {
        return this.area() > m.area();
    }

    private boolean isSharperThan(Display m) {
        return this.ppi > m.ppi;
    }

    public void compareSize(Display m) {
        
        if (isLargerThan(m)) {
            System.out.println(this.model + " is larger than " + m.model + " (Area: " + this.area() + " vs " + m.area() + ")");
        } else if (!isLargerThan(m)) {
            System.out.println(m.model + " is larger than " + this.model + " (Area: " + m.area() + " vs " + this.area() + ")");
        } else {
            System.out.println(this.model + " and " + m.model + " are the same size (Area: " + this.area() + ")");
        }
    }
    

    public void  compareSharpness(Display m){
        if (isSharperThan(m)) {
            System.out.println(this.model + " is sharper than " + m.model + " (PPI: " + this.ppi + " vs " + m.ppi + ")");
        } else if (!isSharperThan(m)) {
            System.out.println(m.model + " is sharper than " + this.model + " (PPI: " + m.ppi + " vs " + this.ppi + ")");
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness (PPI: " + this.ppi + ")");
        }
    }

    public void   compareWithMonitor(Display m){
        if (isLargerThan(m) && isSharperThan(m)) {
            System.out.println(this.model + " is both larger and sharper than " + m.model);
        } else if (!isLargerThan(m) && !isSharperThan(m)) {
            System.out.println(m.model + " is both larger and sharper than " + this.model);
        }
    }

    public static void main(String[] args){
        //let's create an array which holds 3 instances o objects:
        Display[] descriptions = new Display[3];
        Scanner scan = new Scanner(System.in);
        for(int i =0; i < descriptions.length; i++){
            descriptions[i] = new Display();
            System.out.println("Enter the width of your Display: " + (i + 1) + ":");
            descriptions[i].width = scan.nextInt();
            System.out.println("Enter the height of your Display: " + (i + 1) + ":");
            descriptions[i].height = scan.nextInt();
            System.out.println("Enter the ppi of your Display: " + (i + 1) + ":");
            descriptions[i].ppi = scan.nextFloat();
            scan.nextLine();
            System.out.println("Enter the model of your Display: " + (i + 1) + ":");
            descriptions[i].model = scan.nextLine();
        }
        scan.close();

        for (int i = 0; i < descriptions.length; i++) {
            for (int j = i + 1; j < descriptions.length; j++) {
                System.out.println("Comparing " + descriptions[i].model + " and " + descriptions[j].model + ":");
                descriptions[i].compareSize(descriptions[j]);
                descriptions[i].compareSharpness(descriptions[j]);
                descriptions[i].compareWithMonitor(descriptions[j]);
            }
        }
        
    }
}

