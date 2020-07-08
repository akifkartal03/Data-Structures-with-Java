package com.Akif;
import java.util.*;

/**
 * Updated Class to implement the depth-first search algorithm from book.
 * @param <E> Type of vertex.
 */
@SuppressWarnings ("unchecked")
public class DepthFirstSearch<E> {

  /** A reference to the graph */
  private AdjacencyListMatrix<E> graph;

  /** Array of parents in the depth-first search tree. */
  private int[] parent;

  /** Flag to indicate whether this vertex has been visited. */
  private boolean[] visited;

  /** The array that contains each vertex in discovery order. */
  private int[] discoveryOrder;

  /** The array that contains each vertex in finish order. */
  private int[] finishOrder;

  /** The index that indicates the discovery order. */
  private int discoverIndex = 0;

  /** The index that indicates the finish order. */
  private int finishIndex = 0;

  /** Construct the depth-first search of a Graph
   starting at first vertex and visiting the start vertices in
   ascending order.
   @param graph The graph will be searched.
   */
  public DepthFirstSearch(AdjacencyListMatrix<E> graph) {
      this.graph = graph;
      int n = graph.getNumV();
      parent = new int[n];
      visited = new boolean[n];
      discoveryOrder = new int[n];
      finishOrder = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = -1;
      }
      for (int i = 0; i < n; i++) {
        if (!visited[i])
          depthFirstSearch(i);
      }
  }

  /** Recursively depth-first search the graph
   starting at vertex current.
   @param current The start vertex
   */
  public void depthFirstSearch(int current) {
    /* Mark the current vertex visited. */
    visited[current] = true;
    discoveryOrder[discoverIndex++] = current;
    /* Examine each vertex adjacent to the current vertex */
    Iterator < Edge<E> > itr = graph.edgeIterator(graph.vertex (current));
    while (itr.hasNext()) {
      E neighbor = itr.next().getDest();
      int neighborIndex = graph.vertexIndex (neighbor);
      /* Process a neighbor that has not been visited */
      if (!visited[neighborIndex]) {
        /* Insert (current, neighbor) into the depth-
           first search tree. */
        parent[neighborIndex] = current;
        /* Recursively apply the algorithm
           starting at neighbor. */
        depthFirstSearch(neighborIndex);
      }
    }
    /* Mark current finished. */
    finishOrder[finishIndex++] = current;
  }
  /** Get the finish order
   @return finish order
   */
  public int[] getFinishOrder() {
    return finishOrder;
  }

}
