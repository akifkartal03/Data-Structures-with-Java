package com.Akif;

import javax.swing.event.InternalFrameListener;
import java.util.ArrayList;

/**
 * This class keeps all data regarding the System.
 * It also operate the data.
 * It keeps data by using ArrayList.
 * We wrote this class for reusable purpose, we will use this operation later.
 * */
public class Data {
    //whole data
    /**
     * This ArrayList keeps whole Administrator that are in the System.
     * */
    private ArrayList<Administrator> administratorMyArray;
    /**
     * This ArrayList keeps whole Branches that are in the System.
     * */
    private ArrayList<Branch> branchMyArray;
    /**
     * This ArrayList keeps whole Branch Employees that are in the System.
     * */
    private ArrayList<BranchEmployee> branchEmployeeMyArray;
    /**
     * This ArrayList keeps whole Transportation Personnel that are in the System.
     * */
    private ArrayList<TransportationPersonnel> transportationPersonnelMyArray;
    /**
     * This ArrayList keeps whole Customers that are in the System.
     * */
    private ArrayList<Customer> customerMyArray;
    /**
     * This ArrayList keeps whole Shipments that are in the System.
     * */
    private ArrayList<Shipment> shipmentMyArray;
    /**
     * This ArrayList keeps whole IDs that are Users have.
     * */
    private ArrayList<Integer> IDList ;
    /**
     * No parameter constructor.
     * It initializes all array.
     * */
    public Data(){
        //create ArrayLists
        administratorMyArray = new ArrayList<>();
        branchMyArray = new ArrayList<>();
        branchEmployeeMyArray = new ArrayList<>();
        transportationPersonnelMyArray = new ArrayList<>();
        customerMyArray  =new ArrayList<>();
        shipmentMyArray = new ArrayList<>();
        IDList = new ArrayList<>();
    }
    //Administrator operations
    /**
     * Add a new admin to the System.
     * @param administrator new administrator to add.
     * */
    public void addAdmin(Administrator administrator){
        administratorMyArray.add(administrator);
    }
    /**
     * Remove an admin from the System.
     * @param administrator administrator to remove.
     * @return Return administrator that was removed.
     * */
    public Administrator removeAdmin(Administrator administrator){
        Administrator temp = administratorMyArray.remove(administrator.getRecordID());
        editAdminID();
        return temp;
    }
    /**
     * Get an admin from the System.
     * @param index index of admin
     * @return Return specific index content from the Array.
     * */
    public Administrator getAdmin(int index){
        return administratorMyArray.get(index);
    }
    public int numberOfAdmin(){
        return administratorMyArray.size();
    }
    /**
     * Edit admin id according to array index.
     * */
    private void editAdminID(){
        for (int i = 0; i<administratorMyArray.size();i++){
            administratorMyArray.get(i).setId(i);
        }
    }
    //Branch operations
    /**
     * Add a new branch to the System.
     * @param branch new branch to add.
     * */
    public void addBranch(Branch branch){
        branchMyArray.add(branch);
    }
    /**
     * Remove a branch from the System.
     * It also removes the branch employee,transportation personnel,customer,shipment regarding the branch.
     * @param branch branch to remove.
     * @return Return Branch that was removed.
     * */
    public Branch removeBranch(Branch branch){
        for (int i = 0 ; i<branchEmployeeMyArray.size();i++){
            if (branchEmployeeMyArray.get(i).getBranchID() == branch.getBranchID()){
                removeBranchEmployee(branchEmployeeMyArray.get(i),branch);
            }
        }
        editBranchEmployeeID();
        for (int i =0 ; i<transportationPersonnelMyArray.size();i++){
            if (transportationPersonnelMyArray.get(i).getBranchID() == branch.getBranchID()){
                removeTransportationPersonnel(transportationPersonnelMyArray.get(i),branch);
            }
        }
        editTransportationPersonnelID();
        for (int i = 0 ; i<shipmentMyArray.size();i++){
            if (shipmentMyArray.get(i).getBranchID() == branch.getBranchID()){
                removeShipment(shipmentMyArray.get(i),shipmentMyArray.get(i).getReceiver());
            }
        }
        editShipmentID();
        for (int i =0 ; i<customerMyArray.size();i++){
            if (customerMyArray.get(i).getBranchID() == branch.getBranchID()){
                removeCustomer(customerMyArray.get(i),branch);
            }
        }
        editCustomerID();
        Branch temp = branchMyArray.remove(branch.getBranchID());
        editBranchID();
        return temp;
    }
    /**
     * Get a branch from the System.
     * @param index index of branch
     * @return Return specific index content from the Array.
     * */
    public Branch getBranch(int index){
        return branchMyArray.get(index);
    }
    public int numberOfBranch(){
        return branchMyArray.size();
    }
    /**
     * Edit branch id according to array index.
     * */
    private void editBranchID(){

        for (int i = 0; i<branchMyArray.size();i++){
            branchMyArray.get(i).editBranchID(i);
            branchMyArray.get(i).setBranchID(i);
        }
    }
    //Branch Employee
    /**
     * Add a new Branch Employee to the System and a Branch.
     * @param branchEmployee new Branch Employee to add.
     * @param branch a Branch to add Employee in it.
     * */
    public void addBranchEmployee(BranchEmployee branchEmployee,Branch branch){
        branchEmployeeMyArray.add(branchEmployee);
        branch.addBranchEmployee(branchEmployee);
    }
    /**
     * Remove a Branch Employee from the System and a Branch.
     * @param branchEmployee branch Employee to remove.
     * @param branch a Branch remove from it.
     * @return Return Branch Employee that was removed.
     * */
    public BranchEmployee removeBranchEmployee(BranchEmployee branchEmployee,Branch branch){
        BranchEmployee temp = branchEmployeeMyArray.remove(branchEmployee.getRecordID());
        branch.removeBranchEmployee(temp);
        editBranchEmployeeID();
        return temp;
    }
    /**
     * Get a Branch Employee from the System.
     * @param index index of Branch Employee.
     * @return Return specific index content from the Array.
     * */
    public BranchEmployee getBranchEmployee(int index){
        return branchEmployeeMyArray.get(index);
    }
    public int numberOfBranchEmployee(){
        return branchEmployeeMyArray.size();
    }
    /**
     * Edit Branch Employee id according to array index.
     * */
    public void editBranchEmployeeID(){
        for (int i = 0; i<branchEmployeeMyArray.size();i++){
            branchEmployeeMyArray.get(i).setRecordID(i);
        }
    }
    //Transportation Personnel
    /**
     * Add a new Transportation Personnel to the System and a Branch.
     * @param transportationPersonnel new Transportation Personnel to add.
     * @param branch a Branch to add Transportation Personnel in it.
     * */
    public void addTransportationPersonnel(TransportationPersonnel transportationPersonnel, Branch branch){
        transportationPersonnelMyArray.add(transportationPersonnel);
        branch.addTransportationPersonnel(transportationPersonnel);
    }
    /**
     * Remove a Transportation Personnel from the System and a Branch.
     * @param transportationPersonnel Transportation Personnel to remove.
     * @param branch a Branch remove from it.
     * @return Return Transportation Personnel that was removed.
     * */
    public TransportationPersonnel removeTransportationPersonnel(TransportationPersonnel transportationPersonnel,Branch branch){
        TransportationPersonnel temp = transportationPersonnelMyArray.remove(transportationPersonnel.getRecordID());
        branch.removeTransportationPersonnel(temp);
        editTransportationPersonnelID();
        return temp;
    }
    /**
     * Get a Transportation Personnel from the System.
     * @param index index of Transportation Personnel
     * */
    public TransportationPersonnel getTransportationPersonnel(int index){
        return transportationPersonnelMyArray.get(index);
    }
    public int numberOfTransportationPersonnel(){
        return transportationPersonnelMyArray.size();
    }
    /**
     * Edit Transportation Personnel id according to array index.
     * */
    private void editTransportationPersonnelID(){
        for (int i = 0; i<transportationPersonnelMyArray.size();i++){
            transportationPersonnelMyArray.get(i).setRecordID(i);
        }
    }
    //Customer
    /**
     * Add a new Customer to the System and to Branch.
     * @param customer new Customer to add.
     * */
    public void addCustomer(Customer customer,Branch branch){
        customerMyArray.add(customer);
        branch.addCustomer(customer);
    }
    /**
     * Remove a Customer from the System.
     * @param customer Customer to remove.
     * @return Return Customer that was removed.
     * */
    public Customer removeCustomer(Customer customer,Branch branch){
        Customer temp = customerMyArray.remove(customer.getId());
        branch.removeCustomer(customer);
        editCustomerID();
        return temp;
    }
    /**
     * Get a Customer from the System.
     * @param index index of Customer.
     * @return Return specific index content from the Array.
     * */
    public Customer getCustomer(int index){
        return customerMyArray.get(index);
    }
    public int numberOfCustomer(){
        return customerMyArray.size();
    }
    /**
     * Edit Customer id according to array index.
     * */
    private void editCustomerID(){
        for (int i = 0; i<customerMyArray.size();i++){
            customerMyArray.get(i).setId(i);
        }
    }
    //Shipment
    /**
     * Add a new Shipment to the System.
     * @param shipment new Shipment to add.
     * */
    public void addShipment(Shipment shipment,Customer customer){
        shipmentMyArray.add(shipment);
        customerMyArray.add(customer);
        getBranch(shipment.getBranchID()).addCustomer(customer);
        customer.addShipment(shipment);
    }

