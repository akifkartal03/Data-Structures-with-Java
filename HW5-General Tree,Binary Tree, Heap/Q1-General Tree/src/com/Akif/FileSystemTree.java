package com.Akif;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * This class is to handle a file system hierarchy in a general tree structure.
 */
public class FileSystemTree {
    /***
     * Root reference of the tree.
     */
    protected FileNode root;
    /***
     *One parameter constructor to create a file system with a root directory.
     * Name of the root directory will be given as a parameter to the constructor.
     * @param rootDirectory name of the root directory.
     */
    public FileSystemTree(String rootDirectory){
        root = new FileNode (rootDirectory);
    }

    /***
     * This methods adds a new directory to the System.
     * @param directory the path of the new directory.
     */
    public void addDir(String directory){
        try {
            String[] arr = directory.split ("/");
            String newDirectory = arr[arr.length-1];
            String currentDir = arr[arr.length-2];
            add (root,currentDir,newDirectory,directory);
        }catch (Exception e){
            throw new IllegalArgumentException ();
        }
    }
    /***
     * This methods adds a new file to the System.
     * @param directory the path of the new file.
     */
    public void addFile(String directory){
        String[] arr = directory.split ("/");
        String newDirectory = arr[arr.length-1];
        if (newDirectory.contains ("."))
            addDir (directory);
        else
            System.out.println ("This is not a file!");
    }

    /***
     * A helper add method to add new directory or file.
     * @param tempRoot root of the tree
     * @param dir parent directory name of new directory or file.
     * @param newDir new directory or file name.
     * @param givenDir full directory is given from user.
     */
    private void add(FileNode tempRoot,String dir,String newDir,String givenDir){
        LinkedList<FileNode> list = new LinkedList<> ();
        //find parent directory from tree and add it to the list
        //list will contain only one element if it is found.
        find (tempRoot,list,dir);
        if (list.size ()==0){ //parent directory was not found.
            System.out.println ("Directory was not found!");
        }
        else{ //parent directory was found.
            FileNode node = list.get (0); //get node
            StringBuilder sb = new StringBuilder ();
            getParentFamily (node,sb);
            String fullPath = sb.append (newDir).toString ();
            if (!givenDir.equals (fullPath)){ //all given directory is not true
                System.out.println ("Directory was not found!");
            }
            else{
                if (node.isDirectory ()){
                    if (!isContain (node,newDir))
                        node.children.add (new FileNode (newDir,node)); //add a new children to it.
                    else
                        System.out.println ("This directory or file is already used!!");
                }
                else
                    System.out.println ("Your path is not a directory!");
            }
        }
    }

    /***
     * A checker method to check given current directory whether has given new directory or not.
     * @param node parent directory to add new directory.
     * @param directory new directory name.
     * @return true if it has already this directory.
     */
    private boolean isContain(FileNode node,String directory){
        for (int i = 0 ;i<node.children.size ();i++){
            if (node.children.get (i).data.equals (directory))
                return true;
        }
        return false;
    }
    /***
     * This method is to remove a directory (or a file) from the file system. The path of the
     * directory (or the file) will be given as a parameter to the method.
     * @param directory The path of the directory (or the file)
     */
    public void remove(String directory){
        if (!directory.contains ("/"))
            throw new IllegalArgumentException ();
        try {
            String[] arr = directory.split ("/");
            String newDirectory = arr[arr.length-1]; // new directory
            remove (root,directory,newDirectory);
        }catch (Exception e){
            throw new IllegalArgumentException ();
        }

    }

    /***
     * A helper remove method to remove new directory or file.
     * @param tempRoot root of the tree
     * @param givenDir full directory is given from user.
     * @param removedDir directory name to remove
     */
    private void remove(FileNode tempRoot,String givenDir,String removedDir){
        LinkedList<FileNode> list = new LinkedList<> ();
        //find current directory from tree and add it to the list
        //list will contain only one element if it is found.
        find (tempRoot,list,removedDir);
        if (list.size ()==0){
            System.out.println ("Directory was not found!");
        }
        else{
            FileNode node = list.get (0);
            StringBuilder sb = new StringBuilder ();
            getParentFamily (node,sb);
            String fullPath = sb.deleteCharAt (sb.length ()-1).toString ();
            if (!givenDir.equals (fullPath)){ //all given directory is not true
                System.out.println ("Directory was not found!");
            }
            else{
                FileNode parent = node.parent;
                if (node.children.size ()>0){
                    Scanner input = new Scanner (System.in);
                    System.out.println ("Your Directory contains following Directories or files");
                    printChildren (node);
                    System.out.print ("\nDo you want to remove(yes/no): ");
                    String choice = input.next();
                    if (choice.equals ("yes") || choice.equals ("Yes")){
                        parent.children.remove (node);
                        System.out.println ("Your directory was removed!");
                    }
                    else{
                        System.out.println ("Your directory was not removed!");
                    }
                }
                else{
                    parent.children.remove (node);
                    System.out.println ("Your directory was removed!");
                }
            }
        }
    }

    /***
     * This method is to print the whole tree.
     */
    public void printFileSystem(){
        System.out.println ("\t\t***All General Tree***");
        for (int i = 0 ; i<70;i++) System.out.print("-");
        System.out.println ();
        System.out.println ("Directory\t\t\tSub-Directories or Files(if any)");
        for (int i = 0 ; i<70;i++) System.out.print("-");
        System.out.println ();
        print (root);
        for (int i = 0 ; i<70;i++) System.out.print("-");
        System.out.println ();
    }

