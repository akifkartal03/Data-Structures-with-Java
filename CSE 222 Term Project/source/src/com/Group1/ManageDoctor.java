package com.Group1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is to make Doctor operations in the system.
 */
public class ManageDoctor {
    /**
     * This field will be used when we make operations.
     * */
    private DataBase database; //we will use it when we make operations
    // it is for hold the patient in room. if doctor accept new patient
    // add to array list . if we do queue we cannt to reach patient when we
    // want heal it.
    private HealthAppointment current_ha = null;
    /**
     * One parameter constructor.
     * This class needs to Data object and Print Data object to make operations.
     * @param data all data regarding the system
     * */
    public ManageDoctor(DataBase data){
        this.database = data;
    }
    /**
     * This method manages the cook tasks
     * First it gets a choice from user and it makes that operation
     * @param doctor doctor that will be manage the system.
     * */
    public void manage( Personnel doctor){
        int choose;
        Scanner scan = new Scanner(System.in);
        do {
            showMenu (doctor);
            choose = GetChoiceFromUser.getSubChoice (4,"Answer: ");
            switch(choose) {
                case 1:
                    current_ha = database.deleteHealthAppointmentFromTop();
                    if (current_ha == null) {
                        System.out.println("No new health appointments");
                        choose = -1;//make it go back since there is no patients
                    }
                    if (choose!=-1)
                        healWithPatient (doctor);
                    break;
                case 2:
                    database.printLastMenu ();
                    break;
                case 3:
                    checkMyTodo (doctor);
                    break;
            }

        }while (choose != 0 );

    }
    private void healWithPatient(Personnel doctor){
        int choose;
        Scanner scan = new Scanner(System.in);
       do {
            showMenuPatient(doctor);
            choose = GetChoiceFromUser.getSubChoice (11,"Answer: ");
            switch (choose) {
                case 0:
                    System.out.println("Going back to main menu...");
                    break;
                case 1:
                    System.out.println("Inamte's blood group is: " + current_ha.getHealthStatus().getBloodGroup());
                    break;
                case 2:
                    System.out.println("Enter new blood group: ");
                    current_ha.getHealthStatus().setBloodGroup(scan.nextLine());
                    break;
                case 3:
                    System.out.println("Last control's results: ");
                    System.out.println(current_ha.getHealthStatus().getLastControlResult());
                    break;
                case 4:
                    System.out.println("Enter new control's result");
                    current_ha.getHealthStatus().setLastControlResult(scan.nextLine());
                    break;
                case 5:
                    System.out.println("Inamte's height: " + current_ha.getHealthStatus().getHeight());
                    break;
                case 6:
                    System.out.println("Enter new height(m)");
                    current_ha.getHealthStatus().setHeight(Double.parseDouble(scan.nextLine()));
                    break;
                case 7:
                    System.out.println("Inamte's weight is " + current_ha.getHealthStatus().getWeight() + "kg");
                    break;
                case 8:
                    System.out.println("Enter new weight: ");
                    current_ha.getHealthStatus().setWeight(Double.parseDouble(scan.nextLine()));
                    break;
                case 9:
                    System.out.println("Inmate's pulse is: " + current_ha.getHealthStatus().getPulse());
                    break;
                case 10:
                    System.out.println("Enter new pulse");
                    current_ha.getHealthStatus().setPulse(Double.parseDouble(scan.nextLine()));
                    break;

                case 11:
                    System.out.println("Going back to choosing next patient...");
                    break;
            }

        } while (choose != 0 && choose != 11);
    }

    private void showMenu(Personnel doctor){
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Doctor "+doctor.name+" "+doctor.surname);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Get next appointment");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Print Last Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Check My Todo");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }
    public void showMenuPatient(Personnel doctor) {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Doctor " + doctor.name +" "+ doctor.surname);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What do you want to do?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Get inmate's blood group");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Set inmate's blood group.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Check last control's result");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Set new control's result");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5] Get inmate's height");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[6] Set inmate's height");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[7] Get inmate's weight");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[8] Set inmate's weight");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[9] Get inmate's Pulse");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[10] Set inmate's Pulse");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+ "   ");
        System.out.println("[11] Get next patient");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }
    private void checkMyTodo(Personnel doctor){
        if (database.checkTodo (doctor.id)){
            System.out.println ("You have first todo!");
            System.out.println ("Job: "+database.getToDoFromTop ().getJob ());
            String ans = GetChoiceFromUser.getStringFromUser ("Did you do that(yes/no): ");
            if (ans.equalsIgnoreCase ("yes"))
                database.deleteToDoFromTop ();
        }
    }
}
