package com.Akif;

/**
 * This is the system class of the system to manage the system.
 */
public class SoftwareStoreSystem {
    /**
     * All data of the system
     */
    private Data data;
    /**
     * Administrator operations.
     */
    private ManageAdministrator manageAdministrator;
    /**
     * Search operations
     */
    private ManageSearch manageSearch;
    /**
     * Validate object
     */
    private Validate validator;

    /**
     * One parameter constructor.
     * This class needs to Data Structure to make operations.
     * @param dataStructure a data structure that implements the SearchInterface.
     * */
    public SoftwareStoreSystem(SearchTree<Software> dataStructure){
        data = new Data(dataStructure);
        manageAdministrator = new ManageAdministrator(data);
        manageSearch = new ManageSearch (data);
        validator = new Validate(data);
    }

    /**
     * Start System.
     */
    public void startSystem(){
        data.addAdmin(createDefaultAdmin());
        TestDriver.fill (data);
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
    private static Administrator createDefaultAdmin(){
        Administrator administrator = new Administrator();
        administrator.setFullName ("Default");
        administrator.setId(1);
        administrator.setPassword("171044098");
        return administrator;
    }
}