    /***
     * Helper print method to print each child of the tree.
     * This method uses a recursive traverse algorithm such that
     * it traverse each node by traversing each child of that node.
     * In other word, it starts from leftmost child node it traverse all children of this node
     * and children of the that child after there is no children in left side, it continue with other children.
     * After all elements is done it stops automatically without a base case.
     * @param tempRoot root of tree.
     */
    private void print(FileNode tempRoot){
        printOneChild (tempRoot);
        for(FileNode node : tempRoot.children)
            print (node);//recursive call wit a child.
    }

    /***
     * This helper method prints one node of tree with its children.
     * @param node a node to print.
     */
    private void printOneChild(FileNode node){
        if (node!=null){
            if (node.isDirectory ()){
                System.out.print (node.data);
                for (int i = 0 ; i<26-node.data.length ();i++) System.out.print(" ");
                System.out.print ("==>\t");
                printChildren (node);
                System.out.println ();
            }
        }
    }

    /***
     * This helper method prints children of the given node.
     * @param node a node to print its children.
     */
    private void printChildren(FileNode node){
        for (int i=0;i<node.children.size ();i++){
            if (i==node.children.size ()-1)
                System.out.print (node.children.get (i).data);
            else
                System.out.print (node.children.get (i).data+", ");
        }
    }

    /***
     * This method searches for given target directory or file in the tree.
     * if target is in the tree, it add it to the given list as a node.
     * This method uses a recursive traverse algorithm such that
     * it traverse each node by traversing each child of that node.
     * In other word, it starts from leftmost child node it traverse all children of this node
     * and children of the that child after there is no children in left side, it continue with other children.
     * After all elements is done it stops automatically without a base case.
     * @param tempRoot root of tree.
     * @param list a linkedList to add found element.
     * @param target a directory or file to search.
     */
    private void find(FileNode tempRoot, LinkedList<FileNode> list,String target){
        if (tempRoot.data.equals (target))
            list.add (tempRoot);
        for(FileNode node : tempRoot.children)
            find (node,list,target);//recursive call with a child.
    }

    /***
     * This method is to search the entire file system for a directory or a file including the given
     * search characters in its name.
     * @param word search characters that will be searched.
     */
    public void search(String word){
        LinkedList<FileNode> list =new LinkedList<> ();
        searchHelper (root,word,list);
        if (list.size ()==0){
            System.out.println ("Your directory was not found!");
        }
        else{
            System.out.printf ("Your Search Results for '%s':\n",word);
            for (FileNode node:list) {
                if (node.isDirectory ())
                    System.out.print ("dir - ");
                else
                    System.out.print ("file - ");
                printSearchResults (node);
            }
        }
    }

    /***
     * Returns parents of given directory as a path in StringBuilder.
     * @param node a directory to find its parent family
     * @param sb StringBuilder to return family as a path.
     */
    private void getParentFamily(FileNode node,StringBuilder sb){
        if (node==null)
            return;
        else
            getParentFamily (node.parent,sb);
            sb.append (node.data).append ("/");
    }

    /***
     * This helper method print search results to the screen as a path.
     * @param node a directory will be printed with its family.
     */
    private void printSearchResults(FileNode node){
        StringBuilder sb = new StringBuilder ();
        getParentFamily (node,sb);
        sb.deleteCharAt (sb.length ()-1);
        System.out.println (sb.toString ());
    }
    /***
     * Helper search method to search given characters.
     * If any child contains this characters it will be added to the given list.
     * This method uses a recursive traverse algorithm such that
     * it traverse each node by traversing each child of that node.
     * In other word, it starts from leftmost child node it traverse all children of this node
     * and children of the that child after there is no children in left side, it continue with other children.
     * After all elements is done it stops automatically without a base case.
     * @param tempRoot root of tree.
     * @param word given characters to search.
     * @param list If any child contains this characters it will be added to the given list.
     */
    private void searchHelper(FileNode tempRoot,String word,LinkedList<FileNode> list){
        if (tempRoot.data.contains (word))
            list.add (tempRoot);
        for(FileNode node : tempRoot.children)
            searchHelper (node,word,list);
    }

    /***
     * This class is to handle the nodes of the tree.
     * It uses ArrayList to keep all children.
     */
    protected static class FileNode{
        /***
         * Data of a child.
         */
        protected String data;
        /***
         * List of children.
         */
        ArrayList<FileNode> children;
        /***
         * Parent of this child.
         */
        FileNode parent;
        /***
         * It indicates whether this is a directory or file.
         * Difference between files or directory is it has a dot or not.
         */
        protected boolean directory;

        /***
         * One parameter constructor to construct node with given data.
         * @param d data of node
         */
        public FileNode(String d){
            data=d;
            children=new ArrayList<> ();
            directory = !d.contains (".");
            parent=null;
        }

        /***
         * Two parameter constructor to construct node with given data and parent.
         * @param d data of node.
         * @param p parent of node
         */
        public FileNode(String d,FileNode p){
            data=d;
            children=new ArrayList<> ();
            directory = !d.contains (".");
            parent=p;
        }

        /***
         * Returns data of node.
         * @return data of node.
         */
        public String toString(){
            return data;
        }

        /***
         * Returns this node is directory or not.
         * @return this node is directory or not.
         */
        public boolean isDirectory(){
            return directory;
        }
    }
}
