package com.Akif;
/**
 * This Class contains the information about the shipment.
 * */
public class Shipment {
    /***
     * Shipment ID is ArrayList index of shipment.
     */
    private int shipmentID;
    private  int trackingNumber;
    private String currentStatus;
    /***
     * Sender information is kept as a Customer.
     */
    private  Customer sender;
    /***
     * Receiver information is kept as a Customer.
     */
    private Customer receiver;
    private int branchID;
    //getter and setter
    public int getTrackingNumber() {
        return trackingNumber;
    }
    
    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public int getShipmentID() {
        return shipmentID;
    }
    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }
    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    /***
     * Creates string that contains Tracking Number,receiver info ,sender info and Status.
     * @return string that is created.
     */
    public String toString(){
        return String.format("Tracking ID: %d\n\t - Receiver: %s %s\n\t - Sender: %s %s\n\t - Status: %s\n",
                getTrackingNumber(),getReceiver().getFirstName(),getReceiver().getLastName(),
                getSender().getFirstName(),getSender().getLastName(),getCurrentStatus());
    }

}
