package com.Akif;

import java.util.ArrayList;

/**
 * This class makes operations belongs to Branch Employee
 * We take operations to this class to write reusable code.
 * */
public class ManageBranchEmployee {
    /**
     * This field will be used when we make operations.
     * */
    private Data data; // it uses data  to make operations
    /**
     * This field will be used when we print the data
     * */
    PrintData printData; // it uses print data to print data on the screen.
    /**
     * This ArrayList keeps whole tracking Numbers that are Shipments have.
     * */
    private ArrayList<Integer> trackingNumbers;
    /**
     * ID of employee
     * */
    int ID;
    /**
     * SubChoice of the user.
     * */
    int subChoice;
    /**
     * Two parameter constructor.
     * This class needs to Data object and PrintData object to make operations.
     * @param data all data regarding the system
     * @param printData it prints the data to the screen.
     * */
    public ManageBranchEmployee(Data data,PrintData printData){
        this.data = data;
        this.printData = printData;
        trackingNumbers = new ArrayList<>();
    }
    /**
     * This method manages the Branch Employee
     * First it gets a choice from user and it makes that operation
     * @param employeeID ID of Employee that will be manage the system.
     * */
    public void manage(int employeeID){
        ID = employeeID;
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(5,new MenuForBranchEmployee(data.getBranchEmployee(employeeID).getFirstName()));
            if (choice==1) {
                enterShipment();
            } else if (choice == 2){
                removeShipment();
            }
            else if(choice == 3){
                addCustomer();
            }
            else if(choice == 4){
                removeCustomer();
            }
            else if(choice == 5){
                updateStatusOfShipment(data.getBranchEmployee(ID).getFirstName(),data.getBranchEmployee(ID).getBranchID());
            }

        }while (choice!=0);
    }
    /**
     * This method adds a new Shipment to the System.
     * It uses data class to add new Shipment.
     * */
    public void enterShipment(){
        Shipment shipment = new Shipment();
        shipment.setShipmentID(data.numberOfShipment());
        shipment.setReceiver(new Customer(data.numberOfCustomer(), GetChoiceFromUser.getStringFromUser("Enter Receiver FirstName: "),
                GetChoiceFromUser.getStringFromUser("Enter Receiver Last Name: "),data.getBranchEmployee(ID).getBranchID()));
        shipment.setSender(new Customer(data.numberOfCustomer(), GetChoiceFromUser.getStringFromUser("Enter Sender First Name: "),
                GetChoiceFromUser.getStringFromUser("Enter Sender Last Name: "),data.getBranchEmployee(ID).getBranchID()));
        shipment.setCurrentStatus(getStatus());
        shipment.setTrackingNumber(getUniqueTrackingNumber());
        shipment.setBranchID(data.getBranchEmployee(ID).getBranchID());
        data.getBranch(shipment.getBranchID()).addShipment(shipment);
        data.addShipment(shipment,shipment.getReceiver());
        System.out.printf("Your Shipment has added with tracking Number %d !\n",shipment.getTrackingNumber());
    }
    /**
     * This method removes a Shipment from the System.
     * It uses data class to remove Shipment.
     * */
    public void removeShipment(){
        String message = "Choose one of the shipment to remove";
        if (printData.checkAndPrintShipment(message,data.getBranchEmployee(ID).getBranchID())){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfShipment());
            if (subChoice!=0){
                data.getBranch(data.getShipment(subChoice-1).getBranchID()).removeShipment(data.getShipment(subChoice-1));
                data.removeShipment(data.getShipment(subChoice-1),data.getShipment(subChoice-1).getReceiver());
                System.out.println("Your Shipment has removed Successfully!");
            }
        }
    }
    /**
     * This method updates the status of Shipment.
     * It uses data class to updates the status.
     * */
    public void updateStatusOfShipment(String name,int id){
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Employee " + name + " to the Status Updating Panel.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        String message = "Choose one of the shipment to update Status";
        if (printData.checkAndPrintShipment(message,id)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfShipment());
            if (subChoice!=0){
                data.getShipment(subChoice-1).setCurrentStatus(getStatus());
                System.out.println("Shipment Status has changed Successfully!");
            }
        }
        else{
            System.out.println("To change status please add a shipment.");
        }
    }
    /**
     * This method adds a new Customer to the System.
     * It uses data class to add new Customer.
     * */
    public void addCustomer(){
        Customer customer = new Customer();
        customer.setId(data.numberOfCustomer());
        customer.setFirstName(GetChoiceFromUser.getStringFromUser("Enter First Name: "));
        customer.setLastName(GetChoiceFromUser.getStringFromUser("Enter Last Name: "));
        data.addCustomer(customer,data.getBranch(data.getBranchEmployee(ID).getBranchID()));
        System.out.println("Customer has added Successfully!");
    }
    /**
     * This method removes a Customer from the System.
     * It uses data class to remove Customer.
     * */
    public void removeCustomer(){
        String message = "Choose one of the Customer to remove it";
        if (printData.checkAndPrintCustomer(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfCustomer());
            if (subChoice!=0){
                data.removeCustomer(data.getCustomer(subChoice-1),data.getBranch(data.getBranchEmployee(ID).getBranchID()));
                System.out.println("Customer has removed Successfully!");
            }
        }
    }
    /**
     * This method creates a Random unique number between 100000 and 999999.
     * @return Return a number
     * */
    public int getUniqueTrackingNumber(){
        boolean is_used = false;
        int number;
        do {
            number = (int)(Math.random() * 999999 + 100000);
            for (int i = 0; i < trackingNumbers.size() ; i++) {
                if (trackingNumbers.get(i) == number){
                    is_used=true;
                }
            }
        }while (is_used);
        trackingNumbers.add(number);
        return number;

    }
    /**
     * This method is to determine status of the shipment.
     * @return Return a number
     * */
    public String getStatus(){
        int chosen;
        System.out.println("Choose a Shipment Status ?");
        System.out.println("[1] Pending ");
        System.out.println("[2] Picked Up");
        System.out.println("[3] In transit to destination.");
        System.out.println("[4] Delivered.");
        System.out.println("[5] Out of Delivery.");
        System.out.print( "Answer: ");
        chosen = GetChoiceFromUser.getSubChoice(5);
        switch (chosen){
            case 1 :
                return "Pending";
            case 2:
                return "Picked Up";
            case 3 :
                return "In transit to destination.";
            case 4:
                return "Delivered";
            case 5:
                return "Out of Delivery.";
            default:
                return "No info";
        }
    }
}
