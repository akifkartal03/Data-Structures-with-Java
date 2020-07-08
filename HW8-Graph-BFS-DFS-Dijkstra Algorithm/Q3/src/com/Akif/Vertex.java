package com.Akif;

/**
 * Class to keep Junction square information as a vertex.
 */
public class Vertex {
    /**
     * x coordinate of vertex
     */
    private int x;
    /**
     * y coordinate of vertex
     */
    private int y;
    /**
     * vertex number(name)
     */
    private int id;//vertex number

    /**
     * Constructor to initialize the vertex.
     * @param x x coordinate of vertex
     * @param y y coordinate of vertex
     * @param id vertex number(name)
     */
    public Vertex (int x, int y,int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    //getter-setter
    public int getX () {
        return x;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getY () {
        return y;
    }

    public void setY (int y) {
        this.y = y;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
    @Override
    public String toString () {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                '}';
    }
}
