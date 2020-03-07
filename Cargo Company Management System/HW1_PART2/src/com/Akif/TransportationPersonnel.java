package com.Akif;
/**
 * This class keeps the information about a Transportation Personnel.
 * */
public class TransportationPersonnel extends User{
    private int branchID;
    private int recordID;
    /**
     * No parameter constructor to initialize fields.
     * */
    public TransportationPersonnel(){
        super();
        this.branchID =0;
    }
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
