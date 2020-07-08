package com.Akif;
/**
 * This class holds the Branch Employee information.
 * There is no any operation. Operation will be manage class.
 * */
public class BranchEmployee extends User {
    /**
     * Branch id of Branch Employee.
     * */
    private int branchID;
    /**
     * This field keeps arrayList index Number of Branch Employee.
     * */
    private int recordID; //array index of Employee
    /**
     * No parameter constructor to initialize fields.
     * */
    public BranchEmployee(){
        super();
        this.branchID =0;
    }
    //getter and setter
    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    public int getRecordID() {
        return recordID;
    }
    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

}
