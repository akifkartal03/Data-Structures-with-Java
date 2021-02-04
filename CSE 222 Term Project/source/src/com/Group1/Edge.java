package com.Group1;

/**
 * Edge Class for Extended GraphADT.
 * @param <E> Type of Edge.
 */
@SuppressWarnings ("unchecked")
public class Edge<E> {
    /**
     * The destination vertex for an edge.
     */
    private E dest;
    /**
     * The source vertex for an edge.
     */
    private E source;
    /**
     * Constructs an Edge from source to dest. Sets the weight to 1.0
     * @param source source vertex for an edge
     * @param dest destination vertex for an edge
     */
    public Edge(E source, E dest) {
        this.source = source;
        this.dest = dest;
    }

    /**
     *Compares two edges for equality. Edges are equal if their source
     * and destination vertices are the same. The weight is not considered
     * @param o the reference object with which to compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Edge)){
            return  false;
        }
        Edge<E> e = (Edge<E>) o;
        return (source == e.source && dest == e.dest);
    }

    /**
     * Returns the destination vertex.
     * @return the destination vertex.
     */
    public E getDest() {
        return dest;
    }

    /**
     * Returns the source vertex
     * @return the source vertex
     */
    public E getSource() {
        return source;
    }

    public void setDest (E dest) {
        this.dest = dest;
    }

    public void setSource (E source) {
        this.source = source;
    }

    /**
     * Returns a string representation of the edge.
     * @return a string representation of the edge.
     */
    @Override
    public String toString () {
        return source + ", " + dest;
    }

    /**
     * Returns the hash code for an edge. The hash code depends
     * on the source and destination.
     * @return the hash code for an edge.
     */
    @Override
    public int hashCode() {
        return source.hashCode ()*31*31 + dest.hashCode ()*31;
    }

}
