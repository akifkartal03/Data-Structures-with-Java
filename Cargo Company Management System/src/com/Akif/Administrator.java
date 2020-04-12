package com.Akif;
/**
 * This class holds the Administrator information.
 * There is no any operation.Operations will be manage class.
 * */
public class Administrator extends User {
    /**
     * This field keeps arrayList index Number of Administrator.
     * */
    private int recordID;
    /**
     * No parameter constructor to initialize fields.
     * */
    public Administrator(){
        super();
    }
    public int getRecordID() {
        return recordID;
    }
    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

}
