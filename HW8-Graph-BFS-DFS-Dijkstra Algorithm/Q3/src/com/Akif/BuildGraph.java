package com.Akif;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is to read maze and create the graph.
 */
public class BuildGraph {
    /**
     * 2D maze from file
     */
    private int[][] maze;
    /**
     * Row number of maze
     */
    int mazeSize;
    /**
     *  Junction squares on the maze
     */
    ArrayList<Vertex> vertices;
    /**
     * List Graph for maze
     */
    ListGraph graph;
    /**
     * A vertex value to use later.
     */
    Vertex temp;

    /**
     * This method creates the graph.
     * First it reads maze then it finds the Junction points and creates the vertices.
     * According to vertices it creates the graph.
     * @return Graph that was created.
     */
    public GraphADT createGraph(){
        vertices = new ArrayList<> ();
        createMazeFromFile ("maze.txt");
        graph = new ListGraph (vertices.size (),true);
        int[] dir = new int[4];
        for (Vertex vertex : vertices) {
            initArr (vertex.getX (),vertex.getY (),dir);
            findVertex (vertex.getX (),vertex.getY (),vertex,dir);
        }
        return graph;
    }

    /**
     * This method finds the Junction points on the maze and creates the vertices.
     * @param fileName a file to read.
     */
    private void createMazeFromFile(String fileName){
        vertices.add (new Vertex (0,0,0));
        fillArray (fileName);
        for (int i = 0; i < mazeSize ; i++) {
            int size = maze[i].length;
            for (int j = 0; j < size; j++) {
                if (maze[i][j]==0 && isJunction (i,j,size)){
                    Vertex v = vertices.get (vertices.size ()-1);
                    vertices.add (new Vertex (i,j,vertices.size ()));
                }
            }
        }
        Vertex v = vertices.get (vertices.size ()-1);
        vertices.add (new Vertex (mazeSize-1,maze[mazeSize-1].length-1,vertices.size ()));

    }

    /**
     * This method reads maze from file and creates 2D maze array.
     * @param fileName a file to read.
     */
    private void fillArray(String fileName){
        try {
            BufferedReader file = new BufferedReader(new FileReader (fileName));
            String line;
            ArrayList<String > rows = new ArrayList<> ();
            while ((line = file.readLine()) != null) {
               rows.add (line);
            }
            file.close (); //close file
            mazeSize=rows.size ();
            maze = new int[rows.size ()][];
            for (int i = 0; i <rows.size () ; i++) {
                line = rows.get (i);
                maze[i] = new int[line.length ()];
                for (int j = 0; j < line.length () ; j++) {
                    maze[i][j] =Integer.parseInt (String.valueOf (line.charAt (j)));
                }
            }
            for ( int k = 0; k < 45; k++) System.out.print ("-");
            System.out.print ("\n");
            System.out.println ("File was read successfully.");
        }catch (Exception e){
            System.out.println("Maze file is not in the same directory!");
            System.out.println("To fill maze automatically please add it!");
        }
    }

    /**
     * This methods checks whether a point on the maze is junction or not.
     * @param row row index of point
     * @param column column index of point
     * @param colSize column size of that row
     * @return true if this point is a junction
     */
    private boolean isJunction(int row , int column,int colSize){
        int counter =0;
        boolean u=false,l=false;
        if (row-1>=0 && maze[row-1][column]==0){
            counter++;
            u=true;
        }

        if (row+1<mazeSize && maze[row+1][column]==0){
            if (!u){
                counter++;
            }
        }
        if (column-1>=0 && maze[row][column-1]==0){
            counter++;
            l=true;
        }

        if (column+1<colSize && maze[row][column+1]==0){
            if (!l){
                counter++;
            }
        }
        return counter>=2;
    }

