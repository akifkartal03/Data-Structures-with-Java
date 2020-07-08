package com.Akif;

import java.util.*;

/**
 * This class keeps all data regarding the system in a nested Map.
 * It also operate the data.
 * It keeps data by using Set,Map and ArrayList.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class Data {
    //whole data
    /**
     * Information about the books should be stored in nested map and set data structures.
     * For the outermost map, the author name is used as a key,
     * the value is another map whose keys are book names. In the inner map, the values are sets showing the
     * location (or locations if there is more than one copy) of that book.
     */
    private Map<String , Map<String, Set<Location>>> map;
    /**
     * This ArrayList keeps whole Administrator that are in the System.
     * */
    private ArrayList<Administrator> administratorMyArray;
    /**
     * This ArrayList keeps whole IDs that are Administrators have.
     * */
    private ArrayList<Integer> IDList ;
    /**
     * No parameter constructor.
     * It initializes all array and map.
     * */
    public Data(){
        administratorMyArray = new ArrayList<>();
        IDList = new ArrayList<>();
        map = new HashMap<> ();
    }
    /**
     * Adds a book to the System.
     * @param book new book to add.
     * */
    public void addBook(Book book){

        if (map.containsKey (book.getAuthor ().getFullName ())){//if there is same author
            if (map.get (book.getAuthor ().getFullName ()).containsKey (book.getTitle ())){ //if it has same book
                map.get (book.getAuthor ().getFullName ()).get (book.getTitle ()).add (book.getLocation ());//add new location
            }
            else{//if it has not that book
                Set<Location> set = new HashSet<> ();
                set.add (book.getLocation ());
                map.get (book.getAuthor ().getFullName ()).put (book.getTitle (),set); //add it to the map
            }
        }
        else{ //add with author
            Map<String, Set<Location>> bookMap =new HashMap<> ();//value
            Set<Location> set = new HashSet<> ();//set
            set.add (book.getLocation ());
            bookMap.put (book.getTitle (),set);
            map.put (book.getAuthor ().getFullName (),bookMap);
        }
    }

    /**
     * Remove a Book from the System.
     * @param bookName name of book
     * @param authorName author of book
     */
    public void removeBook(String bookName,String authorName){
        if (map.containsKey (authorName)){//if there is same author
            if (map.get (authorName).containsKey (bookName)){ //if it has same book
                if ( map.get (authorName).get (bookName).size ()>1){
                    Set<Location> locations=getBooksByTitle (bookName);
                    Iterator<Location> iterator =locations.iterator ();
                    map.get (authorName).get (bookName).remove (iterator.next ());
                }
                else{
                    map.get (authorName).remove (bookName);
                }
                System.out.println ("1 book removed from library");
            }
            else{//if it has not that book
                System.out.println ("Book was not found!");
            }
        }
        else
            System.out.println ("Author was not found!");
    }
    /**
     * Get a Book Map from the System.
     * @param authorName author name to search books
     * @return Return specific author(key) content from the Map.
     * */
    public Map<String, Set<Location>> getBooksByAuthor(String authorName){
        if (map.containsKey (authorName)){//if there is author
            return map.get (authorName);
        }
        return null;
    }

    /**
     * Get Book Locations from the System.
     * @param bookTitle book to search
     * @return Book Locations from the System.
     */
    public Set<Location> getBooksByTitle(String bookTitle){
        Collection<Map<String, Set<Location>>> list;//values of authors
        ArrayList<Set<Location>> locations = new ArrayList<> ();
        list=map.values ();
        Iterator<Map<String, Set<Location>>> iter =list.iterator ();
        while (iter.hasNext ()){
            Map<String, Set<Location>> setMap = iter.next ();
            if (setMap.containsKey (bookTitle))
                return setMap.get (bookTitle);
        }
        return null;
    }

    /**
     * Return all authors from system.
     * @return all authors from system
     */
    public Set<String> getAuthors(){
        return map.keySet ();
    }

    /**
     * Return all values of outer map.
     * @return all authors from system
     */
    public Collection<Map<String, Set<Location>>> getAllValues(){
        return map.values ();
    }
    /**
     * Change old book with new book
     * @param oldBook a book to update.
     * @param newBook a book that is updated.
     */
    public void updateBook(String author,String oldBook,Book newBook){
        if (map.containsKey (author)){//if there is same author
            if (map.get (author).containsKey (oldBook)){ //if it has same book
                if ( map.get (author).get (oldBook).size ()>1){
                    Set<Location> locations=getBooksByTitle (oldBook);
                    Iterator<Location> iter=locations.iterator ();
                    iter.remove ();
                    locations.add (newBook.getLocation ());
                    map.get (author).put (newBook.getTitle (),locations);
                }
                else{
                    map.get (author).remove (oldBook);
                    Set<Location> locations=new HashSet<> ();
                    locations.add (newBook.getLocation ());
                    map.get (author).put (newBook.getTitle (),locations);
                }

            }
            else{//if it has not that book
                System.out.println ("Book was not found!");
            }
        }
        else{
            System.out.println ("Author was not found!");
        }
    }
    /**
     * Add a new admin to the System.
     * @param administrator new administrator to add.
     * */
    public void addAdmin(Administrator administrator){
        administratorMyArray.add(administrator);
    }
    /***
     * Add given id in arraylist
     * @param id will be added.
     */
    public void addID(int id){
        IDList.add(id);
    }

    /***
     * This method checks given id is used or not ?
     * @param id will be checked
     * @return true if it is not used
     */
    public boolean IDUsed(int id){
        for (int i = 0 ; i< IDList.size();i++){
            if (IDList.get(i) == id){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of admin from system.
     * @return number of admin from system.
     */
    public int numberOfAdmin(){
        return administratorMyArray.size();
    }

    /**
     * Return an admin at given index
     * @param index index of admin in ArrayList.
     * @return an admin at given index
     */
    public Administrator getAdmin(int index){
        return administratorMyArray.get(index);
    }

    /**
     * This method prints All data in the System in a good shape.
     * */
    public void printData () {
        Set<String> authors = map.keySet ();//author names
        Set<String> books ;
        Collection<Map<String, Set<Location>>> list;
        Set<Location> locations;
        list=map.values ();
        if (list.size ()!=0 && authors.size ()!=0){
            Iterator<Map<String, Set<Location>>> iter =list.iterator ();
            int j=0;
            System.out.println ("Authors:");
            for (String author:authors) {
                System.out.printf("[%d] %s\n",j+1,author);
                System.out.println ("\tBooks:");
                j++;
                if (iter.hasNext ()){
                    Map<String, Set<Location>> setMap = iter.next ();
                    books=setMap.keySet ();
                    int i=0;
                    for (String book:books) {
                        System.out.printf("\t[%d] %s\n",i+1,book);
                        locations=setMap.get (book);
                        int k=0;
                        System.out.println ("\t\tLocations:");
                        for (Location loc:locations) {
                            System.out.printf("\t\t[%d] %s\n",k+1,loc.getCode ());
                            k++;
                        }
                        i++;
                    }
                }
                else{
                    break;
                }

            }
        }
        else
            System.out.println ("There is no book in the Library!");
        System.out.println ();
    }
}
