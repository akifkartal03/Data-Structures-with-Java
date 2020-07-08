package com.Akif;

/***
 * Main class is to test program.
 */
public class Main {
    /***
     * main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        FileSystemTree myFileSystem = new FileSystemTree("root");
        myFileSystem.addDir("root/first_directory");
        myFileSystem.addDir("root/second_directory");
        myFileSystem.addFile("root/first_directory/new_file.txt");
        myFileSystem.addDir("root/second_directory/new_directory");
        myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
        myFileSystem.search("directory");
        //myFileSystem.remove("root/first_directory/new_file.txt");
        //myFileSystem.remove("root/second_directory/new_directory");
        myFileSystem.printFileSystem ();

    }
}
