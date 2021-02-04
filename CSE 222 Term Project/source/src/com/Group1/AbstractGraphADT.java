package com.Group1;
/**
 * Abstract base class for graphs. A graph is a set of vertices and
 *  a set of edges. Vertices are Generic Type E.
 * @param <E> Vertices type in a graph.
 */
public abstract class AbstractGraphADT<E> implements GraphADT<E> {

    /** The number of vertices */
    protected int numV;
    /** Flag to indicate whether this is a directed graph */
    protected final boolean directed;
    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     * @param numV The number of vertices
     * @param directed The directed flag
     */
    public AbstractGraphADT(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }
    /**
     * Return the number of vertices.
     * @return The number of vertices
     */
    @Override
    public int getNumV() {
        return numV;
    }

    /**
     * Return whether this is a directed graph.
     * @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {
        return directed;
    }
}
