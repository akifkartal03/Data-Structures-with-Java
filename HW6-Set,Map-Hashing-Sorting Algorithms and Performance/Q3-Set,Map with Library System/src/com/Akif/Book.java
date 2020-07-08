package com.Akif;

/**
 * A general class for books.
 */
public class Book {
    /**
     * Author of book.
     */
    private Author author;
    /**
     * Title of book.
     */
    private  String title;
    /**
     * Location of book.
     */
    private Location location;
    /**
     * Status of book.
     */
    private String status = "available";
    //getter and setter
    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public Author getAuthor () {
        return author;
    }

    public void setAuthor (Author author) {
        this.author = author;
    }

    public Location getLocation () {
        return location;
    }

    public void setLocation (Location location) {
        this.location = location;
    }
    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }
    /***
     * Creates a String that contains all properties of book.
     * @return String that contains all properties of book.
     */
    @Override
    public String toString () {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", location=" + location +
                ", status='" + status + '\'' +
                '}';
    }


}
