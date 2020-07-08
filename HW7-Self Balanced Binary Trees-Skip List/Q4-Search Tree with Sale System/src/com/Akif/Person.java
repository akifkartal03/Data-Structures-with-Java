package com.Akif;

/**
 * This is general person class with only full name.
 */
public class Person {
    /**
     * Name of this person.
     */
    private String fullName;
    /**
     * No parameter constructor to initialize fields.
     * */
    public Person () {
        this("No info");

    }
    /**
     * Four parameter constructor to initialize full name.
     * @param fullName Full Name of user.
     * */
    public Person (String fullName) {
        this.fullName  = fullName;
    }
    //getter and setter
    public String getFullName () {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }
    /***
     * Creates a String that contains full name of person.
     * @return String that contains full name of person.
     */
    @Override
    public String toString () {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
