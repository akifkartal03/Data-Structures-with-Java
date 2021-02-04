package com.Group1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This class gets information about personnel from the user.
 */
public class GovernorInterfaceInfo {
	public static Personnel addJailerInfo(DataBase dataBase) {
    	int id = GetChoiceFromUser.getIDFromUser (dataBase);
    	String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
    	String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,password,JobType.Jailer,healthStatus,personnelShift,workPlace);
    }
    public static HealthStatus getHealthInfo(){
        String bloodGroup = GetChoiceFromUser.getStringFromUser ("Enter blood Group: ");
        String lastControlResult = GetChoiceFromUser.getStringFromUser ("Enter Last Control Result: ");
        double height = GetChoiceFromUser.getDouble ("Enter Height: ");
        double weight = GetChoiceFromUser.getDouble ("Enter weight: ");
        double pulse = GetChoiceFromUser.getDouble ("Enter pulse: ");
        return new HealthStatus (bloodGroup,lastControlResult,height,weight,pulse);
    }
    public static PersonnelShift getShiftInfo(){
        String shift = GetChoiceFromUser.getStringFromUser ("Enter Shift Time(daytime,evening,night): ");
        ArrayList<Days> arrayList = new ArrayList<> ();
        do {
            System.out.println ("Enter shift days(Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday) to back enter exit ");
            String day =GetChoiceFromUser.getStringFromUser ("Day: ");
            if (day.equals ("exit"))
                break;
            arrayList.add (Days.valueOf (day));

        }while(true);
        return new PersonnelShift(Shifts.valueOf (shift),arrayList);
    }
    public static WorkPlace place(){
	    String blok = GetChoiceFromUser.getStringFromUser ("Enter block(A/B1/B2): ");
	    int floor = GetChoiceFromUser.getSubChoice (1,"Enter Floor(0,1): ");
	    return new WorkPlace (blok,floor);
    }
    public static Personnel addChiefJailerInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,password,JobType.ChiefJailer,healthStatus,personnelShift,workPlace);
    }
    
    public static Personnel addCookInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,password,JobType.Cook,healthStatus,personnelShift,workPlace);
    }
    
    public static Personnel addDoctorInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,password,JobType.Doctor,healthStatus,personnelShift,workPlace);
    }
    
    public static Inmate addInmateInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter full name of Inmate: ");
        String crime=GetChoiceFromUser.getStringFromUser ("Enter Crime Type of Inmate(FELONY,MISDEMEANOR,FELONY_MISDEMEANOR, INFRACTION): ");
        String date;
        boolean is_ok =true;
        do {
            is_ok =true;
            date =GetChoiceFromUser.getStringFromUser ("Enter Exit Date(dd/MM/yyyy): ");
            if (getDay (date)<=0){
                System.out.println ("Date is wrong enter again!");
                is_ok=false;
            }
        }while (!is_ok);
        int wn;
        do {
            is_ok =true;
            wn =GetChoiceFromUser.getNumber ("Enter ward No(0/1/2/3/4/5/6/7/8/9/10): ");
            if (wn<1 || wn>10){
                System.out.println ("No is wrong enter again!");
                is_ok=false;
            }
        }while (!is_ok);
        HealthStatus healthStatus= getHealthInfo ();
    	return  new Inmate (id,name,CrimeType.valueOf (crime),date,wn,healthStatus);
    }
    //calculate remaining date
    private static int getDay(String exitDate) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = myFormat.format(new Date ());
        try {
            Date date1 = myFormat.parse(exitDate);
            Date date2 = myFormat.parse(todayDate);
            long diff = date1.getTime() - date2.getTime();
            return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
