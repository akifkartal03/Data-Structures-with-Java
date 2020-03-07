package com.Akif;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * This class keeps all information about a Customer.
 * It has field and operations .
 * */
public class Customer extends User{
    /**
     * This arraylist keeps Shipments that this Customer has.
     * */
    private ArrayList<Shipment> shipments;
    /**
     * Branch id of Customer.
     * */
    private int branchID;
    /**
     * This field keeps arrayList index Number of Customer.
     * */
    private int recordID;
    /**
     * No parameter constructor to initialize fields.
     * */
    public Customer(){
        super();
        shipments = new ArrayList<>(); //create array
    }
    /**
     * Three parameter constructor to initialize fields.
     * @param  id customer identity number
     * @param name customer name
     * @param lastName customer last name
     * */
    public Customer(int id,String name,String lastName,int branchID){
        super(id,name,lastName,"customer");
        this.branchID =branchID;
        shipments = new ArrayList<>();
    }
    //getter setter
    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    /**
     * @return Return number of Customer's shipments
     * */
    public int numberOfMyCargo(){
        return shipments.size();
    }
    /**
     * Add a new Shipment to the Customer's shipments.
     * @param shipment shipment to add.
     * */
    public void addShipment(Shipment shipment){
        shipments.add(shipment);
    }
    /**
     * Remove a Shipment from the Customer's shipments.
     * @param shipment shipment to remove.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public void removeShipment(Shipment shipment){
        for (int i = 0; i<shipments.size();i++){
            if (shipments.get(i).getTrackingNumber()==shipment.getTrackingNumber()){
                shipments.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Authorize the customer to see the name and surname information of the sender
     * and receiver and the current status of the cargo.
     * @param data All data to get Shipment
     * */
    public static void manageCustomer(Data data){
        int trackingNumber;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Please enter your tracking Number: ");
            trackingNumber = input.nextInt();
            for (int i = 0; i<data.numberOfShipment();i++){
                if (data.getShipment(i).getTrackingNumber() == trackingNumber){
                    System.out.println("***Shipment Information*** ");
                    System.out.printf("\t - Tracking ID: %d\n",data.getShipment(i).getTrackingNumber());
                    System.out.printf("\t - Receiver: %s %s\n",data.getShipment(i).getReceiver().getFirstName(),data.getShipment(i).getReceiver().getLastName());
                    System.out.printf("\t - Sender: %s %s\n",data.getShipment(i).getSender().getFirstName(),data.getShipment(i).getSender().getLastName());
                    System.out.printf("\t - Status: %s\n",data.getShipment(i).getCurrentStatus());
                    return;
                }
            }
            System.out.println("Shipment was not find!");
        }
        catch (Exception e){
            System.out.print("Please enter a valid value!\n");
            input.nextLine();
        }

    }

    @Override
    public int getRecordID() {
        return recordID;
    }

    @Override
    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

}
