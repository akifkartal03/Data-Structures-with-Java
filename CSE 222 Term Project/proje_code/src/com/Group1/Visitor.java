package com.Group1;
import java.util.*;
import java.util.Scanner;

/**
 * This class holds the visitor information
 */
public class Visitor implements Comparable<Visitor>{
	/**Data fields*/
	protected String name;
	protected String surname;
	/*TCNumber yerine tcNumber yazıldı database classında 
	visitor.TCNumber yerine tcNumber yazılmalı*/
	protected String tcNumber;
	protected int inmateNumber;
	protected String telephoneNumber;
	protected String date;
	protected String entranceTime;
	protected String exitTime;


	/**Constructor eight parameters, includes name,surname,tcnumber,
	inmate number, telephone number, date, entrance time and exit time.
	*/
	public Visitor(String name,String surname,String tcNumber,int inmateNumber,String telephoneNumber,String date,String entranceTime){
		this.name = name;
		this.surname = surname;
		this.tcNumber = tcNumber;
		this.inmateNumber = inmateNumber;
		this.telephoneNumber = telephoneNumber;
		this.date = date;
		this.entranceTime = entranceTime;
		this.exitTime = "Not assigned";
	}
	/**Get visitor's name*/
	public String getName(){
		return name;
	}
	/**Get visitor's surname*/
	public String getSurname(){
		return surname;
	}
	/**Get visitor's TCNumber*/
	public String getTCNumber(){
		return tcNumber;
	}
	/**Get visitor's InmateNumber*/
	public int getInmateNumber(){
		return inmateNumber;
	}
	/**Get visitor's TelephoneNumber*/
	public String getTelephoneNumber(){
		return telephoneNumber;
	}
	/**Get visitor's Date*/
	public String getDate(){
		return date;
	}
	/**Get visitor's EntranceTime*/
	public String getEntranceTime(){
		return entranceTime;
	}
	/**Get visitor's ExitTime*/
	public String exitTime(){
		return exitTime;
	}
	/**Set visitor's name
	*@param name Visitor name
	*/
	public void setName(String name){
		this.name = name;
	}
	/**Set visitor's surname
	*@param surname Visitor surname
	*/
	public void setSurname(String surname){
		this.surname = surname;
	}
	/**Set visitor's TCNumber
	*@param tcNumber Visitor TCNumber
	*/
	public void setTCNumber(String tcNumber){
		this.tcNumber = tcNumber;
	}
	/**Set visitor's inmate number
	*@param inmateNumber Visitor inmateNumber
	*/
	public void setInmateNumber(int inmateNumber){
		this.inmateNumber = inmateNumber;
	}
	/**Set visitor's telephone number
	*@param telephoneNumber Visitor telephoneNumber
	*/
	public void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}
	/**Set visitor's date
	*@param date Visitor date
	*/
	public void setDate(String date){
		this.date = date;
	}
	/**Set visitor's entranceTime
	*@param entranceTime Visitor entranceTime
	*/
	public void setEntranceTime(String entranceTime){
		this.entranceTime = entranceTime;
	}
	/**Set visitor's entranceTime
	*@param exitTime Visitor entranceTime
	*/
	public void setExitTime(String exitTime){
		this.exitTime = exitTime;
	}
	@Override
	public int compareTo (Visitor o) {
		return this.tcNumber.compareTo (o.tcNumber);
	}
	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass () != o.getClass ()) return false;
		Visitor visitor = (Visitor) o;
		return inmateNumber == visitor.inmateNumber &&
				name.equals (visitor.name) &&
				surname.equals (visitor.surname) &&
				tcNumber.equals (visitor.tcNumber) &&
				telephoneNumber.equals (visitor.telephoneNumber) &&
				date.equals (visitor.date) &&
				entranceTime.equals (visitor.entranceTime) &&
				exitTime.equals (visitor.exitTime);
	}

	@Override
	public String toString () {
		return "Visitor{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", tcNumber='" + tcNumber + '\'' +
				", inmateNumber=" + inmateNumber +
				", telephoneNumber='" + telephoneNumber + '\'' +
				", date='" + date + '\'' +
				", entranceTime='" + entranceTime + '\'' +
				", exitTime='" + exitTime + '\'' +
				'}';
	}
}
