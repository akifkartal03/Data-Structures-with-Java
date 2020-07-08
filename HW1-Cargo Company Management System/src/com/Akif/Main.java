package com.Akif;
/**
 * Main Class is to execute the program.
 * */
public class Main {

    public static void main(String[] args) {
        //create necessary object
	    Data data = new Data();
	    PrintData printData = new PrintData(data);
		ManageAdministrator manageAdministrator = new ManageAdministrator(data,printData);
		ManageBranchEmployee manageBranchEmployee = new ManageBranchEmployee(data,printData);
		Validate validator = new Validate(data);
		data.addAdmin(createDefaultAdmin());
		int choice,id;
		do {
			choice = GetChoiceFromUser.getSubChoice(4,new MainMenu());
			if (choice==1){
				id = validator.validateAdmin();
				if (id!=-1)
					manageAdministrator.manage(id);
				else
					System.out.println("Your ID or Password Wrong!");
			}
			else if (choice == 2){
				id = validator.validateBranchEmployee();
				if (id!=-1)
					manageBranchEmployee.manage(id);
				else
					System.out.println("Your ID or Password Wrong!");
			}
			else if(choice == 3){
				id = validator.validateTransportationPersonnel();
				if (id!=-1)
					manageBranchEmployee.updateStatusOfShipment(data.getTransportationPersonnel(id).getFirstName(),data.getTransportationPersonnel(id).getBranchID());
				else
					System.out.println("Your ID or Password Wrong!");
			}
			else if (choice == 4){
				Customer.manageCustomer(data);
			}
		}while (choice!=0);

    }
    /**
     * Create a default admin to test the system.
     * @return Return Administrator which was created
     * */
    public static Administrator createDefaultAdmin(){
    	Administrator administrator = new Administrator();
    	administrator.setFirstName("Default");
    	administrator.setLastName("Default");
    	administrator.setId(171044098);
    	administrator.setPassword("akif123");
    	return administrator;
	}

}
