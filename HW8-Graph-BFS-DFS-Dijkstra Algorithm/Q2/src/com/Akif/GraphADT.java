package com.Akif;

import java.util.Iterator;

/** Extended Version of Graph Interface. A graph is a set of vertices and
 a set of edges. Vertices are Generic Type. Edges are ordered pairs of vertices.
 Each implementation of the Graph interface should
 provide a constructor that specifies the number of
 vertices and whether or not the graph is directed.
 */
public interface GraphADT<E> {
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
    void insert(Edge<E> edge);

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    boolean isEdge(E source, E dest);

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or null if there is no edge
     */
    Edge<E> getEdge(E source, E dest);

    /** Return an iterator to the edges connected
     to a given vertex.
     @param source The source vertex
     @return An Iterator to the vertices
     connected to source
     */
    Iterator< Edge<E> > edgeIterator(E source);

    /*---------Extended part----------------------------*/

    /**
     * Deletes an individual edge.
     * @param edge an edge will be removed, if it is present.
     */
    void delete(Edge<E> edge);

    /**
     * Inserts an individual vertex.
     * @param vertex a vertex will be added if it is not present.
     */
    void insertVertex(E vertex);

    /**
     * Deletes an individual vertex.
     * Check Report for more information.
     * @param vertex a vertex will be removed, if it is present.
     */
    void deleteVertex(E vertex);

    /**
     * Performs Breadth-first search of the graph by starting given vertex.
     * @param startVertex start vertex of search
     * @return The array of parents.
     */
    E[] bfs(E startVertex);

    /**
     * Performs Depth-first search of the graph by starting first vertex of the graph.
     * @return Finish order of search.
     */
    E[] dfs();
}
