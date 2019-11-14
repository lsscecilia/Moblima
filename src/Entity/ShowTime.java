package Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1
 * @since 2019-11-13
 * @typeofclass entity
 */
public class ShowTime implements Serializable, Comparable<ShowTime>{
    /**
     * cineplex that this show time takes place
     * @see Cineplex
     */
    private Cineplex cineplex;
    /**
     * movie that this show time is screening
     * @see Cineplex
     */
    private Movie movie;
    /**
     * cinemaID of the cinema that this show time takes places
     * @see Cinema
     */
    private int cinemaID;
    /**
     * number of columns of the cinema that this show time takes places
     */
    private int column;
    /**
     * number of rows of the cinema that this show time takes places
     */
    private int row;
    /**
     * date and time of this show time
     * @see LocalDateTime
     */
    private LocalDateTime dateTime;
    /**
     * seat layout of this show time
     */
    private int[][] seatLayout;
    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long  serialVersionUID = 4399209438434125145L;

    /**
     * creates show time with given cineplex, movie, cinemaID, column, row, date and time and seat layout
     * @param cineplex
     * @param movie
     * @param cinemaID
     * @param column
     * @param row
     * @param dateTime
     * @param seatLayout
     */
    public ShowTime(Cineplex cineplex, Movie movie, int cinemaID, int column, int row, LocalDateTime dateTime, int[][] seatLayout) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.cinemaID = cinemaID;
        this.column = column;
        this.row = row;
        this.dateTime = dateTime;
        this.seatLayout = seatLayout;
    }

    /**
     * creates show time with given show time
     * to duplicate show time object
     * @param showTime
     */
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

    /**
     * get cineplex of this show time
     * @return cineplex of this show time
     */
    public Cineplex getCineplex() {
        return cineplex;
    }

    /**
     * get movie of this movie
     * @return movie of this movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Change movie for this show time
     * @param movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * get cinemaID for this showtime
     * @return cinemaID for this showtime
     */
    public int getCinemaID() {
        return cinemaID;
    }

    /**
     * get date and time for this show time
     * @return date and time for this show time
     * @see LocalDateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Change date time for this show time
     * @param dateTime
     * @see LocalDateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * get seat layout for this show time
     * @return seat layout for this show time
     */
    public int[][] getSeatLayout() {
        return seatLayout;
    }

    /**
     * get column for this show time
     * @return column for this show time
     */
    public int getColumn() {
        return column;
    }

    /**
     * get row for this show time
     * @return row for this show time
     */
    public int getRow() {
        return row;
    }

    /**
     * Change status of seat from unoccupied to occupied
     * @param row
     * @param column
     */
    public void seatOccupied(int row, int column)
    {
        seatLayout[row][column] = 1;
    }

    /**
     * Change status of seat from unoccupied to occupied for a draft layout
     * @param row
     * @param column
     */
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
