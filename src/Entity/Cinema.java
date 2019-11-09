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
    private String cinemaType;

    public Cinema(int cinemaID, int rows, int column, String cinemaType) {
        this.cinemaID = cinemaID;
        this.rows = rows;
        this.column = column;
        this.cinemaType = cinemaType;
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

    public String getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(String cinemaType) {
        this.cinemaType = cinemaType;
    }
}


