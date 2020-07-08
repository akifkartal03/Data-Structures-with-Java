package com.Akif;
import java.util.*;
import java.io.*;

/**
 * A ListGraph implementation from book.
 */
@SuppressWarnings("unchecked")
public class ListGraph extends AbstractGraphADT {

  /** An array of Lists to contain the edges that
      originate with each vertex. */
  private List <Edge> [] edges;

  /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
   */
  public ListGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new List[numV];
    for (int i = 0; i < numV; i++) {
      edges[i] = new LinkedList < Edge > ();
    }
  }

  /** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
  public boolean isEdge(int source, int dest) {
    return edges[source].contains(new Edge(source, dest));
  }

  /** Insert a new edge into the graph.
      @param edge The new edge
   */
  public void insert(Edge edge) {
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
      edges[edge.getDest()].add(new Edge(edge.getDest(),
                                         edge.getSource(),
                                         edge.getWeight()));
    }
  }

  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(int source, int dest) {
    Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; // Desired edge found, return it.
    }
    return null;
  }

  @Override
  public String toString () {
    StringBuilder stringBuilder = new StringBuilder ();
    for (int i = 0; i <numV ; i++) {
        Iterator<Edge> iter = edgeIterator (i);
        while (iter.hasNext ()){
          stringBuilder.append (iter.next ()+"\n");
        }
    }
    return stringBuilder.toString ();
  }
}
