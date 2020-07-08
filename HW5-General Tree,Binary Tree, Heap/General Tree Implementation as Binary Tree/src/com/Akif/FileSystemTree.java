package com.Akif;

import java.util.Scanner;

public class FileSystemTree {
    protected FileNode root;
    public FileSystemTree(String rootDirectory){
        root = new FileNode (rootDirectory);
    }
    public void addDir(String directory){
        try {
            String[] arr = directory.split ("/");
            String newDirectory = arr[arr.length-1];
            String currentDir = arr[arr.length-2];
            add (root,currentDir,newDirectory);
        }catch (Exception e){
            throw new IllegalArgumentException ();
        }
    }
    public void addFile(String directory){
        addDir (directory);
    }
    private void add(FileNode tempRoot,String dir,String newDir){
        FileNode node = null;
        node = find (tempRoot,dir,node);
        if (node!=null && node.isDirectory ()){
            if (node.left==null){
                node.left=new FileNode (newDir);
            }
            else{
                getLastNode (node.left,false).right =new FileNode (newDir);
            }
        }
        else{
            System.out.println ("Your Directory is not proper!!");
        }
    }
    private FileNode getLastNode(FileNode parent,boolean print){
        if (parent.right==null)
            return parent;
        else {
            if (print)
                System.out.print (parent.right.data+", ");
            return getLastNode (parent.right,print);
        }
    }
    private FileNode find(FileNode tempRoot,String target,FileNode found){
        if (tempRoot==null){
            return found;
        }
        if (tempRoot.data.equals (target))
            return tempRoot;
        found = find (tempRoot.left,target,found);
        found = find (tempRoot.right,target,found );
        return found;
    }
    private FileNode findParent(FileNode tempRoot,String target,FileNode found){
        if (tempRoot==null){
            return found;
        }
        if (tempRoot.left!=null && tempRoot.left.data.equals (target)){
            return tempRoot;
        }
        if (tempRoot.right!=null && tempRoot.right.data.equals (target)){
            return tempRoot;
        }
        found = findParent (tempRoot.left,target,found);
        found = findParent (tempRoot.right,target,found );
        return found;
    }
    private int getNumberOfCh(String str){
        int counter =0;
        for (int i=0;i<str.length ();i++){
            if (str.charAt (i) == '/')
                counter++;
        }
        return counter;
    }
    public void printFileSystem(){
        System.out.println ("Directory\t\t\t\t\t\tSub-Directories or Files(if any)");
        for (int i = 0 ; i<70;i++) System.out.print("-");
        System.out.println ();
        printAllElement (root,false);
        for (int i = 0 ; i<70;i++) System.out.print("-");
        System.out.print ("\nWhole Tree ==>  ");
        printAllElement (root,true);
        System.out.println ();
    }
    private void printAllElement(FileNode tempRoot,boolean printAll){
        if (tempRoot==null){
            return;
        }
        else{
            if (tempRoot.isDirectory () && !printAll){
                System.out.print (tempRoot.data);
                for (int i = 0 ; i<26-tempRoot.data.length ();i++) System.out.print(" ");
                System.out.print ("==>\t");
                printOneElement (tempRoot);
            }
            if (printAll)
                System.out.print (tempRoot.data+", ");
            printAllElement (tempRoot.left,printAll);
            printAllElement (tempRoot.right,printAll);
        }
    }
    private void printOneElement(FileNode oneElement){
        if (oneElement.left!=null){
            System.out.print (oneElement.left.data+", ");
            getLastNode (oneElement.left,true);
        }
        System.out.println ();
    }
    public void remove(String directory){
        try {
            String[] arr = directory.split ("/");
            String newDirectory = arr[arr.length-1];
            String currentDir = arr[arr.length-2];
            remove (root,currentDir,newDirectory);
        }catch (Exception e){
            throw new IllegalArgumentException ();
        }
    }
    private void remove(FileNode tempRoot,String dir,String newDir){
        FileNode node = null;
        FileNode parent = null;
        node = find (tempRoot,newDir,node);
        parent = findParent (tempRoot,newDir,node);
        if (node!=null){
            if (node.left==null){
                if (parent.left!=null && parent.left.data.equals (newDir))
                    parent.left=node.right;
                else
                    parent.right=node.right;
            }
            else{
                Scanner input = new Scanner (System.in);
                System.out.println ("Your Directory contains following Directories or files");
                printOneElement (node);
                System.out.print ("Do you want to remove(yes/no): ");
                String choice = input.next();
                if (choice.equals ("yes") || choice.equals ("Yes")){
                    if (parent.left!=null && parent.left.data.equals (newDir))
                        parent.left=node.right;
                    else
                        parent.right=node.right;
                    System.out.println ("Your directory was removed!");
                }
                else{
                    System.out.println ("Your directory was not removed!");
                }
            }
        }
        else{
            System.out.println ("Your Directory was not found!!");
        }

    }
    protected static class FileNode{
        protected String data;
        protected FileNode left;
        protected FileNode right;
        protected boolean directory;
        public FileNode(String d){
            data=d;
            left=null;
            right=null;
            directory = !d.contains (".");
        }
        public String toString(){
            return data;
        }
        public boolean isDirectory(){
            return directory;
        }
        public void setDirectory(boolean isDirectory){
            directory=isDirectory;
        }
    }
}
