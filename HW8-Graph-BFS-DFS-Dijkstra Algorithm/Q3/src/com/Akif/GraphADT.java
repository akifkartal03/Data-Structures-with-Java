package com.Akif;

import java.util.Iterator;

/** Graph Interface. A graph is a set of vertices and
 a set of edges. Vertices are Generic Type. Edges are ordered pairs of vertices.
 Each implementation of the Graph interface should
 provide a constructor that specifies the number of
 vertices and whether or not the graph is directed.
 */
public interface GraphADT {
    /** Return the number of vertices.
     @return The number of vertices
     */
    int getNumV();

    /** Determine whether this is a directed graph.
     @return true if this is a directed graph
     */
    boolean isDirected();

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    void insert(Edge edge);

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    boolean isEdge(int source, int dest);

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or null if there is no edge
     */
    Edge getEdge(int source, int dest);

    /** Return an iterator to the edges connected
     to a given vertex.
     @param source The source vertex
     @return An Iterator to the vertices
     connected to source
     */
    Iterator<Edge> edgeIterator(int source);
}
