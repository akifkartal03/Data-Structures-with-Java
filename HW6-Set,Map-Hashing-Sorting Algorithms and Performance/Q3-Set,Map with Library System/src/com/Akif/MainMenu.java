package com.Akif;
/**
 * This class implements Menu interface to print Main Menu of the program.
 * */
public class MainMenu implements Menu{

    @Override
    public void showMenu() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.print("Welcome to Library Automation System\n");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.print("NOTE : Default Admin Information;\n");
        System.out.print("\t\tPassword : 171044098  \n");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Please choose one of the option ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Go to Admin Panel");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Go to Search Panel");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Exit.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.print( "Answer: ");
    }
}
