package com.Group1;

import java.util.Scanner;
/**
 * This Class is first to show the message and then to get choice from user.
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
     * This method gets an integer number from user with showing a message.
     * The number should be bigger than 1.
     * @param message a message to show user.
     * @return Return number that entered by user
     * */
    public static int getNumber(String message){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        try {
            choice = input.nextInt();
            if(choice == -1)
            	return -1;
            while (choice<1 && choice != -1){
                System.out.print("Please enter a number bigger than 0: ");
                choice=input.nextInt();
            }
        }
        catch (Exception e){
            choice=1;
            System.out.println("Please enter a number!");
            input.nextLine();
        }
        return choice;
    }
    /**
     * This method gets an double number from user with showing a message.
     * The number should be bigger than 0.
     * @param message a message to show user.
     * @return Return number that entered by user
     * */
    public static double getDouble(String message){
        double choice;
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        try {
            choice = input.nextDouble ();
            while (choice<=0){
                System.out.print("Please enter a number bigger than 0: ");
                choice=input.nextDouble ();
            }
        }
        catch (Exception e){
            choice=1;
            System.out.println("Please enter a number!");
            input.nextLine();
        }
        return choice;
    }
     /**
     * This method gets an integer number from user as an id.
     * @param data databas reference
     * @return Return number that entered by user
     * */
    public static int getIDFromUser(DataBase data){
        Scanner input = new Scanner(System.in);
        boolean is_in;
        int id=0;
        try {
            do {
                System.out.print("Enter ID as a 5 digit Number: ");
                id = input.nextInt();
                is_in=false;
                if (id<10000 || id>=100000){
                    System.out.println("ID should be 5 digit!");
                    is_in=true;
                }
                else if (data.IDUsed(id)){
                    System.out.println("This ID has used before!");
                    is_in=true;
                }
            }while(is_in);
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }
        return id;
    }
}
