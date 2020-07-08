package com.Akif;

import java.util.Arrays;

/**
 * Class is to test the solution with directed and undirected graphs.
 */
public class Test {
    public void startTest(){
        testWithDirectedGraph ();
        testWithUndirectedGraph ();
    }
    private void testWithDirectedGraph(){
        //----------create graph--------------------
        Character[] arr = new Character[] {'A','B','C','D','E'};
        AdjacencyListMatrix<Character> adjacencyListMatrix = new AdjacencyListMatrix<> (5,true,arr);
        adjacencyListMatrix.printGraphRowAndColumn ();
        //---------Test insert-------------------------------------------
        //add Edge
        System.out.println ("Insert new Edges");
        adjacencyListMatrix.insert (new Edge<> ('A','B'));
        adjacencyListMatrix.insert (new Edge<> ('B','A'));
        adjacencyListMatrix.insert (new Edge<> ('B','E'));
        adjacencyListMatrix.insert (new Edge<> ('D','A'));
        adjacencyListMatrix.insert (new Edge<> ('E','A'));
        adjacencyListMatrix.insert (new Edge<> ('E','C'));
        adjacencyListMatrix.insert (new Edge<> ('E','D'));
        System.out.println (adjacencyListMatrix);
        //-----------------Test getEdge-----------------------------------------
        System.out.println ("GetEdge('E','A') : "+adjacencyListMatrix.getEdge ('E','A'));
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        //---------Delete Edge---------------------------------------
        System.out.println ("Delete Edge ('A','B')");
        adjacencyListMatrix.delete (new Edge<> ('A','B'));
        System.out.println (adjacencyListMatrix);
        //-------Insert Vertex-------------------------------------------------------
        System.out.println ("Insert vertex 'K' and Edge ('C','K')");
        adjacencyListMatrix.insertVertex ('K');
        adjacencyListMatrix.insert (new Edge<> ('C','K'));
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println (adjacencyListMatrix);
        //-------------------delete Vertex-------------------------
        System.out.println ("Delete Vertex 'E'");
        adjacencyListMatrix.deleteVertex ('E');
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println (adjacencyListMatrix);
        //------------------Breadth-First-Search-------------------------------------
        adjacencyListMatrix = new AdjacencyListMatrix<> (5,true,arr);
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println ("Insert new Edges");
        adjacencyListMatrix.insert (new Edge<> ('A','B'));
        adjacencyListMatrix.insert (new Edge<> ('B','A'));
        adjacencyListMatrix.insert (new Edge<> ('B','E'));
        adjacencyListMatrix.insert (new Edge<> ('D','A'));
        adjacencyListMatrix.insert (new Edge<> ('E','A'));
        adjacencyListMatrix.insert (new Edge<> ('E','C'));
        adjacencyListMatrix.insert (new Edge<> ('E','D'));
        System.out.println (adjacencyListMatrix);
        System.out.println ("Breadth-first search with Start vertex 'A' parent Array");
        System.out.println ("\t*null is -1");
        System.out.println (Arrays.toString (adjacencyListMatrix.bfs ('A')));
        System.out.println ("Info: index number of vertices");
        System.out.println ("0:A, 1:B, 2:C, 3:D, 4:E");
        //----------------Depth-First-Search--------------------------------------
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        System.out.println ("Depth-first search finish order Array");
        System.out.println (Arrays.toString (adjacencyListMatrix.dfs ()));
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        //-----------------Print the Edges--------------------------
        adjacencyListMatrix.printRnext ();
        adjacencyListMatrix.printRprev ();
        adjacencyListMatrix.printCprev ();
        System.out.println (adjacencyListMatrix);
    }
    private void testWithUndirectedGraph(){
        String[] arr = new String[]{"Armie","Joan","Maria","Nan","Tim"};
        AdjacencyListMatrix<String> adjacencyListMatrix = new AdjacencyListMatrix<> (5,false,arr);
        adjacencyListMatrix.printGraphRowAndColumn ();
        //---------Test insert-------------------------------------------
        //add Edge
        System.out.println ("Insert new Edges");
        adjacencyListMatrix.insert (new Edge<> ("Maria","Armie"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Tim"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Joan"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Nan"));
        adjacencyListMatrix.insert (new Edge<> ("Armie","Nan"));
        adjacencyListMatrix.insert (new Edge<> ("Armie","Tim"));
        adjacencyListMatrix.insert (new Edge<> ("Nan","Joan"));
        System.out.println (adjacencyListMatrix);
        //-----------------Test getEdge-----------------------------------------
        System.out.println ("GetEdge(Nan,Joan) : "+adjacencyListMatrix.getEdge ("Nan","Joan"));
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        //---------Delete Edge---------------------------------------
        System.out.println ("Delete Edge (\"Maria\",\"Joan\")");
        adjacencyListMatrix.delete (new Edge<> ("Maria","Joan"));
        System.out.println (adjacencyListMatrix);
        //-------Insert Vertex-------------------------------------------------------
        System.out.println ("Insert vertex \"Carol\" and Edge (\"Carol\",\"Tim\")");
        adjacencyListMatrix.insertVertex ("Carol");
        adjacencyListMatrix.insert (new Edge<> ("Carol","Tim"));
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println (adjacencyListMatrix);
        //-------------------delete Vertex-------------------------
        System.out.println ("Delete Vertex \"Armie\"");
        adjacencyListMatrix.deleteVertex ("Armie");
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println (adjacencyListMatrix);
        //------------------Breadth-First-Search-------------------------------------
        adjacencyListMatrix = new AdjacencyListMatrix<> (5,false,arr);
        adjacencyListMatrix.printGraphRowAndColumn ();
        System.out.println ("Insert new Edges");
        adjacencyListMatrix.insert (new Edge<> ("Maria","Armie"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Tim"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Joan"));
        adjacencyListMatrix.insert (new Edge<> ("Maria","Nan"));
        adjacencyListMatrix.insert (new Edge<> ("Armie","Nan"));
        adjacencyListMatrix.insert (new Edge<> ("Armie","Tim"));
        adjacencyListMatrix.insert (new Edge<> ("Nan","Joan"));
        System.out.println (adjacencyListMatrix);
        System.out.println ("Breadth-first search with Start vertex \"Maria\" parent Array");
        System.out.println ("\t*null is -1");
        System.out.println (Arrays.toString (adjacencyListMatrix.bfs ("Maria")));
        System.out.println ("Info: index number of vertices");
        System.out.println ("0:Amie, 1:Joan, 2: Maria, 3:Nan, 4:Tim");
        //----------------Depth-First-Search--------------------------------------
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        System.out.println ("Depth-first search finish order Array");
        System.out.println (Arrays.toString (adjacencyListMatrix.dfs ()));
        for ( int k = 0; k < 45; k++) System.out.print ("-");
        System.out.print ("\n");
        //-----------------Print the Edges--------------------------
        adjacencyListMatrix.printRnext ();
        adjacencyListMatrix.printRprev ();
        adjacencyListMatrix.printCprev ();
        System.out.println (adjacencyListMatrix);
    }

}
