package com.Akif;

import java.util.Scanner;
/**
 * This Class is first to show the menu and then to get choice from user.
 * It contains only static method to use method with class name.
 * */
public class GetChoiceFromUser {
    /**
     * This method gets an integer number from user with showing a message.
     * @param upperBound Upper Bound of choices.
     * @param message a message to show user.
     * @return Return number that entered by user
     * */
    public static int getSubChoice(int upperBound,String message){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        try {
            choice = input.nextInt();
            while (choice<0 || choice>upperBound){
                System.out.printf("Please enter a number between 0 and %d: ",upperBound);
                choice=input.nextInt();
            }
        }
        catch (Exception e){
            choice=1;
            System.out.printf("Please enter a number between 0 and %d!\n",upperBound);
            input.nextLine();
        }
        return choice;
    }
    /**
     * This is overloaded version of getSubChoice method gets an integer number from user with showing a menu.
     * This Method uses Menu Interface to benefit from polymorphism.
     * @param upperBound Upper Bound of choices.
     * @param menu A menu type that will be showed to the User.
     * @return Return number that entered by user
     * */
    public static int getSubChoice(int upperBound,Menu menu){
        int choice;
        Scanner input = new Scanner(System.in);
        menu.showMenu();
        try {
            choice = input.nextInt();
            while (choice<0 || choice>upperBound){
                System.out.printf("Please enter a number between 0 and %d: ",upperBound);
                choice=input.nextInt();
            }
        }
        catch (Exception e){
            choice=1;
            System.out.printf("Please enter a number between 0 and %d!\n",upperBound);
            input.nextLine();
        }
        return choice;
    }
    /**
     * This method first show the message then gets a String from user.
     * @param message Message that will be printed.
     * @return Return String that entered by user
     * */
    public static String getStringFromUser(String message){
        Scanner input = new Scanner(System.in);
        String bName=null;
        System.out.print(message);
        try {
            bName = input.nextLine();
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }
        return bName;
    }
    /**
     * This method gets an integer number from user as an id.
     * @return Return number that entered by user
     * */
    public static int getIDFromUser(Data data){
        Scanner input = new Scanner(System.in);
        boolean is_in;
        int id=0;
        try {
            do {
                System.out.print("Enter your ID as Number: ");
                id = input.nextInt();
                is_in=false;
                if (id<1){
                    System.out.println("ID can not be less than 1!");
                    is_in=true;
                }
                if (data.IDUsed(id)){
                    System.out.println("This ID has used before!");
                    is_in=true;
                }
            }while(is_in);
            data.addID(id);
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }
        return id;
    }
}
