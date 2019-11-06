package Entity;
import java.io.Serializable;
/**
 * Cinema class represents an instance of the Cinema hall
 * @version 1
 * @since 17/10/2019
 */
public class Cinema implements Serializable{
    private int cinemaID;
    private int rows;
    private int column;
    private Cineplex cineplex;

    public Cinema(int cinemaID, int rows, int column, Cineplex cineplex) {
        this.cinemaID = cinemaID;
        this.rows = rows;
        this.column = column;
        this.cineplex = cineplex;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }
}


