package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 */
public class ShowTime implements Serializable{
    private Movie movie;
    private Cinema cinema;
    private String date; // yyyy-MM-dd
    private int time;
    private int[][] seatLayout;

    public ShowTime(Movie movie, Cinema cinema, String date, int time, int[][] seatLayout) {
        this.movie = movie;
        this.cinema = cinema;
        this.date = date;
        this.time = time;
        this.seatLayout = seatLayout;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
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