    /**
     * Remove an Shipment from the System.
     * @param shipment Shipment to remove.
     * @return Return Shipment that was removed.
     * */
    public Shipment removeShipment(Shipment shipment,Customer customer){
        Shipment temp = shipmentMyArray.remove(shipment.getShipmentID());
        for (int i = 0 ; i<customerMyArray.size();i++){
            if (customerMyArray.get(i).getId() == customer.getId()){
                customer.removeShipment(temp);
            }
        }
        editShipmentID();
        return temp;
    }
    /**
     * Get a Shipment from the System.
     * @param index index of Shipment.
     * @return Return specific index content from the Array.
     * */
    public Shipment getShipment(int index){
        return shipmentMyArray.get(index);
    }
    public int numberOfShipment(){
        return shipmentMyArray.size();
    }
    /**
     * Edit Shipment id according to array index.
     * */
    private void editShipmentID(){
        for (int i = 0; i<shipmentMyArray.size();i++){
            shipmentMyArray.get(i).setShipmentID(i);
        }
    }

    /***
     * Add given id in arraylist
     * @param id will be added.
     */
    public void addID(int id){
        IDList.add(id);
    }

    /***
     * This method checks given id is used or not ?
     * @param id will be checked
     * @return true if it is not used
     */
    public boolean IDUsed(int id){
        for (int i = 0 ; i< IDList.size();i++){
            if (IDList.get(i) == id){
                return true;
            }
        }
        return false;
    }

}
