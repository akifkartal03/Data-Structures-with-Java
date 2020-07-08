package com.Akif;

/***
 * This class is to handle both age and number of people at that age values.
 * It implements Comparable interface
 */
public class AgeData implements Comparable<AgeData> {
    /**
     * Age value.
     */
    private  int age;
    /**
     * Number of people at that age.
     */
    private int total;

    /**
     * One parameter constructor to initialize age data with given age.
     * @param age any age value greater than equal zero.
     * @throws IllegalArgumentException if age less than zero. 
     */
    public AgeData (int age) {
        if (age<0){
            throw new IllegalArgumentException ();
        }
        this.age = age;
        total=1;
    }

    /**
     * Return age value.
     * @return age value
     */
    public int getAge () {
        return age;
    }

    /**
     * Sets age value.
     * @param age any age value greater than equal zero.
     * @throws IllegalArgumentException if age less than zero.
     */
    public void setAge (int age) {
        if (age<0){
            throw new IllegalArgumentException ();
        }
        this.age = age;
    }

    /**
     * Returns number of people at that age.
     * @return number of people at that age.
     */
    public int getTotal () {
        return total;
    }

    /**
     * Increments number of people at that age by one.
     */
    public void incrementTotal(){
        total++;
    }

    /**
     * Decrease number of people at that age by one.
     */
    public void decrementTotal(){
        total--;
    }

    /**
     * Compares AgeData objects according to the number of people at that age.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
     * or greater than the specified object.
     */
    @Override
    public int compareTo (AgeData o) {
        if (this.total==o.getTotal ())
            return 0;
        else if (this.total>o.getTotal ())
            return 1;
        else
            return -1;
    }
    /***
     * Returns a string representation of this AgeData.
     * @return a string representation of this AgeData
     */
    @Override
    public String toString () {
        return getAge ()+" - " + getTotal ();
    }

    /***
     * Compares the specified object with this object for equality.
     * Returns true if and only if the specified object is equal this object.
     * @param obj the object to be compared for equality.
     * @return true if the specified object is equal to this object.
     */
    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AgeData temp = (AgeData) obj;
        return getAge () == temp.getAge ();
    }
}
