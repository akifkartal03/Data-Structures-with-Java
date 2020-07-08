package com.Akif;

/**
 * A general Class for Author.
 */
public class Author extends Person {
    /**
     * No parameter constructor to initialize Author.
     * */
    public Author(){
        super();
    }

    /**
     * One parameter constructor to initialize Author full name.
     * @param fullName name of author.
     */
    public Author(String fullName){
        super(fullName);
    }
}
