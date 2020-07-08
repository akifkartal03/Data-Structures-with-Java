package com.Group1;

import java.util.Date;

/**
 * Inmate census info
 */
public class DailyInmateCensus {
    private int numberOfInmate;
    private String date;

    public DailyInmateCensus (int numberOfInmate, String date) {
        this.numberOfInmate = numberOfInmate;
        this.date = date;
    }

    public int getNumberOfInmate () {
        return numberOfInmate;
    }

    public void setNumberOfInmate (int numberOfInmate) {
        this.numberOfInmate = numberOfInmate;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    @Override
    public String toString () {
        return "DailyInmateCensus{" +
                "numberOfInmate=" + numberOfInmate +
                ", date=" + date +
                '}';
    }

}
