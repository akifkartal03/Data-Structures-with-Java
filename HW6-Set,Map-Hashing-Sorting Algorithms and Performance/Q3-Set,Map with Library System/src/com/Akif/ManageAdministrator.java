package com.Akif;

import java.util.*;

/**
 * This class makes operations belongs to administrator.
 * We take operations to this class to write reusable code.
 * */
public class ManageAdministrator {
    /**
     * This field will be used when we make operations to reach all data.
     * */
    private Data data; //we will use it when we make operations
    /**
     * Two parameter constructor.
     * This class needs to Data object and Print Data object to make operations.
     * @param data all data regarding the system.
     * */
    public ManageAdministrator(Data data){
        this.data = data;
    }
    /**
     * This method manages the administrator
     * First it gets a choice from user and it makes that operation
     * @param adminID adminID of Administrator that will be manage the system.
     * */
    public void manage(int adminID){
        int choice;
        do {
            choice = GetChoiceFromUser.getSubChoice(5,new MenuForAdministrator(data.getAdmin(adminID).getFullName ()));
            if (choice==1) {
                addBook ();
            } else if (choice == 2){
                removeBook ();
            }
            else if(choice == 3){
                updateBook ();
            }
            else if(choice == 4){
                addAdmin ();
            }
            else if(choice == 5){
                data.printData ();
            }

        }while (choice!=0);
    }
    /**
     * This method adds a new Book to the System.
     * It uses data class to add new book.
     * */
    public void addBook(){
        Book book = new Book ();
        book.setAuthor (new Author (GetChoiceFromUser.getStringFromUser ("Enter author full name: ")));
        book.setTitle (GetChoiceFromUser.getStringFromUser ("Enter title of book: "));
        book.setLocation (new Location (GetChoiceFromUser.getSubChoice (5,"Enter corridor number(0-5): "),
                GetChoiceFromUser.getSubChoice (4,"Enter shelf number(0-4): ")));
        data.addBook (book);
    }
    /**
     * This method removes a Book from the System.
     * It uses data class to remove book.
     * */
    public void removeBook(){
        String authorName = GetChoiceFromUser.getStringFromUser ("Enter author Name of Book: ");
        String bookName = GetChoiceFromUser.getStringFromUser ("Enter Book Name: ");
        data.removeBook (bookName,authorName);
    }
    /**
     * This method update a book in the System.
     * It uses data class to update book.
     * */
    public void updateBook(){
        String authorName = GetChoiceFromUser.getStringFromUser ("Enter author Name of Book: ");
        String bookName = GetChoiceFromUser.getStringFromUser ("Enter Book Name: ");
        if (data.getBooksByTitle (bookName)!=null){
            System.out.println ("Enter new information about the book");
            Book book = new Book ();
            book.setAuthor (new Author (GetChoiceFromUser.getStringFromUser ("Enter author full name: ")));
            book.setTitle (GetChoiceFromUser.getStringFromUser ("Enter title of book: "));
            book.setLocation (new Location (GetChoiceFromUser.getSubChoice (5,"Enter corridor number(0-5): "),
                    GetChoiceFromUser.getSubChoice (4,"Enter shelf number(0-4): ")));
            data.updateBook (authorName,bookName,book);
        }
        else
            System.out.println ("Book was not found!!");

    }
    /**
     * This method adds a new Administrator to the System.
     * It uses data class to add new Administrator.
     * */
    public void addAdmin(){
        Administrator administrator = new Administrator();
        administrator.setFullName (GetChoiceFromUser.getStringFromUser("Enter a full Name: "));
        administrator.setId(GetChoiceFromUser.getIDFromUser(data));
        administrator.setPassword(GetChoiceFromUser.getStringFromUser("Enter a password: "));
        data.addAdmin(administrator);
        System.out.println("Your Administrator has added Successfully!");
    }

}
