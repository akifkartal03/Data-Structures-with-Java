package com.Akif;
/***
 * This class keeps information about a Person.
 */
public class Person {
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    public Person () {
        this(1,"default","default",0);
    }
    public Person (int ID, String firstName, String lastName, int age) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getID () {
        return ID;
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public int getAge () {
        return age;
    }
    public void setAge (int age) {
        this.age = age;
    }

}
