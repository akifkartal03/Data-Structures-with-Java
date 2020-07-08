package com.Group1;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is to make Administrator operations in the system.
 */
public class ManageAdministrator {
	/**
	 * This field will be used when we make operations.
	 * */
	private DataBase db; //we will use it when we make operations
	/**
	 * One parameter constructor.
	 * This class needs to Data object and Print Data object to make operations.
	 * @param data all data regarding the system
	 * */
	public ManageAdministrator(DataBase data){
		this.db = data;
	}
	public void manage(Personnel administrator){
		int choose;
		do {
			showMenu (administrator);
			choose = GetChoiceFromUser.getSubChoice (5,"Answer: ");
			switch(choose) {
				case 1:
					addGovernor ();
					break;
				case 2:
					removeGovernor ();
					break;
				case 3:
					appointGovernor ();
					break;
				case 4:
					db.printLastMenu ();
					break;
				case 5:
					checkMyTodo (administrator);
					break;
				default:
					break;
			}

		}while (choose != 0);
	}

	private void addGovernor () {
		int id = GetChoiceFromUser.getIDFromUser (db);
		String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
		String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
		String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
		HealthStatus healthStatus= GovernorInterfaceInfo.getHealthInfo ();
		PersonnelShift personnelShift= GovernorInterfaceInfo.getShiftInfo ();
		WorkPlace workPlace = GovernorInterfaceInfo.place ();
		Personnel p = new Personnel (id,name,surname,password,JobType.Governor,
				healthStatus,personnelShift,workPlace);
		if (db.addPersonnel(p))
			System.out.println ("Governor was Added.");
		else
			System.out.println ("Governor was not Added!");
	}

	private void removeGovernor () {
		int id = GetChoiceFromUser.getNumber ("Enter ID to remove: ");
		Personnel p = db.getPersonnel(id);
		if (p!=null){
			db.deletePersonnel(p);
			System.out.println ("Governor was removed!");
		}
		else
			System.out.println ("Governor was not found!");
	}

	/*
		Appoint a new governor.
		There must be a governor every time
		so administrator cannot add or remove
		governor directly (Also there must be
		one governor at the same time).
		Other information about the governor
		can be found in the database using id.
	*/
	private void appointGovernor () {
		int oldid = GetChoiceFromUser.getNumber ("Enter current Governor ID to change: ");
		Personnel p = db.getPersonnel(oldid);
		if (p!=null){
			db.deletePersonnel(p);
			System.out.println ("Enter Information of new Governor");
			addGovernor ();
		}
		else
			System.out.println ("Governor was not found!");
	}
	private void showMenu(Personnel admin){
		int k;
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("Welcome Administrator "+admin.name+" "+admin.surname);
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n");
		System.out.println("What do you want to do? ");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[1] Add a Governor");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[2] Delete a Governor");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[3] Appoint a new Governor");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[4] See Last Menu of Prison");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[5] Check My Todo");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[0] Exit.");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n");
	}
	private void checkMyTodo(Personnel admin){
		if (db.checkTodo (admin.id)){
			System.out.println ("You have first todo!");
			System.out.println ("Job: "+db.getToDoFromTop ().getJob ());
			String ans = GetChoiceFromUser.getStringFromUser ("Did you do that(yes/no): ");
			if (ans.equalsIgnoreCase ("yes"))
				db.deleteToDoFromTop ();
		}
	}
}