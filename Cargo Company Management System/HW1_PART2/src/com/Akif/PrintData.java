package com.Akif;
/**
 * This class prints the data on screen by using data array.
 * */
public class PrintData {
    /**
     * This will be used when we print the data.
     * */
    Data data;
    /**
     * One parameter constructor.
     * This class needs to Data object to print data
     * @param data all data regarding the system
     * */
    public PrintData(Data data){
        this.data = data;
    }
    /**
     * This method first checks admin array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintAdmin(String message){
        if (data.numberOfAdmin()==0){
            System.out.println("There is no any Administrator!");
            return false;
        }
        else{
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfAdmin(); i++){
                System.out.printf("[%d] %s",i+1,data.getAdmin(i).toString());
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method first checks Branch array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintBranch(String message){
        if (data.numberOfBranch() == 0){
            System.out.println("There is no any Branch!");
            return  false;
        }
        else {
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfBranch(); i++){
                System.out.printf("[%d] %s",i+1,data.getBranch(i).toString());
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method first checks Branch Employee array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintBranchEmployee(String message){
        if (data.numberOfBranchEmployee() == 0){
            System.out.println("There is no any Branch Employee!");
            return false;
        }
        else{
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfBranchEmployee(); i++){
                System.out.printf("[%d] %s",i+1,data.getBranchEmployee(i).toString());
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method first checks Transportation Personnel array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintTransportationPersonnel(String message){
        if (data.numberOfTransportationPersonnel() == 0){
            System.out.println("There is no any Transportation Personnel!");
            return false;
        }
        else{
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfTransportationPersonnel(); i++){
                System.out.printf("[%d] %s",i+1,data.getTransportationPersonnel(i).toString());
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method first checks Customer array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintCustomer(String message){
        if (data.numberOfCustomer() == 0){
            System.out.println("There is no any Customer!");
            return false;
        }
        else{
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfCustomer(); i++){
                System.out.printf("[%d] %s",i+1,data.getCustomer(i).toString());
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method first checks Shipment array.
     * If it contains element it prints it.
     * @param message Message that will be given before print.
     * @return Return true if there is a element otherwise return false.
     * */
    public boolean checkAndPrintShipment(String message,int id){
        int k=0;
        if (data.getBranch(id).numberOfShipment() == 0){
            System.out.println("There is no any Shipment in your Branch!");
            return false;
        }
        else{
            System.out.println(message);
            for (int i = 0 ; i < data.numberOfShipment(); i++){
                if (data.getShipment(i).getBranchID() == id){
                    k++;
                    System.out.printf("[%d] %s",k,data.getShipment(i).toString());
                    System.out.printf("\t - Branch Name: %s\n",data.getBranch(data.getShipment(i).getBranchID()).getName());
                }
            }
            printExitChoice();
            return true;
        }
    }
    /**
     * This method prints extra choices for user.
     * */
    private void printExitChoice(){
        System.out.println("[0] Return Back");
        System.out.print( "Answer: ");
    }
    /**
     * This method prints All data in the System.
     * */
    public void printAllData(){
        int k,i;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Administrators***");
        for ( i = 0 ; i < data.numberOfAdmin(); i++){
            System.out.printf("%d) %s",i+1,data.getAdmin(i).toString());
        }
        if (i==0)
            System.out.println("\t - No Administrators");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Branches***");
        for ( i = 0 ; i < data.numberOfBranch(); i++){
            System.out.printf("%d) %s",i+1,data.getBranch(i).toString());
        }
        if (i==0)
            System.out.println("\t - No Branches");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Branch Employees***");
        for (i = 0 ; i < data.numberOfBranchEmployee(); i++){
            System.out.printf("%d) %s",i+1,data.getBranchEmployee(i).toString());
            System.out.printf("\t - Branch Name: %s\n",data.getBranch(data.getBranchEmployee(i).getBranchID()).getName());
        }
        if (i==0)
            System.out.println("\t - No Branch Employees");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Transportation Personnel***");
        for (i = 0 ; i < data.numberOfTransportationPersonnel(); i++){
            System.out.printf("%d) %s",i+1,data.getTransportationPersonnel(i).toString());
            System.out.printf("\t - Branch Name: %s\n",data.getBranch(data.getTransportationPersonnel(i).getBranchID()).getName());
        }
        if (i==0)
            System.out.println("\t - No Transportation Personnel");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Customers***");
        for ( i = 0 ; i < data.numberOfCustomer(); i++){
            System.out.printf("%d) %s",i+1,data.getCustomer(i).toString());
        }
        if (i==0)
            System.out.println("\t - No Customers");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
        System.out.print("   ");
        System.out.println("***Shipments***");
        for (i = 0 ; i < data.numberOfShipment(); i++){
            System.out.printf("%d) %s",i+1,data.getShipment(i).toString());
            System.out.printf("\t - Branch Name: %s\n",data.getBranch(data.getShipment(i).getBranchID()).getName());
        }
        if (i==0)
            System.out.println("\t - No Shipments");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.println("");
    }

}
