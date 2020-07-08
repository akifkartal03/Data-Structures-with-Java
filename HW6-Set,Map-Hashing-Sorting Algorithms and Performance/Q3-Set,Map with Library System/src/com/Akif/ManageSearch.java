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
     * This method starts the search proper operation.
     * First it gets a choice from user and it executes that search operation
     * */
    public void startSearch(){
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(3,new MenuToSearch ());
            if (choice==1) {
                searchByAuthor ();
            } else if (choice == 2){
                searchByTitle ();
            }
            else if (choice == 3){
                data.printData ();
            }

        }while (choice!=0);
    }

    /**
     * Make search with given author name. If author is found,
     * all books of the author in the library will be listed on the screen.
     * Then, whichever book the user chooses, the location(s) of that book will be displayed.
     */
    public void searchByAuthor(){
        String authorName = GetChoiceFromUser.getStringFromUser ("Enter author Name of Book: ");
        Map<String, Set<Location>> bookMap = data.getBooksByAuthor (authorName);
        if (bookMap!=null && bookMap.size ()!=0){
            Set<String> books = bookMap.keySet ();
            System.out.println ("Books:");
            int i=0;
            for (String book:books) {
                System.out.printf("\t[%d] %s\n",i+1,book);
                i++;
            }
            System.out.println("[0] Return Back");
            int choice = GetChoiceFromUser.getSubChoice (books.size (),"Choose a book to see location: ");
            if (choice!=0){
                Collection<Set<Location>> locs=bookMap.values ();
                Iterator<Set<Location>> iter = locs.iterator ();
                int k=1;
                Set<Location> locations = iter.next ();
                while (iter.hasNext ()&&k<choice){
                    locations =iter.next ();
                    k++;
                }
                System.out.println ("Locations:");
                int j =0;
                for (Location loc:locations) {
                    System.out.printf("\t[%d] %s\n",j+1,loc.getCode ());
                    j++;
                }
            }
        }
        else{
            System.out.println ("The author was not found!");
        }
    }

    /**
     * Make search with given book name. If book is found,
     * author name, location and status will be shown.
     */
    public void searchByTitle(){
        boolean is_found=false;
        String bookName = GetChoiceFromUser.getStringFromUser ("Enter Book Name: ");
        Collection<Map<String, Set<Location>>> list =data.getAllValues ();
        Set<String> authors = data.getAuthors ();
        if (list!=null && authors!=null && list.size ()!=0 && authors.size ()!=0){
            Iterator<Map<String, Set<Location>>> iter =list.iterator ();
            int i =0;
            while (iter.hasNext ()){
                Map<String, Set<Location>> bookMap = iter.next ();
                if (bookMap.containsKey (bookName)){
                    is_found=true;
                    int k=0;
                    for (String author:authors) {
                        if (k==i)
                            System.out.println ("Author: "+author);
                        k++;
                    }
                    Collection<Set<Location>> locations1 = bookMap.values ();
                    int t=0;
                    Set<String> books = bookMap.keySet ();
                    for (String book:books) {
                        if (book.equals (bookName)){
                            break;
                        }
                        t++;
                    }
                    int s =0;
                    for (Set<Location> loc:locations1) {
                        if (s==t){
                            int m =0;
                            for (Location l:loc) {
                                System.out.println ("Locations:");
                                System.out.printf("\t[%d] %s\n",m+1,l.getCode ());
                                m++;
                            }
                            System.out.println ("Status: Available");
                        }
                        s++;
                    }
                }
                i++;
            }
        }
        else
            System.out.println ("Book was not found!");
        if (!is_found)
            System.out.println ("Book was not found!");
    }
}
