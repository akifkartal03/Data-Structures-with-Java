package com.Group1;
/**
 * This class is to make Governor operations in the system.
 */
public class ManageGovernor {
    /**
     * This field will be used when we make operations.
     * */
    private DataBase database; //we will use it when we make operations

    /**
     * One parameter constructor.
     * This class needs to Data object and Print Data object to make operations.
     * @param data all data regarding the system
     * */
    public ManageGovernor(DataBase data){
        this.database = data;
    }
    /**
     * This method manages the governor
     * First it gets a choice from user and it makes that operation
     * @param governor Governor that will be manage the system.
     * */
    public void manage(Personnel governor){
        int choose;
        do {
            showMenu (governor);
            choose = GetChoiceFromUser.getSubChoice (13,"Answer: ");
            switch(choose) {
                case 1:
                    addPersonnel ();
                    break;
                case 2:
                    removePersonnel ();
                    break;
                case 3:
                    updatePersonnel ();
                    break;
                case 4:
                    addInmate();
                    break;
                case 5:
                    removeInmate ();
                    break;
                case 6:
                    updateInmate ();
                    break;
                case 7:
                    addToDo ();
                    break;
                case 8:
                    removeToDo ();
                    break;
                case 9:
                    addUrgentTodo ();
                    break;
                case 10:
                    database.printLastMenu ();
                    break;
                case 11:
                	database.printAllPersonnel();
                	break;
                case 12: 
                	database.printAllPrisoners();
                	break;
                case 13: 
                	database.printAllActiveToDos();
                	database.printAllPassiveToDo();
                	break;
                default:
                    break;
            }

        }while (choose != 0);
    }
    private void showMenu(Personnel governor){
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Governor "+governor.name+" "+governor.surname);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.println("What do you want to do? ");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[1] Add a Personnel");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[2] Delete a Personnel");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[3] Update a Personnel");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[4] Add an Inmate");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[5] Remove an Inmate");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
        System.out.println("[6] Update an Inmate");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[7] Add a daily to-do");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[8] Remove a daily to-do");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[9] Add Urgent Todo");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[10] Print Last Menu");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[11] Print All Personnels");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[12] Print All Inmates");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println(); 
        System.out.println("[13] Print All To-do's");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }
    private void addPersonnel(){
        int k,choose1;
        do {
            System.out.println("Please choose one: ");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("[1] Add a Jailer");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("[2] Add a ChiefJailer");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("[3] Add a Cook");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("[4] Add a Doctor");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("[0] Return Back ");
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            choose1 = GetChoiceFromUser.getSubChoice (4,"Answer: ");
            if(choose1 == 1) {
                database.addPersonnel(GovernorInterfaceInfo.addJailerInfo(database));
                System.out.println("Personnel was added!");
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(choose1 == 2) {
                database.addPersonnel(GovernorInterfaceInfo.addChiefJailerInfo(database));
                System.out.println("Personnel was added!");
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(choose1 == 3) {
                database.addPersonnel(GovernorInterfaceInfo.addCookInfo(database));
                System.out.println("Personnel was added!");
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(choose1 == 4) {
                database.addPersonnel(GovernorInterfaceInfo.addDoctorInfo(database));
                System.out.println("Personnel was added!");
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }

        } while(choose1 != 0);
    }
    private void removePersonnel(){
        Personnel temp;
        int id;
        do {
            id = GetChoiceFromUser.getNumber ("Enter ID of Personnel to exit enter -1: ");
            if (id == -1)
                break;
            temp = database.getPersonnel (id);
            if (temp==null)
                System.out.println ("Personnel was not found!");
        }while (temp==null);
        if (id!=-1)
            database.deletePersonnel (database.getPersonnel (id));
            System.out.println("Personnel was removed!");
    }
    private void updatePersonnel(){
        int k;
        Personnel temp=null;
        int id;
        do {
            id = GetChoiceFromUser.getNumber ("Enter ID of Personnel to exit enter -1: ");
            if (id == -1)
                break;
            temp = database.getPersonnel (id);
            if (temp==null)
                System.out.println ("Personnel was not found!");
        }while (temp==null);
        if (id!=-1){
            JobType Job = temp.job;
            System.out.println("Enter the information of the personnel to be updated!");
            if(Job.equals(JobType.Jailer)) {
                Personnel jailer = GovernorInterfaceInfo.addJailerInfo(database);
                database.updatePersonnel(temp, jailer);
                System.out.println("Personnel was updated!");
    	        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(Job.equals(JobType.ChiefJailer)) {
                Personnel chiefjailer = GovernorInterfaceInfo.addChiefJailerInfo(database);
                database.updatePersonnel(temp, chiefjailer);
                System.out.println("Personnel was updated!");
    	        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(Job.equals(JobType.Doctor)) {
                Personnel doctor1 = GovernorInterfaceInfo.addDoctorInfo(database);
                database.updatePersonnel(temp, doctor1);
                System.out.println("Personnel was updated!");
    	        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
            else if(Job.equals(JobType.Cook)) {
                Personnel cook1 = GovernorInterfaceInfo.addCookInfo(database);
                database.updatePersonnel(temp, cook1);
                System.out.println("Personnel was updated!");
    	        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            }
        }

    }
    private void addInmate(){
        if(database.addInmate( GovernorInterfaceInfo.addInmateInfo(database))){
            System.out.println("This Inmate is successfully added to the system.");
        }
        else {
            System.out.println("This Inmate already added in System.");
        }
    }
    private void removeInmate()
    {
        Inmate inmate =null;
        int id;
        do {
            id = GetChoiceFromUser.getNumber ("Enter ID of Inmate to exit enter -1: ");
            if (id == -1)
                break;
            inmate = database.getInmate (id);
            if (inmate==null)
                System.out.println ("Inmate was not found!");
        }while (inmate==null);
        if (id!=-1){
            database.deleteInmate(inmate);
            System.out.println("This Inmate is successfully deleted from the system.");
        }
    }

    private void updateInmate() {
        Inmate oldInmate =null;
        int id;
        do {
            id = GetChoiceFromUser.getNumber ("Enter ID of Inmate to exit enter -1: ");
            if (id == -1)
                break;
            oldInmate = database.getInmate (id);
            if (oldInmate==null)
                System.out.println ("Inmate was not found!");
        }while (oldInmate==null);
        if (id!=-1){
            System.out.println("Enter the information of the personnel to be updated: ");
            Inmate newInmate = GovernorInterfaceInfo.addInmateInfo(database);
            if(database.updateInmate(oldInmate, newInmate)) {
                System.out.println("This inmate has been successfully updated.");
            }
            else {
                System.out.println("This inmate could not be updated. Please check the information.");
            }
        }
    }


    private void addToDo(){
        String job = GetChoiceFromUser.getStringFromUser ("Enter Job to add: ");
        int ID = GetChoiceFromUser.getNumber ("Enter personnel ID for ToDo: ");
        ToDo todo = new ToDo(job, ID);
        database.addToDoToTheTop (todo);
        System.out.println("This job has been added to the to-do. ");
    }
    private void removeToDo(){
        String job = GetChoiceFromUser.getStringFromUser ("Enter Job to remove: ");
       if (database.deleteTodo (job))
           System.out.println("This todo has been removed from todo list. ");
       else
           System.out.println("ToDo was not found Try Again! ");

    }
    private void addUrgentTodo(){
        String job = GetChoiceFromUser.getStringFromUser ("Enter Job to add: ");
        int ID = GetChoiceFromUser.getNumber ("Enter personnel ID for ToDo: ");
        ToDo todo = new ToDo(job, ID);
        database.addUrgentTodo (todo);
        System.out.println("This urgent todo has been added to the to-do. ");

    }

}
