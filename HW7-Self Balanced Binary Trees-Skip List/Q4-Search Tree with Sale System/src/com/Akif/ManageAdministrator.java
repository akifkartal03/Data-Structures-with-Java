package com.Akif;

import java.util.*;

/**
 * This class makes operations belongs to administrator.
 * We take operations to this class to write reusable code.
 * */
public class ManageAdministrator {
    /**
     * This field will be used when we make operations to reach all data.
     * */
    private Data data; //we will use it when we make operations
    /**
     * One parameter constructor.
     * This class needs to Data object to make operations.
     * @param data all data regarding the system.
     * */
    public ManageAdministrator(Data data){
        this.data = data;
    }
    /**
     * This method manages the administrator
     * First it gets a choice from user and it makes that operation
     * @param adminID adminID of Administrator that will be manage the system.
     * */
    public void manage(int adminID){
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(7,new MenuForAdministrator(data.getAdmin(adminID).getFullName ()));
            if (choice==1) {
                addSoftware ();
            } else if (choice == 2){
               removeSoftware ();
            }
            else if(choice == 3){
                updateSoftware ();
            }
            else if(choice == 4){
                sellSoftware ();
            }
            else if(choice == 5){
                addAdmin ();
            }
            else if(choice == 6){
                data.printData ();
            }
            else if(choice == 7){
                System.out.printf ("Total money from selling: %.2f$\n",data.getMoney ());
            }

        }while (choice!=0);
    }
    /**
     * This method adds a new Software to the System.
     * It uses data class to add new Software.
     * */
    public void addSoftware(){
        Software software = new Software ();
        software.setName (GetChoiceFromUser.getStringFromUser ("Enter Name(including version) of the software: "));
        software.setQuantity (GetChoiceFromUser.getNumber ("Enter quantity of software: "));
        software.setPrice (GetChoiceFromUser.getDouble ("Enter price of software: "));
        data.addSoftware (software);
        System.out.println ("Software has added.");
    }
    /**
     * This method removes a Software from the System.
     * It uses data class to remove Software.
     * */
    public void removeSoftware(){
        data.printData ();
        String softwareName = GetChoiceFromUser.getStringFromUser ("Enter a Software name to delete: ");
        if (data.contains (new Software (softwareName))){
            String ch=GetChoiceFromUser.getStringFromUser ("This software will be remove completely.\n" +
                    "To decrement quantity please use update option!\nAre you Sure(y/n): ");
            while (!ch.equalsIgnoreCase ("y") && !ch.equalsIgnoreCase ("n")){
                ch=GetChoiceFromUser.getStringFromUser ("Please enter again(y/n): ");
            }
            if (ch.equalsIgnoreCase ("y")){
                data.removeSoftware (new Software (softwareName));
                System.out.println ("Software has removed from System.");
            }
            if (ch.equalsIgnoreCase ("n")){
                System.out.println ("Software has not removed from System.");
            }
        }
        else{
            System.out.println ("This Software was not found in the System! ");
        }
    }
    /**
     * This method update a Software in the System.
     * It uses data class to update Software.
     * */
    public void updateSoftware(){
        data.printData ();
        String softwareName = GetChoiceFromUser.getStringFromUser ("Enter a Software name to update: ");
        if (data.contains (new Software (softwareName))){
            System.out.println ("Enter new information about the software.");
            Software software = new Software ();
            software.setName (GetChoiceFromUser.getStringFromUser ("Enter Name(including version) of the software: "));
            software.setQuantity (GetChoiceFromUser.getSubChoice (10000,"Enter quantity of software: "));
            software.setPrice (GetChoiceFromUser.getDouble ("Enter price of software: "));
            if (software.getQuantity ()==0){
                data.removeSoftware (new Software (softwareName));
                System.out.println ("This package is sold out and removed.");
            }
            else{
                data.updateSoftware (new Software (softwareName),software);
                System.out.println ("Software has updated.");
            }

        }
        else{
            System.out.println ("This Software was not found in the System! ");
        }

    }

    /**
     * This method sells a software form the system.
     * After selling If a package is sold out, the information about the package should be deleted.
     */
    public void sellSoftware(){
        data.printData ();
        String softwareName = GetChoiceFromUser.getStringFromUser ("Enter a Software name to sell: ");
        if (data.contains (new Software (softwareName))){
            Software software = data.getSoftware (new Software (softwareName));
            int number =GetChoiceFromUser.getSubChoice (software.getQuantity (),"How many do you want to sell: ");
            software.setQuantity (software.getQuantity ()-number);
            data.addMoney (software.getPrice ()*number);
            if (software.getQuantity ()==0){
                data.removeSoftware (software);
                System.out.println ("This package is sold out and removed.");
            }
            else{
                if (number==0)
                    System.out.println ("Nothing is sold.");
                else{
                    data.updateSoftware (new Software (softwareName),software);
                    System.out.println ("The quantity of package is updated.");
                }
            }
        }
        else{
            System.out.println ("This Software was not found in the System! ");
        }
    }
    /**
     * This method adds a new Administrator to the System.
     * It uses data class to add new Administrator.
     * */
    public void addAdmin(){
        Administrator administrator = new Administrator();
        administrator.setFullName (GetChoiceFromUser.getStringFromUser("Enter a full Name: "));
        administrator.setId(GetChoiceFromUser.getIDFromUser(data));
        administrator.setPassword(GetChoiceFromUser.getStringFromUser("Enter a password: "));
        data.addAdmin(administrator);
        System.out.println("Your Administrator has added Successfully!");
    }

}
