package com.Akif;
/**
 * A general Class for all Administrator.
 * */
public class Administrator extends Person{
    private  int identityNumber;
    private String password;
    /**
     * No parameter constructor to initialize fields.
     * */
    public Administrator () {
        this(0,"No info","No info");
    }
    /**
     * Four parameter constructor to initialize fields.
     * @param id Identity Number of user Administrator.
     * @param firstName full Name of admin.
     * @param password password of admin that will be used when entry the system.
     * */
    public Administrator (int id, String firstName,String password) {
        super(firstName);
        this.identityNumber = id;
        this.password = password;
    }
    //getter and setter
    public int getId() {
        return identityNumber;
    }
    public void setId(int id) {
        this.identityNumber = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    /***
     * Creates a String that contains full name
     * @return String that contains full name
     */
    public String toString(){
        return String.format("%s\n",this.getFullName ());
    }
}
