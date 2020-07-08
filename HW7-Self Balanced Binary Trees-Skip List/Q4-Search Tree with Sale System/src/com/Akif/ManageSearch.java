package com.Akif;

import java.util.*;

/**
 * This class is to manage search operations.
 */
public class ManageSearch {
    /**
     * This will be used when we search the data.
     * */
    Data data;
    /**
     * One parameter constructor.
     * This class needs to Data object to search data
     * @param data all data regarding the system
     * */
    public ManageSearch(Data data){
        this.data = data;
    }

    /**
     * This method starts the proper search operation.
     * First it gets a choice from user and it executes that search operation
     * */
    public void startSearch(){
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(2,new MenuToSearch ());
            if (choice==1) {
                searchByName ();
            }
            else if (choice == 2){
                data.printData ();
            }

        }while (choice!=0);
    }

    /**
     * Make search with given Software name. If Software is found,
     * Software properties will be printed.
     * By using only SearcTree interface methods just name search is possible.
     * While searching we can use find method of search tree and this method use compare to method
     * of the given data type so in this case only name search is possible.
     */
    public void searchByName(){
        String softwareName = GetChoiceFromUser.getStringFromUser ("Enter a Software name to search: ");
        if (data.contains (new Software (softwareName))){
            System.out.println (data.getSoftware (new Software (softwareName)));
        }
        else{
            System.out.println ("The software was not found!");
        }
    }

}
