package com.Akif;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class keeps all information about a branch.
 * It has field and operations about a branch.
 * */
public class Branch {
    /**
     * This field keeps arrayList index Number of Administrator.
     * */
    private int branchID;
    /**
     * This field keeps Name of Branch
     * */
    private String name; //branch name
    /**
     * This arraylist keeps Branch employees that this branch has.
     * */
    private ArrayList<BranchEmployee> branchEmployeeMyArray; //employees that branch has.
    /**
     * This arraylist keeps Transportation Personnel that this branch has.
     * */
    private ArrayList<TransportationPersonnel> transportationPersonnelMyArray; //transportationPersonnel that branch has.
    /**
     * This arraylist keeps Shipments that this branch has.
     * */
    private ArrayList<Shipment> shipmentMyArray; //shipments that branch has.
    /**
     * This Customer keeps Customers that this branch has.
     * */
    private ArrayList<Customer> customerMyArray; //customers that branch has.
    /**
     * No parameter constructor to initialize fields.
     * */
    public Branch() {
        this(0,"No info");
    }
    /**
     * Three parameter constructor to initialize fields.
     * @param  id branch id as index number of branch in branch array.
     * @param name branch name
     * */
    public Branch(int id, String name) {
        this.branchID = id;
        this.name = name;
        //create arrays
        branchEmployeeMyArray = new ArrayList<>();
        transportationPersonnelMyArray = new ArrayList<>();
        shipmentMyArray = new ArrayList<>();
        customerMyArray = new ArrayList<>();
    }
    //getter and Setter.
    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Add a branch employee to the this branch.
     * */
    public void addBranchEmployee(BranchEmployee branchEmployee){
        branchEmployeeMyArray.add(branchEmployee);
    }
    /**
     * Add a transportation personnel to the this branch.
     * */
    public void addTransportationPersonnel(TransportationPersonnel transportationPersonnel){
        transportationPersonnelMyArray.add(transportationPersonnel);
    }
    /**
     * Add a shipment to this branch.
     * */
    public void addShipment(Shipment shipment){
        shipmentMyArray.add(shipment);
    }
    /**
     * Add a customer to this branch.
     * */
    public void addCustomer(Customer customer){customerMyArray.add(customer);}
    /**
     * Get a branch employee from this branch.
     * @param id id of employee
     * @return Return a branch employee if it finds , otherwise throw an exception.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public BranchEmployee getBranchEmployee(int id){
        for (int i = 0; i<branchEmployeeMyArray.size();i++){
            if (branchEmployeeMyArray.get(i).getBranchID()==id){
                return branchEmployeeMyArray.get(i);
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Remove a branch employee from this branch.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public void removeBranchEmployee(BranchEmployee branchEmployee){
        for (int i = 0; i<branchEmployeeMyArray.size();i++){
            if (branchEmployeeMyArray.get(i).getBranchID()==branchEmployee.getBranchID()){
                branchEmployeeMyArray.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Get a transportation personnel from this branch.
     * @param id id of employee
     * @return Return a transportation personnel if it finds , otherwise throw an exception.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public TransportationPersonnel getTransportationPersonnel(int id){
        for (int i = 0; i<transportationPersonnelMyArray.size();i++){
            if (transportationPersonnelMyArray.get(i).getBranchID()==id){
                return transportationPersonnelMyArray.get(i);
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Remove a transportation personnel from this branch.
     * @param transportationPersonnel Personnel that will be removed.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public void removeTransportationPersonnel(TransportationPersonnel transportationPersonnel){
        for (int i = 0; i<transportationPersonnelMyArray.size();i++){
            if (transportationPersonnelMyArray.get(i).getBranchID() == transportationPersonnel.getBranchID()){
                transportationPersonnelMyArray.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Remove a shipment from this branch.
     * @param shipment shipment that will be removed.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public void removeShipment(Shipment shipment){
        for (int i = 0; i<shipmentMyArray.size();i++){
            if (shipmentMyArray.get(i).getTrackingNumber() == shipment.getTrackingNumber()){
                shipmentMyArray.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Remove a customer from this branch.
     * @param customer customer that will be removed.
     * @throws NoSuchElementException If the element can not be found.
     * */
    public void removeCustomer(Customer customer){
        for (int i = 0; i<customerMyArray.size();i++){
            if (customerMyArray.get(i).getBranchID() == customer.getBranchID()){
                customerMyArray.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * Edit BranchID of each element of branch after a branch is removed.
     * @param index new Branch ID of each branch element.
     * */
    public void editBranchID(int index){
        this.branchID=index;
        for (int i = 0; i<branchEmployeeMyArray.size();i++){
            branchEmployeeMyArray.get(i).setBranchID(index);
        }
        for (int i = 0; i<transportationPersonnelMyArray.size();i++){
            transportationPersonnelMyArray.get(i).setBranchID(index);
        }
        for (int i = 0; i<customerMyArray.size();i++){
            customerMyArray.get(i).setBranchID(index);
        }
        for (int i = 0; i<shipmentMyArray.size();i++){
            shipmentMyArray.get(i).setBranchID(index);
        }
    }
    //return size of each element
    public int numberOfShipment(){
        return shipmentMyArray.size();
    }
    public int numberOfCustomer(){
        return customerMyArray.size();
    }
    public int numberOfTransportationPersonnel(){
        return transportationPersonnelMyArray.size();
    }
    public int numberOfBranchEmployee(){
        return branchEmployeeMyArray.size();
    }

    /***
     * Creates string that contains branch name ,numberOfBranchEmployee, numberOfTransportationPersonnel,numberOfCustomer,numberOfShipment
     * @return string that is created.
     */
    public String toString(){
        return String.format("%s\n\t - Number of Branch Employee: %d\n\t - Number of Transportation Personnel: %d\n" +
                "\t - Number of Shipment: %d\n\t - Number of Customer: %d\n",getName(),numberOfBranchEmployee(),
                numberOfTransportationPersonnel(),numberOfShipment(),numberOfCustomer());
    }

}
