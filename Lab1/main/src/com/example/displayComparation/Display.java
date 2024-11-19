package com.example.displayComparation;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public void setDisplayDetails(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    private int area() {
        return this.width * this.height;
    }

    public boolean isLargerThan(Display other) {
        return this.area() > other.area();
    }

    public boolean isSameSize(Display other) {
        return this.area() == other.area();
    }

    public boolean isSharperThan(Display other) {
        return this.ppi > other.ppi;
    }

    public boolean isSameSharpness(Display other) {
        return this.ppi == other.ppi;
    }

    public void compareSize(Display other) {
        if (isLargerThan(other)) {
            System.out.println(this.model + " is larger than " + other.model + " (Area: " + this.area() + " vs " + other.area() + ")");
        } else if (isSameSize(other)) {
            System.out.println(this.model + " and " + other.model + " are the same size (Area: " + this.area() + ")");
        } else {
            System.out.println(other.model + " is larger than " + this.model + " (Area: " + other.area() + " vs " + this.area() + ")");
        }
    }

    public void compareSharpness(Display other) {
        if (isSharperThan(other)) {
            System.out.println(this.model + " is sharper than " + other.model + " (PPI: " + this.ppi + " vs " + other.ppi + ")");
        } else if (isSameSharpness(other)) {
            System.out.println(this.model + " and " + other.model + " have the same sharpness (PPI: " + this.ppi + ")");
        } else {
            System.out.println(other.model + " is sharper than " + this.model + " (PPI: " + other.ppi + " vs " + this.ppi + ")");
        }
    }

    @Override
    public String toString() {
        return "Display Model: " + model + ", Width: " + width + ", Height: " + height + ", PPI: " + ppi;
    }
}
