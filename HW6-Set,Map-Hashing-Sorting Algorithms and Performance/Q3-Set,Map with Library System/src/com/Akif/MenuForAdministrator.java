package com.Akif;
/**
 * This class implements Menu interface to print Administrator's Menu of the program.
 * */
public class MenuForAdministrator implements Menu {
    String name;
    public MenuForAdministrator(String name){
        this.name = name;
    }
    @Override
    public void showMenu() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Administrator " + name);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Add a book");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Delete a book");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Update a book");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Add an Admin");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5] Print all Data");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.print( "Answer: ");
    }
}
