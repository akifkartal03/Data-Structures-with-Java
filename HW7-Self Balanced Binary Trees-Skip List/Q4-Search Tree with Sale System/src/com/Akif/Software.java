package com.Akif;

/**
 * This is the class to keep a software information in the system.
 */
public class Software implements Comparable<Software> {
    /**
     * Name of the software.
     */
    private String name;
    /**
     * Quantity of the software.
     */
    private int quantity;
    /**
     * Price of the software.
     */
    private double price;

    /**
     * No parameter constructor to initialize fields as default.
     */
    public Software () {
        this.name = "Default";
        this.quantity = 0;
        this.price = 0;

    }

    /**
     * One parameter constructor to initialize software with given name.
     * @param name name of software with version.
     */
    public Software (String name) {
        this.name = name;
        this.quantity = 0;
        this.price = 0;
    }

    /**
     * Full parameter constructor to initialize software with given properties.
     * @param name name of the software
     * @param quantity quantity of the software
     * @param price price of the software
     */
    public Software (String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    //getter-setter
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    /***
     * Returns a String that contains all properties of Software.
     * @return String that contains all properties of Software.
     */
    @Override
    public String toString () {
        return "Software{" +
                "Name= '" + name + '\'' +
                ", quantity= " + quantity +
                ", price= " + price + "$ "+
                '}';
    }

    /**
     * Compares this software with the specified software for order.
     * Returns a negative integer, zero, or a positive integer as this software is less than, equal to,
     * or greater than the specified software.
     * It compares with name of the software.
     * @param o the software to be compared.
     * @return a negative integer, zero, or a positive integer as this software is less than, equal to,
     * or greater than the specified software.
     */
    @Override
    public int compareTo (Software o) {
        return this.name.compareTo (o.name);
    }
}
