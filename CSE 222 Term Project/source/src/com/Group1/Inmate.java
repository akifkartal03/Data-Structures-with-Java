package com.Group1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This class is to keep inmate info in the system.
 */
public class Inmate implements Comparable<Inmate> {

    private int id;
    private String fullName;
    private CrimeType crimeType;
    private int remainingDay;
    private int wardNo;
    private String exitTime;
    private HealthStatus healthStatus;

    public Inmate (int id,String name, CrimeType crimeType, String exitTime, int wardNo, HealthStatus healthStatus) {
        //give id programmatically here.
        this.fullName = name;
        this.crimeType = crimeType;
        this.remainingDay = getDay (exitTime);
        this.wardNo = wardNo;
        this.healthStatus = healthStatus;
        this.id = id;
        this.exitTime = exitTime;

    }

    //this constructor is used to search an Inmate.
    public Inmate(int id){
        this(id,"No info",CrimeType.INFRACTION,  "11/01/1999",0,new HealthStatus ());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }

    public int getRemainingDay() {
        return getDay (exitTime);
    }

    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getExitTime () {
        return exitTime;
    }

    public void setExitTime (String exitTime) {
        this.exitTime = exitTime;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }

    public HealthStatus getHealthStatus () {
        return healthStatus;
    }

    public void setHealthStatus (HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Inmate{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                ", crimeType='" + crimeType + '\'' +
                ", remainingDay=" + getRemainingDay () +
                ", wardNo=" + wardNo +
                '}';
    }
    @Override
    public int compareTo (Inmate o) {
        if (this.id == o.id )
            return 0;
        else if (this.id < o.id)
            return -1;
        else
            return 1;
    }

    //calculate remaining date
    private int getDay(String exitDate) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = myFormat.format(new Date ());
        try {
            Date date1 = myFormat.parse(exitDate);
            Date date2 = myFormat.parse(todayDate);
            long diff = date1.getTime() - date2.getTime();
            return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
