package com.Akif;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Main class is to find shortest path on the maze.
 */
public class Main {
	/**
	 * main method of the program.
	 * @param args Not used.
	 */
    public static void main(String[] args) {
    	//--------create graph---------------------
		int numV = 0;
		BuildGraph buildGraph = new BuildGraph ();
		GraphADT maze = null;
		maze = buildGraph.createGraph ();
		numV = maze.getNumV();
		//-----------------------------------------------
		//get parent array
		int[] parent = BreadthFirstSearch.breadthFirstSearch(maze, 0);
		//push th parent array to the stack to print reverse order.
		Stack<Integer> thePath = new Stack<>();
		Stack<Integer> thePath2 = new Stack<>();
		int v = numV - 1;
		while (v != -1) {
			if (v!=0)
				thePath2.push (v);
			thePath.push(v);
			v = parent[v];
		}
		//-------------print vertices------------------
		for ( int k = 0; k < 45; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println("Junctions on the maze is:");
		for ( int k = 0; k < 45; k++) System.out.print ("-");
		System.out.print ("\n");
		ArrayList<Vertex> vertices = buildGraph.getJunctions ();
		for (Vertex vertex:vertices) {
			System.out.println (vertex);
		}
		for ( int k = 0; k < 45; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println("All edges on the graph:");
		System.out.println (maze);
		for ( int k = 0; k < 45; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println("Shortest path by using BreadthFirstSearch algorithm:\n");
		while (!thePath.isEmpty ()){
			System.out.println (thePath.pop ());
		}
		for ( int k = 0; k < 45; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println("Distances on shortest path:\n");
		int dest=0;
		while (!thePath2.empty()) {
			int source = thePath2.pop ();
			System.out.printf ("Distance between %d and %d: %.2f\n",dest,source,maze.getEdge (dest,source).getWeight ());
			dest =thePath2.pop ();
			System.out.printf ("Distance between %d and %d: %.2f\n",source,dest,maze.getEdge (source,dest).getWeight ());
		}


		int[] pred = new int[numV];
		double[] dist = new double[numV];
		DijkstrasAlgorithm.dijkstrasAlgorithm (maze,0,pred,dist);
		v = numV - 1;
		while (v != 0) {
			thePath.push(v);
			v = pred[v];
		}
		thePath.push (0);
		for ( int k = 0; k < 55; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println("Shortest path by using Dijkstras Algorithm:\n");
		while (!thePath.isEmpty ()){
			System.out.println (thePath.pop ());
		}
		for ( int k = 0; k < 55; k++) System.out.print ("-");
		System.out.print ("\n");
		System.out.println ("Shortest distance by using Dijkstras Algorithm: "+dist[numV-1]);
		for ( int k = 0; k < 55; k++) System.out.print ("-");
		System.out.print ("\n");
    }

}
