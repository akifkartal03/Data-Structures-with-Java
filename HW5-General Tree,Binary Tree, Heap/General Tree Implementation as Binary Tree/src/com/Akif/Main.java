package com.Akif;

public class Main {

    public static void main(String[] args) {
        FileSystemTree myFileSystem = new FileSystemTree("root");
        //Add directories and files using paths
        /*myFileSystem.addDir("root/first_directory");
        myFileSystem.addDir("root/second_directory");
        myFileSystem.addFile("root/first_directory/new_file.txt");
        myFileSystem.addDir("root/second_directory/new_directory");
        myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
        myFileSystem.printFileSystem ();*/
        myFileSystem.addDir("root/first_directory");
        myFileSystem.addDir("root/second_directory");
        myFileSystem.addFile ("root/first_directory/new_file.txt");
        myFileSystem.addDir("root/second_directory/new_directory");
        myFileSystem.addFile ("root/second_directory/new_directory/new_file.doc");
        myFileSystem.addDir ("root/second_directory/new_directory/second_file");
        myFileSystem.addDir ("root/second_directory/new_directory/second_file_child");
        myFileSystem.addDir ("root/second_directory/new_directory/second_file_child/new_child");
        myFileSystem.addDir ("root/second_directory/new_directory/second_file_child/new_child2");
        myFileSystem.remove ("root/second_directory/new_directory/new_file.doc");
        //myFileSystem.remove ("root/first_directory");
        myFileSystem.remove ("root/second_directory");
        myFileSystem.printFileSystem ();
    }
}
