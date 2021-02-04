package com.Group1;

import java.util.Scanner;
/**
 * This class is to validate entry information of users(ID and Password).
 * */
public class Validate {
    /**
     * This will be used to validate information.
     * */
    DataBase data;
    /**
     * One parameter constructor.
     * This class needs to Data object to validate the user.
     * @param data all data regarding the system
     * */
    public Validate(DataBase data){
        this.data = data;
    }
    /**
     * This method validates the admin information.
     * @return Returns true if information are true otherwise return false.
     * */
    public Personnel validatePersonnel(){
        int id = getIDFromUser();
        String password = getPasswordFromUser();
        return data.checkPassword (id,password);
    }

    /**
     * This method gets a Integer from user as a ID
     * @return Return ID that entered by user
     * */
    public int getIDFromUser(){
        Scanner input = new Scanner(System.in);
        int id=0;
        try {

            System.out.print("Enter your ID as Number: ");
            id = input.nextInt();
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }
        return id;
    }
    /**
     * This method gets a String from user as a password
     * @return Return String that entered by user
     * */
    private String getPasswordFromUser(){
        Scanner input = new Scanner(System.in);
        String password = null;
        try {
            System.out.print("Enter your Password: ");
            password = input.nextLine();
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }
        return password;
    }
}
