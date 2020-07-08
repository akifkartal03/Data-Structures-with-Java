package com.Akif;

/**
 * Class to keep 2D point.
 */
public class Point2D {
    /**
     * x coordinate of point
     */
    private int x;
    /**
     * y coordinate of point
     */
    private int y;

    /**
     * Constructor to initialize the point.
     * @param x x coordinate of point
     * @param y y coordinate of point
     */
    public Point2D (int x, int y) {
        this.x = x;
        this.y = y;
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
}
