package com.Group1;
/**
 * This class is to manage the system according to user's choice.
 */
public class ManageSystem {
    public void startSystem(){
        //create necessary object
        DataBase data = new DataBase ();
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile (data);
        readAndWriteFile.fill ();
        data.openFlag ();
        ManageAdministrator manageAdministrator = new ManageAdministrator(data);
        ManageGovernor manageGovernor = new ManageGovernor (data);
        ManageDoctor manageDoctor = new ManageDoctor (data);
        ManageCook manageCook = new ManageCook (data);
        ManageJailer manageJailer = new ManageJailer (data);
        ManageChiefJailer manageChiefJailer = new ManageChiefJailer (data);
        Validate validator = new Validate(data);
        int choice,id;
        do{
            mainMenu ();
            choice = GetChoiceFromUser.getSubChoice(2,"Answer: ");
            if (choice==1){
                Personnel personnel = validator.validatePersonnel ();
                if (personnel!=null){
                    if (personnel.job==JobType.Administrator)
                        manageAdministrator.manage (personnel);
                    else if (personnel.job==JobType.Governor)
                        manageGovernor.manage (personnel);
                    else if (personnel.job==JobType.Doctor)
                        manageDoctor.manage (personnel);
                    else if (personnel.job==JobType.Cook)
                        manageCook.manage (personnel);
                    else if (personnel.job==JobType.ChiefJailer)
                        manageChiefJailer.manage (personnel);
                    else if (personnel.job==JobType.Jailer)
                        manageJailer.manage (personnel);
                }
                else
                    System.out.println("Your ID or Password Wrong!");
            }
            else if (choice == 2){
                int k;
                for ( k = 0; k < 45; k++) System.out.print("-");
                System.out.print("\n");
                System.out.println ("\t***Prison Current Status***");
                if (data.getAlert ())
                    System.out.println ("Alert of State: Yes ");
                else
                    System.out.println ("Alert of State: No ");
                if (data.toDoSize ()==0)
                    System.out.println ("No ToDo! ");
                else{
                    Personnel p = data.getPersonnel (data.getToDoFromTop ().getOwnerID ());
                    System.out.println ("First ToDo Owner: "+
                            p.name+" "+p.surname);
                }
                for ( k = 0; k < 45; k++) System.out.print("-");
                System.out.print("\n");
                System.out.println ("\t***Prison Structure***");
                data.printPrison ();
            }

        }while (choice!=0);
    }
    private void mainMenu(){
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.print("Welcome to Prison Management System\n");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Login.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Check Prison Status.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Exit.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");

    }
}
