package Entity;
import java.io.Serializable;
/**
 * Cinema class represents an instance of the Cinema hall
 * @version 1
 * @since 2019-11-13
 */
public class Cinema implements Serializable{
    /**
     * unique id is used to represent a cinema
     */
    private int cinemaID;
    /**
     * number of rows in the cinema
     */
    private int rows;
    /**
     * number of columns in the cinema
     */
    private int column;
    /**
     * type of cinema
     */
    private String cinemaType;
    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = -4383393423269014123L;

    /**
     * Creates cinema with given cinemaID, number of rows, number of column and type of cinema
     * @param cinemaID
     * @param rows
     * @param column
     * @param cinemaType
     */
    public Cinema(int cinemaID, int rows, int column, String cinemaType) {
        this.cinemaID = cinemaID;
        this.rows = rows;
        this.column = column;
        this.cinemaType = cinemaType;
    }

    /**
     * get cinemaID of this cinema
     * @return this cinema's cinemaID
     */
    public int getCinemaID() {
        return cinemaID;
    }

    /**
     * Changes the cinemaID of this cinema
     * This may involve a lengthy legal process
     * @param cinemaID
     */
    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    /**
     * get number of rows that this cinema has
     * @return this cinema's number of row
     */
    public int getRows() {
        return rows;
    }

    /**
     * Changes the number of rows of this cinema
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * get number of columns that this cinema has
     * @return this cinema's number of columns
     */
    public int getColumn() {
        return column;
    }

    /**
     * Changes the number of column of this cinema
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * get type of cinema of this cinema
     * @return
     */
    public String getCinemaType() {
        return cinemaType;
    }

    /**
     * changes cinema type of this cinema
     * @param cinemaType
     */
    public void setCinemaType(String cinemaType) {
        this.cinemaType = cinemaType;
    }
}


