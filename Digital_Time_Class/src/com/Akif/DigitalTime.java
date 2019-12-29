package com.Akif;

import java.security.InvalidParameterException;
/**
 * This is a basic Digital time Class.
 * It was written to do practice.
 * It implements Comparable interface.
 * @author Akif Kartal
 * @version 1.0
 * */
public class DigitalTime implements Comparable{
    private int hour;
    private int minute;
    /**
     * No parameter Constructor
     * */
    public DigitalTime(){
        this(0,0);
    }
    /**
     * One parameter Constructor
     * */
    public DigitalTime(int h){
        this(h,0);
    }
    /**
     * Two parameter Constructor
     * */
    public DigitalTime(int h,int m){
        if (h<0 || h>23 || m<0 || m>60 )
            throw new InvalidParameterException();
        hour=h;
        minute=m;
    }
    public int getHour(){
        return hour;
    }
    public void setHour(int h){
        if (h<0 || h>23 )
            throw new InvalidParameterException();
        hour=h;
    }
    public int getMinute(){
        return minute;
    }
    public void setMinute(int m){
        if (m<0 || m>60 )
            throw new InvalidParameterException();
        minute=m;
    }
    @Override
    public int compareTo(Object o) {
        if(this.getHour()>((DigitalTime)o).getHour())
            return 1;
        else if(this.getHour()==((DigitalTime)o).getHour()){
            if(this.getMinute()>((DigitalTime)o).getMinute())
                return 1;
            else if(this.getMinute()==((DigitalTime)o).getMinute())
                return 0;
            else
                 return -1;
        }
        else
            return -1;
    }
    public String toString(){
        if (getHour()<10 && getMinute()<10)
            return String.format("Time: 0%d:0%d",getHour(),getMinute());
        else if (getHour()<10 && getMinute()>10)
            return String.format("Time: 0%d:%d",getHour(),getMinute());
        else if (getHour()>10 && getMinute()<10)
            return String.format("Time: %d:0%d",getHour(),getMinute());
        else
            return String.format("Time: %d:%d",getHour(),getMinute());
    }
    /**
     *  Add two time and return a new one.
     *  @param other other time to add with me
     * */
    public DigitalTime add(DigitalTime other){
        DigitalTime newTime = new DigitalTime();
        if (this.getHour()+other.getHour()>23)
            newTime.setHour(24-(this.getHour()+other.getHour()));
        else
            newTime.setHour(this.getHour()+other.getHour());
        if (this.getMinute()+other.getMinute()>60)
            newTime.setMinute(60-(this.getMinute()+other.getMinute()));
        else
            newTime.setMinute(this.getMinute()+other.getMinute());
        return newTime;
    }
    /**
     *  Add the time hours and minutes.
     * @param h hour
     * @param m minute
     * */
    public void advance(int h,int m){
        if (this.getHour()+h>23)
            this.setHour(24-(this.getHour()+h));
        else
            this.setHour(this.getHour()+h);
        if (this.getMinute()+m>60)
            this.setMinute(60-(this.getMinute()+m));
        else
            this.setMinute(this.getMinute()+m);
    }
    /**
     *  Convert the time to a double.
     *  For example 21:42 to 21,42
     * */
    public double toDouble(){
        double number=getHour()+(double)getMinute()/100.0;
        return  number;
    }
}
