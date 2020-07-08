package com.Akif;
/**
 * This class implements Menu interface to print Search options Menu of the program.
 * */
public class MenuToSearch implements Menu {
    @Override
    public void showMenu() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome to Search Screen ");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Please choose one of the search option ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Search by author name");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Search by book title");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Print All Authors and Books");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.print( "Answer: ");

    }
}
