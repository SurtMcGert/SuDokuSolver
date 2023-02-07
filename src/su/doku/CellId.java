package su.doku;

//data structure to store the coordinates of the top right cell of a square
public class CellId {

    private int x;
    private int y;

    // constructor
    public CellId(int x, int y) {

        this.x = x;
        this.y = y;

    }

    /**
     * function to get the x coordinate of this cell
     * 
     * @return
     */
    public int getX() {

        return x;

    }

    /**
     * function to get the y coordinate of this cell
     * 
     * @return
     */
    public int getY() {

        return y;

    }
}
