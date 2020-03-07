package com.Akif;

import java.util.Scanner;
/**
 * This class is to validate entry information of user(ID and Password).
 * */
public class Validate {
    /**
     * This will be used to validate information.
     * */
    Data data;
    /**
     * One parameter constructor.
     * This class needs to Data object to validate the user.
     * @param data all data regarding the system
     * */
    public Validate(Data data){
        this.data = data;
    }
    /**
     * This method validates the admin information.
     * @return Returns true if information are true otherwise return false.
     * */
    public int validateAdmin(){
        int id = getIDFromUser();
        String password = getPasswordFromUser();
        for (int i =0 ; i<data.numberOfAdmin();i++){
            if (data.getAdmin(i).getId() == id){
                if (data.getAdmin(i).getPassword().equals(password)){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * This method validates the Branch Employee information.
     * @return Returns true if information are true otherwise return false.
     * */
    public int validateBranchEmployee(){
        int id = getIDFromUser();
        String password = getPasswordFromUser();
        for (int i =0 ; i<data.numberOfBranchEmployee();i++){
            if (data.getBranchEmployee(i).getId() == id){
                if (data.getBranchEmployee(i).getPassword().equals(password)){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * This method validates the Transportation Personnel information.
     * @return Returns true if information are true otherwise return false.
     * */
    public int validateTransportationPersonnel(){
        int id = getIDFromUser();
        String password = getPasswordFromUser();
        for (int i =0 ; i<data.numberOfTransportationPersonnel();i++){
            if (data.getTransportationPersonnel(i).getId() == id){
                if (data.getTransportationPersonnel(i).getPassword().equals(password)){
                    return i;
                }
            }
        }
        return -1;
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
