package Entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version 1
 * @since 17/10/2019
 */
public class ShowTime implements Serializable, Comparable<ShowTime>{
    private Cineplex cineplex;
    private Movie movie;
    private int cinemaID;
    private int column;
    private int row;
    private LocalDateTime dateTime;
    private int[][] seatLayout;
    private static final long  serialVersionUID = 4399209438434125145L;

    public ShowTime(Cineplex cineplex, Movie movie, int cinemaID, int column, int row, LocalDateTime dateTime, int[][] seatLayout) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.cinemaID = cinemaID;
        this.column = column;
        this.row = row;
        this.dateTime = dateTime;
        this.seatLayout = seatLayout;
    }

    public ShowTime(ShowTime showTime)
    {
        this.cineplex = showTime.cineplex;
        this.movie = showTime.movie;
        this.cinemaID = showTime.cinemaID;
        this.dateTime = showTime.dateTime;
        this.column = showTime.column;
        this.row = showTime.row;
        this.seatLayout = new int[showTime.row][showTime.column];
        for (int i=0; i<showTime.row;i++)
        {
            System.arraycopy(showTime.seatLayout[i], 0, this.seatLayout[i], 0,seatLayout[i].length);
        }

    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int[][] getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(int[][] seatLayout) {
        this.seatLayout = seatLayout;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void seatOccupied(int row, int column)
    {
        seatLayout[row][column] = 1;
    }

    public void seatOccupiedDraft(int row, int column)
    {
        seatLayout[row][column] = 5;
    }

    @Override
    public int compareTo(ShowTime o) {
        if (getDateTime() == null || o.getDateTime() == null)
            return  0;
        return getDateTime().compareTo(o.getDateTime());
    }

}
