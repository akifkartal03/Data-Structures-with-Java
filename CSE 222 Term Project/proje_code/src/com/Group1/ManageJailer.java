package com.Group1;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is to make Jailer operations in the system.
 */
public class ManageJailer {
	/**
	 * This field will be used when we make operations.
	 * */
	protected DataBase dataBase; //we will use it when we make operations

	public ManageJailer(DataBase data) { this.dataBase = data; }

	/**
	 *Get inmate information by id, id take from user
	 *If id is not avaliable,return null
	 */
	public void getLastCensus(){
		if (dataBase.getLastInmateCensus ()!=null)
			System.out.println (dataBase.getLastInmateCensus ());
		else
			System.out.println ("No Last Census");

	}
	public void addCensus(){
		int number = GetChoiceFromUser.getNumber ("Enter number of Inmate: ");
		if(number != dataBase.getInmateSize())
			dataBase.setAlert();
		dataBase.addInmateCensus (number, DateFormat.getInstance().format(new Date()));
		System.out.println ("Census info was Added with today's date.");
	}

	public void removeLastCensus(){
		dataBase.deleteLastCensus ();
	}
	/**
	 * Checks if the count of the prisoners checks with the system census information
	 * @param numberOfPrisoners counted prisoner number
	 * @return true if count checks with the system, false if otherwise
	 */
	public boolean checkCensus(int numberOfPrisoners, DataBase dataBase)
	{
        /*if(dataBase.prisoners.size() == numberOfPrisoners) return true;
        else return false;*/
		return false;
	}

	public void showMenu(Personnel jailer) {
		int k;
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("Welcome Jailer " + jailer.getName() + " " + jailer.getSurname());
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("What Do you want to do ?");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[0] Main Menu.");
		for (k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n" + "   ");
		System.out.println("[1] Check Last census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[2] Add new Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[3] Delete Last Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[4] Set Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[5] Undo Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[6] Get a prisoner");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[7] Get shift our");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[8] Get department");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[9] Add Health Appointment");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[10] Delete Health Appointment");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
	}

	public void manage(Personnel jailer) {

		try {
			int choose;
			do {
				showMenu(jailer);
				choose = GetChoiceFromUser.getSubChoice(10, "Answer: ");

				switch (choose) {
					case 1:
						getLastCensus();
						break;
					case 2:
						addCensus();
						break;
					case 3:
						removeLastCensus();
						break;
					case 4:
						dataBase.setAlert();
						break;
					case 5:
						dataBase.undoAlert();
						break;
					case 6:
						getPrison();
						break;
					case 7:
						getShiftOur();
						break;
					case 8:
						getDepartment();
						break;
					case 9:
						addHealthAppointment();
						break;
					case 10:
						deleteHealthAppointment();
						break;
					default:
						break;

				}
			} while (choose != 0);
		}catch (Exception a){
			System.out.println(a.toString());
		}
	}


	public void addHealthAppointment(){
		int k;
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter inmate id: ");
		int inmateNumber = scan.nextInt();
		Inmate inmate = dataBase.getInmate (inmateNumber);
		if (inmate != null){
			for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
			System.out.println("Appointment Id: ");
			int apId = scan.nextInt();
			for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
			System.out.println("Enter explanation: ");
			String exp = scan.nextLine();			
			exp = scan.nextLine();
			for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
			dataBase.addHealthAppointmentToTheTop (new HealthAppointment(apId,DateFormat.getInstance().format(new Date()),inmate.getId(),exp,inmate.getHealthStatus()));
			dataBase.printAllHealthAppointments();
		}
		else{
			System.out.println ("Inmate was not found!");
			throw new NoSuchElementException("No Inmate found in given ID!");
		}
	}

	public void deleteHealthAppointment(){
		dataBase.deleteHealthAppointmentFromTop();
		dataBase.printAllHealthAppointments();
	}


	public void getPrison(){
		int k;
		Scanner scan = new Scanner(System.in);
		for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
		System.out.println("Enter ID of the prison: ");
		int id = scan.nextInt();
		System.out.println(dataBase.getInmate(id).toString());
	}

	public void getShiftOur(){
		int k;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = scan.nextInt();
		if (dataBase.getPersonnel(id)==null)
			throw new NoSuchElementException("No matching jailer found!");

		System.out.println("Working Days:" );
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.println("\n");

		for (int i = 0; i < dataBase.getPersonnel(id).getShift().workdays.size(); i++) {
			System.out.println(dataBase.getPersonnel(id).getShift().workdays.get(i));
		}
		System.out.println("\nShift; " + dataBase.getPersonnel(id).getShift().shift.name());
	}


	public void getDepartment(){
		int k;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = scan.nextInt();
		if (dataBase.getPersonnel(id)==null)
			throw new NoSuchElementException("No matching jailer found!");

		System.out.println("Department:" );
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.println("\n");
		System.out.println(dataBase.getPersonnel(id).getPlace().toString());
	}


}


