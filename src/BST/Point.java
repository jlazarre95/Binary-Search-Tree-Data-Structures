package BST;

/**
 * A class to represent a Point object with x and y coordinates.
 */
public class Point {

    private int x;                          //x-coordinate
    private int y;                          //y-coordinate

    /**
     * A constructor for a Point object
     * @param x x-coordinate of point
     * @param y y-coordinate of point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x-coordinate of a Point object
     * @return x-coordinate of point
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets x-coordinate of a Point object
     * @return x-coordinate of point
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Outputs the x and y coordinates of a Point object as a String object
     * @return x and y coordinates in the following format: (x,y)
     */
    @Override
    public String toString(){
    return "(" + this.x + ", " + this.y + ") ";
    }
    
    /**
     * Returns a value of true or false depending on whether the x-coordinate 
     * of THIS point is greater than p's or not
     * @param p point to be compared
     * @return true if the x-coordinate of THIS point is greater than p's
     * or false otherwise
     */
    public boolean xIsGreaterThan(Point p){
    return this.x > p.x;
    }
    
    /**
     * Returns a value of true or false depending on whether the y-coordinate 
     * of THIS point is greater than p's or not
     * @param p point to be compared
     * @return true if the y-coordinate of THIS point is greater than p's
     * or false otherwise
     */
    public boolean yIsGreaterThan(Point p){
    return this.y > p.y;
    }
    
    /**
     * Returns a value of true or false depending on whether the x AND y
     * coordinates of THIS point equal those of p's or not
     * @param o object to be compared
     * @return true if the x AND y coordinates of THIS point are equal to those
     * of p's or false otherwise
     */
    @Override
    public boolean equals(Object o){
    if (!(o instanceof Point)){
    throw new RuntimeException();
    }
    Point p = (Point)o;
    return this.x == p.x && this.y == p.y;   

}
}