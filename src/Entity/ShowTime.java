package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 */
public class ShowTime implements Serializable{
    private Cineplex cineplex;
    private Movie movie;
    private int cinemaID;
    private String date; // yyyy-MM-dd
    private int time;
    private int[][] seatLayout;

    public ShowTime(Cineplex cineplex, Movie movie, int cinemaID, String date, int time, int[][] seatLayout) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.cinemaID = cinemaID;
        this.date = date;
        this.time = time;
        this.seatLayout = seatLayout;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int[][] getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(int[][] seatLayout) {
        this.seatLayout = seatLayout;
    }
}
