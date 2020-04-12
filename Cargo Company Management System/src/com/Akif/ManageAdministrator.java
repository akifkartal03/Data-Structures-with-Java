package com.Akif;
/**
 * This class makes operations belongs to administrator.
 * We take operations to this class to write reusable code.
 * */
public class ManageAdministrator {
    /**
     * This field will be used when we make operations.
     * */
    private Data data; //we will use it when we make operations
    /**
     * This field will be used when we print the data
     * */
    PrintData printData; //we will use this when we make operations
    /**
     * SubChoice of the user.
     * */
    int subChoice;
    /**
     * Two parameter constructor.
     * This class needs to Data object and Print Data object to make operations.
     * @param data all data regarding the system
     * @param printData it prints the data to the screen.
     * */
    public ManageAdministrator(Data data,PrintData printData){
        this.data = data;
        this.printData = printData;
    }
    /**
     * This method manages the administrator
     * First it gets a choice from user and it makes that operation
     * @param adminID adminID of Administrator that will be manage the system.
     * */
    public void manage(int adminID){
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(8,new MenuForAdministrator(data.getAdmin(adminID).getFirstName()));
            if (choice==1) {
                addBranch();
            } else if (choice == 2){
                removeBranch();
            }
            else if(choice == 3){
                addBranchEmployee();
            }
            else if(choice == 4){
                removeBranchEmployee();
            }
            else if(choice == 5){
                addTransportationPersonnel();
            }
            else if (choice == 6){
                removeTransportationPersonnel();
            }
            else if (choice == 7){
                addAdmin();
            }
            else if(choice == 8){
                printData.printAllData();
            }

        }while (choice!=0);
    }
    /**
     * This method adds a new Branch to the System.
     * It uses data class to add new branch.
     * */
    public void addBranch(){
        Branch branch = new Branch();
        branch.setName(checkAndGetBranchName());
        branch.setBranchID(data.numberOfBranch());
        data.addBranch(branch);
        System.out.println("Your Branch has added Successfully!");
    }
    /**
     * This method removes a Branch from the System.
     * It uses data class to remove branch.
     * */
    public void removeBranch(){
        String message = "Choose one of the branch to remove";
        if (printData.checkAndPrintBranch(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfBranch());
            if (subChoice!=0){
                data.removeBranch(data.getBranch(subChoice-1));
                System.out.println("Your Branch has removed Successfully!");
            }
        }
    }
    /**
     * This method adds a new Branch Employee to the System.
     * It uses data class to add new branch employee.
     * */
    public void addBranchEmployee(){
        String message = "Choose one of the branch to add branch employee in that Branch.";
        if (printData.checkAndPrintBranch(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfBranch());
            if (subChoice!=0){
                BranchEmployee branchEmployee = new BranchEmployee();
                branchEmployee.setBranchID(subChoice-1);
                branchEmployee.setFirstName(GetChoiceFromUser.getStringFromUser("Enter a First Name: "));
                branchEmployee.setLastName(GetChoiceFromUser.getStringFromUser("Enter a Last Name: "));
                branchEmployee.setId(GetChoiceFromUser.getIDFromUser(data));
                branchEmployee.setPassword(GetChoiceFromUser.getStringFromUser("Enter a password: "));
                branchEmployee.setRecordID(data.numberOfBranchEmployee());
                data.addBranchEmployee(branchEmployee,data.getBranch(subChoice-1));
                System.out.println("Your Branch employee has added Successfully !");
            }
        }
        else
            System.out.println("In order to add a branch employee Please add a branch!");
    }
    /**
     * This method removes a Branch employee from the System.
     * It uses data class to remove branch employee.
     * */
    public void removeBranchEmployee(){
        String message = "Choose one of the branch employee to remove";
        if (printData.checkAndPrintBranchEmployee(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfBranchEmployee());
            if (subChoice!=0){
                data.removeBranchEmployee(data.getBranchEmployee(subChoice-1),data.getBranch(data.getBranchEmployee(subChoice-1).getBranchID()));
                System.out.println("Your Branch employee has removed Successfully!");
            }
        }
    }
    /**
     * This method adds a new Transportation Personnel to the System.
     * It uses data class to add new Transportation Personnel.
     * */
    public void addTransportationPersonnel(){
        String message = "Choose one of the branch to add transportation personnel in that Branch.";
        if (printData.checkAndPrintBranch(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfBranch());
            if (subChoice!=0){
                TransportationPersonnel transportationPersonnel = new TransportationPersonnel();
                transportationPersonnel.setBranchID(subChoice-1);
                transportationPersonnel.setFirstName(GetChoiceFromUser.getStringFromUser("Enter a First Name: "));
                transportationPersonnel.setLastName(GetChoiceFromUser.getStringFromUser("Enter a Last Name: "));
                transportationPersonnel.setId(GetChoiceFromUser.getIDFromUser(data));
                transportationPersonnel.setPassword(GetChoiceFromUser.getStringFromUser("Enter a Password: "));
                transportationPersonnel.setRecordID(data.numberOfTransportationPersonnel());
                data.addTransportationPersonnel(transportationPersonnel,data.getBranch(subChoice-1));
                System.out.println("Your Transportation Personnel has added Successfully!");
            }
        }
        else
            System.out.println("In order to add a  transportation personnel Please add a branch!");
    }
    /**
     * This method removes a Transportation Personnel from the System.
     * It uses data class to remove Transportation Personnel.
     * */
    public void removeTransportationPersonnel(){
        String message = "Choose one of the transportation personal to remove";
        if (printData.checkAndPrintTransportationPersonnel(message)){
            subChoice = GetChoiceFromUser.getSubChoice(data.numberOfTransportationPersonnel());
            if (subChoice!=0){
                data.removeTransportationPersonnel(data.getTransportationPersonnel(subChoice-1),data.getBranch(data.getTransportationPersonnel(subChoice-1).getBranchID()));
                System.out.println("Your Transportation Personnel has removed Successfully!");
            }
        }
    }
    /**
     * This method adds a new Administrator to the System.
     * It uses data class to add new Administrator.
     * */
    public void addAdmin(){
        Administrator administrator = new Administrator();
        administrator.setFirstName(GetChoiceFromUser.getStringFromUser("Enter a First Name: "));
        administrator.setLastName(GetChoiceFromUser.getStringFromUser("Enter a Last Name: "));
        administrator.setId(GetChoiceFromUser.getIDFromUser(data));
        administrator.setPassword(GetChoiceFromUser.getStringFromUser("Enter a password: "));
        administrator.setRecordID(data.numberOfAdmin());
        data.addAdmin(administrator);
        System.out.println("Your Administrator has added Successfully!");
    }
    /**
     * This method gets an unique branch name from user .
     * @return Return a Branch Name
     * */
    private String checkAndGetBranchName(){
        boolean is_in;
        String name;
        do {
            name = GetChoiceFromUser.getStringFromUser("Enter Branch Name: ");
            is_in=false;
            for (int i = 0 ; i<data.numberOfBranch();i++){
                if (data.getBranch(i).getName().equals(name)){
                    is_in = true;
                }
            }
            if (is_in)
                System.out.println("This name has already used!");
        }while(is_in);
        return name;
    }

}