    /**
     * This method calculates the distance between two point.
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @return the distance between two point.
     */
    private double calculateDistance(int x1,int y1,int x2,int y2){
        return  Math.sqrt (Math.pow ((x2-x1),2)+Math.pow ((y2-y1),2));
    }
    private boolean check(int x , int y,int id){
        for (Vertex vertex : vertices) {
            if (vertex.getX ()==x && vertex.getY ()==y && vertex.getId ()!=id){
                temp = vertex;
                return true;
            }
        }
        return false;
    }

    /**
     * This methods determine adjacent directions that is open for this point.
     * @param row row index of point
     * @param column column index of point
     * @param dir directions that is open for this point.
     */
    private void initArr(int row,int column,int[] dir){
        /*
        0 left
        1 right
        2 up
        3 down
         */
        for (int i = 0; i <4 ; i++) dir[i] = -1;
        if (row-1>=0 && maze[row-1][column]==0)
            dir[2] = 1;
        if (row+1<mazeSize && maze[row+1][column]==0)
            dir[3] = 1;
        if (column-1>=0 && maze[row][column-1]==0)
            dir[0] = 1;
        if (column+1<maze[row].length && maze[row][column+1]==0)
            dir[1] = 1;
    }

    /**
     * This method finds adjacent vertices of given source vertex in the maze.
     * @param x x coordinate of source vertex
     * @param y y coordinate of source vertex
     * @param source source vertex
     * @param dir directions
     */
    private void findVertex(int x , int y,Vertex source,int[] dir){
        if (dir[0]!=-1){
            checkLeft (x,y,source);
        }
        if (dir[1]!=-1){
            checkRight (x,y,source);
        }
        if (dir[2]!=-1){
            checkUp (x,y,source);
        }
        if (dir[3]!=-1){
            checkDown (x,y,source);
        }

    }
    private void checkLeft(int x , int y,Vertex source){
        if (x < 0 || y < 0 || x >= mazeSize || y >= maze[x].length)
            return;
        else if (maze[x][y] == 1)
            return;
        else if(check (x,y,source.getId ())){
            addEdge (source,temp);
            return;
        }
        else
            checkLeft (x , y-1,source);

    }
    private void checkRight(int x , int y,Vertex source){
        if (x < 0 || y < 0 || x >= mazeSize || y >= maze[x].length)
            return;
        else if (maze[x][y] == 1)
            return;
        else if(check (x,y,source.getId ())){
            addEdge (source,temp);
            return;
        }
        else
            checkRight (x , y+1,source);

    }
    private void checkUp(int x , int y,Vertex source){
        if (x < 0 || y < 0 || x >= mazeSize || y >= maze[x].length)
            return;
        else if (maze[x][y] == 1)
            return;
        else if(check (x,y,source.getId ())){
            addEdge (source,temp);
            return;
        }
        else
            checkUp(x-1 , y,source);

    }
    private void checkDown(int x , int y,Vertex source){
        if (x < 0 || y < 0 || x >= mazeSize || y >= maze[x].length)
            return;
        else if (maze[x][y] == 1)
            return;
        else if(check (x,y,source.getId ())){
            addEdge (source,temp);
            return;
        }
        else
            checkDown (x+1 , y,source);
    }
    /**
     * This method checks a point open square or not in the given 2D maze array.
     * @param x x coordinate of point
     * @param y y coordinate of point
     * @param arr 2D maze array.
     * @return true if this point is open square.
     */
    private boolean isOpen(int x,int y,int[][] arr) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0 )) {
            return true;
        }
        return false;
    }

    /**
     * This method adds an edge between two vertices.
     * @param source source vertex.
     * @param dest destination vertex.
     */
    private void addEdge(Vertex source,Vertex dest){
        graph.insert (new Edge (source.getId (),dest.getId (),calculateDistance (source.getX (),source.getY (),
                dest.getX (),dest.getY ())));
    }

    /**
     * Returns vertices on the maze and graph.
     * @return vertices on the maze and graph.
     */
    public ArrayList<Vertex> getJunctions(){return vertices;}
}
