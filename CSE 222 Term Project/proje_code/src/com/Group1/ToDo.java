package com.Group1;

import java.util.Date;

/**
 * This class keep to information for personnel
 */
public class ToDo implements Comparable<ToDo>{
    private String job;
    private int ownerID;
    private int importanceOrder;
    private int id;
    /**
     * Create a ToDo by giving parameters.
     * @param job description of the job to be done.
     * @param ownerID personnel id of job
     */
    public ToDo (String job, int ownerID) {
        this.job = job;
        this.ownerID = ownerID;
        this.importanceOrder = Counter.getID ();
        this.id = Counter.getID ();
    }
    public ToDo (int id,String job, int ownerID) {
        this.job = job;
        this.ownerID = ownerID;
        this.importanceOrder = Counter.getID ();
        this.id = id;
    }
    public String getJob () {
        return job;
    }
    public void setJob (String job) {
        this.job = job;
    }

    public int getOwnerID () {
        return ownerID;
    }

    public void setOwnerID (int ownerID) {
        this.ownerID = ownerID;
    }

    public int getImportanceOrder () {
        return importanceOrder;
    }

    public void setImportanceOrder (int importanceOrder) {
        this.importanceOrder = importanceOrder;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Override
    public String toString () {
        return "ToDo{" +
                "job='" + job + '\'' +
                ", ownerID=" + ownerID +
                ", importanceOrder=" + importanceOrder +
                '}';
    }

    //compare according to importance order.
    @Override
    public int compareTo (ToDo o) {
        if (this.importanceOrder > o.importanceOrder)
            return 1;
        else if (this.importanceOrder == o.importanceOrder)
            return 0;
        else
            return -1;
    }
}
