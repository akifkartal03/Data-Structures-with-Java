package com.Akif;
/**
 * A general Class for all Employees.
 * It implements UserInterface to implement methods regarding a user.
 * */
public abstract class User implements UserInterface{
    private  int identityNumber;
    private String firstName;
    private  String lastName;
    private String password;
    /**
     * No parameter constructor to initialize fields.
     * */
    public User() {
        this(0,"No info","No info","No info");
    }
    /**
     * Four parameter constructor to initialize fields.
     * @param id Identity Number of user generally it is index number of that user in an array.
     * @param firstName First Name of user.
     * @param lastName Last Name of user.
     * @param password password of user that will be used when entry the system.
     * */
    public User(int id, String firstName, String lastName,String password) {
        this.identityNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    public int getId() {
        return identityNumber;
    }
    public void setId(int id) {
        this.identityNumber = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public abstract void setRecordID(int recordID);
    public abstract int getRecordID();
    /***
     * Creates a String that contains first name and Last name
     * @return String that contains first name and Last name
     */
    public String toString(){
        return String.format("%s %s\n",this.getFirstName(),this.getLastName());
    }
}
