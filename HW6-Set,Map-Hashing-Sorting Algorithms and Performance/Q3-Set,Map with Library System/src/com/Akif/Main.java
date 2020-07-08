package com.Akif;
/**
 * Main Class is to test the program.
 * */
public class Main {
	/**
	 * main method of the program.
	 * @param args Not used.
	 */
    public static void main(String[] args) {
        //create necessary object
	    Data data = new Data();
		ManageAdministrator manageAdministrator = new ManageAdministrator(data);
		ManageSearch manageSearch = new ManageSearch (data);
		Validate validator = new Validate(data);
		data.addAdmin(createDefaultAdmin());
		TestDriver.fill (data); //fill books from file.
		int choice,id;
		do {
			choice = GetChoiceFromUser.getSubChoice(2,new MainMenu());
			if (choice==1){
				id = validator.validateAdmin();
				if (id!=-1)
					manageAdministrator.manage(id);
				else
					System.out.println("Your ID or Password Wrong!");
			}
			else if (choice == 2){
				manageSearch.startSearch ();
			}
		}while (choice!=0);

    }
    /**
     * Create a default admin to test the system.
     * @return administrator which was created
     * */
    public static Administrator createDefaultAdmin(){
    	Administrator administrator = new Administrator();
    	administrator.setFullName ("Default");
    	administrator.setId(1);
    	administrator.setPassword("171044098");
    	return administrator;
	}

}
