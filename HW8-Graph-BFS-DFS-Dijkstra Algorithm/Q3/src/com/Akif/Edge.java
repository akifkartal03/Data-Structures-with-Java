package com.Akif;

/**
 * Edge Class for GraphADT.
 */
public class Edge {
    /**
     * The destination vertex for an edge.
     */
    private int dest;
    /**
     * The source vertex for an edge.
     */
    private int source;
    /** The weight */
    private double weight;
    /**
     * Constructs an Edge from source to dest. Sets the weight to 1.0
     * @param source source vertex for an edge
     * @param dest destination vertex for an edge
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
    /** Construct a weighted edge with a source
     of from and a destination of to. Set the
     weight to w.
     @param source - The source vertex
     @param dest - The destination vertex
     @param w - The weight
     */
    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        weight = w;
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
        Edge e = (Edge) o;
        return (source == e.source && dest == e.dest);
    }

    /**
     * Returns the destination vertex.
     * @return the destination vertex.
     */
    public int getDest() {
        return dest;
    }

    /**
     * Returns the source vertex
     * @return the source vertex
     */
    public int getSource() {
        return source;
    }

    public void setDest (int dest) {
        this.dest = dest;
    }

    public void setSource (int source) {
        this.source = source;
    }

    public double getWeight () {
        return weight;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }

    /**
     * Returns a string representation of the edge.
     * @return a string representation of the edge.
     */
    @Override
    public String toString () {
        return "Edge{" +
                "source=" + source +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
    /**
     * Returns the hash code for an edge. The hash code depends
     * on the source and destination.
     * @return the hash code for an edge.
     */
    @Override
    public int hashCode() {
        return source*31*31 + dest*31;
    }

}
