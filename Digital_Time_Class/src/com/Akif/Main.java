package com.Akif;
/**
 * This is a test class for DigitalTime class.
 * */
public class Main {

    public static void main(String[] args) {
    	try{
			DigitalTime time=new DigitalTime();
			DigitalTime time2=new DigitalTime(17,37);
			time.setHour(17);
			time.setMinute(37);
			time.advance(0,2);
			System.out.println( time.compareTo(time2));
			System.out.println( time.toString());
			System.out.println( time2.toString());
			time.setHour(0);
			time.setMinute(5);
			System.out.println( time.toString());
		}
    	catch (Exception e){
			System.out.println(e.toString());
		}


    }
}
