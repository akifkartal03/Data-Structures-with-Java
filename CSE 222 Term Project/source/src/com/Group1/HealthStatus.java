package com.Group1;

import java.util.ArrayList;

/**
 * Health status both inmate and personnel
 */
public class HealthStatus {
    private String bloodGroup;
    private String lastControlResult;
    private double height;
    private double weight;
    private double pulse;//nabız
    public HealthStatus(){
        this("none", "none", 0,0,0);
    }
    public HealthStatus (String bloodGroup, String lastControlResult, double height, double weight, double pulse) {
        this.bloodGroup = bloodGroup;
        this.lastControlResult = lastControlResult;
        this.height = height;
        this.weight = weight;
        this.pulse = pulse;
    }

    public String getBloodGroup () {
        return bloodGroup;
    }

    public void setBloodGroup (String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getLastControlResult () {
        return lastControlResult;
    }

    public void setLastControlResult (String lastControlResult) {
        this.lastControlResult = lastControlResult;
    }

    public double getHeight () {
        return height;
    }

    public void setHeight (double length) {
        this.height= length;
    }

    public double getWeight () {
        return weight;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }

    public double getPulse () {
        return pulse;
    }

    public void setPulse (double pulse) {
        this.pulse = pulse;
    }
    
    @Override
    public String toString() {
        return "Health Information" +
                "\n\tLength = " + height + '\'' +
                "\n\tWeight = " + weight + '\'' +
                "\n\tBlood Group = " + bloodGroup +
                "\n\tPulse = " + pulse +
                "\n\tLast Report : " + lastControlResult;
    }

}

