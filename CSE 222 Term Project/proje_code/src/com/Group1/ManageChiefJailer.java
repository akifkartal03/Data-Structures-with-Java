package com.Group1;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
/**
 * This class is to make Chief Jailer operations in the system.
 */
public class ManageChiefJailer extends ManageJailer {

    public ManageChiefJailer(DataBase dataBase) {
        super(dataBase);
    }


    public void showMenu(Personnel chiefJailer) {
        int k;
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("Welcome Chief Jailer " +chiefJailer.name +" " + chiefJailer.surname);
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("What Do you want to do ?");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
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
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[6] Add a visitor");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[7] Remove a visitor");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[8] Enter exit time of a visitor");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[9] Print all visitors.");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[10] Get a prisoner");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[11] Get shift our");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[12] Get department");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[13] Set shift our.");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[14] Set department");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");

    }

    public void manage(Personnel chiefJailer) {

        try{
            int choose;
            do {
                showMenu(chiefJailer);
                choose = GetChoiceFromUser.getSubChoice(14, "Answer: ");

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
                        addVisitor();
                        break;

                    case 7:
                        removeVisitor();
                        break;
                    case 8:
                        enterExitTime();
                        break;
                    case 9:
                        dataBase.printAllVisitor();
                        break;

                    case 10:
                        getPrison();
                        break;

                    case 11:
                        getShiftOur();
                        break;

                    case 12:
                        getDepartment();
                        break;
                    case 13:
                        setJailerSH();
                        break;
                    case 14:
                        setJailerDP();
                        break;
                    default:
                        break;
                }
            } while (choose != 0);
        } catch (Exception a){
            System.out.println(a.toString());
        }
    }
    
    public void enterExitTime(){
        int k;
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter visitor TC: ");
        String visitorTc = scan.nextLine();
        Visitor visitor = dataBase.getVisitorWithTC (visitorTc);
        if (visitor != null){
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter exit time: ");
            String exitTime = scan.nextLine();
            visitor.exitTime = exitTime;
        }
        else{
            System.out.println ("Visitor was not found!");
            throw new NoSuchElementException("No Visitor found in given TC!");
        }
        dataBase.printAllVisitor();

    }

    public void setJailerSH(){
        Scanner scan = new Scanner(System.in);
        int k;
        String shiftTimes = "";
        ArrayList<Days> newShiftdays = new ArrayList<>();
        System.out.println("Enter the ID of the jailer:");
        int jailerID = scan.nextInt();

        if(dataBase.getPersonnel(jailerID) == null)
            throw new NoSuchElementException("There is no Jailer with given id!");

        do {
            System.out.println("Enter the new working days:");
            shiftTimes = scan.nextLine();

            switch (shiftTimes) {
                case "Monday":
                    newShiftdays.add(Days.Monday);
                    break;
                case "Tuesday":
                    newShiftdays.add(Days.Tuesday);
                    break;
                case "Wednesday":
                    newShiftdays.add(Days.Wednesday);
                    break;
                case "Thursday":
                    newShiftdays.add(Days.Thursday);
                    break;
                case "Friday":
                    newShiftdays.add(Days.Friday);
                    break;
                case "Saturday":
                    newShiftdays.add(Days.Saturday);
                    break;
                case "Sunday":
                    newShiftdays.add(Days.Sunday);
                    break;
                default:
                    System.out.println("Not a valid day! Enter again!");
            }

        } while (!(shiftTimes.equals("-")));

        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("Choose a shift time:");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[1] Daytime - 08.00 - 16.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[2] Evening - 16.00 - 00.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[3] Night - 00.00 - 08.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        Shifts shift = Shifts.daytime;
        int choose;
        do {
            choose = scan.nextInt();

            switch (choose) {
                case 1:
                    shift = Shifts.daytime;
                    break;
                case 2:
                    shift = Shifts.evening;
                    break;
                case 3:
                    shift = Shifts.night;
                    break;
            }
        } while (!(choose == 1 || choose == 2 || choose == 3));

        dataBase.getPersonnel(jailerID).setShift(new PersonnelShift(shift, newShiftdays));
    }

    public void setJailerDP(){
        Scanner scan = new Scanner(System.in);
        int k;
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.println();
        System.out.println("Enter the Jailer's id: ");
        int jailerId = scan.nextInt();

        if (dataBase.getPersonnel(jailerId) == null)
            throw new NoSuchElementException("No Jailer found in given ID!");

        System.out.println("Enter new workplace's block(A/B1/B2): ");
        String blockName = scan.nextLine();
        blockName = scan.nextLine();

        System.out.println("Enter new workplace's floor(0/1): ");
        int floor = scan.nextInt();
        dataBase.getPersonnel(jailerId).setPlace(new WorkPlace(blockName, floor));
    }


    public void addVisitor(){
        int k;
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter inmate id: ");
        int inmateNumber = scan.nextInt();
        Inmate inmate = dataBase.getInmate (inmateNumber);
        if (inmate != null){
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter name: ");
            String name = scan.nextLine();
            name = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter surname: ");
            String surname = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter TC number: ");
            String tc = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter telephone number of visitor: ");
            String telephone = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter date: ");
            String date = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            System.out.println("Enter enterance time: ");
            String time = scan.nextLine();
            for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            dataBase.addOneVisitor (inmate,new Visitor (name,surname,tc,inmateNumber,telephone,date,time));
        }
        else{
            System.out.println ("Inmate was not found!");
            throw new NoSuchElementException("No Inmate found in given ID!");
        }

        dataBase.printAllVisitor();

    }
    
       public void removeVisitor(){
        int k;
        Scanner scan = new Scanner(System.in);
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter Visitor's TC number: ");
        String tc = scan.nextLine();
        if (dataBase.getVisitorWithTC(tc) == null)
            throw new NoSuchElementException("No Visitor found in given TC!");

        removeVisitor(tc,dataBase);
        dataBase.printAllVisitor();
    }

    protected void removeVisitor(String tc,DataBase dataBase)
    {
        if (dataBase.getVisitorWithTC(tc) == null)
            throw new NoSuchElementException("No Visitor found in given TC!");
        dataBase.deleteVisitor(new Inmate(dataBase.getVisitorWithTC(tc).inmateNumber) ,dataBase.getVisitorWithTC(tc));
    }  

}

