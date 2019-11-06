package Entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cineplex represents a collection of Cinema class, or cinema hall
 * @version 1
 * @since 17/10/2019
 */
public class Cineplex implements Serializable {
    private int cineplexID;
    private String cineplexName;
    private String location;
    private ArrayList<Cinema> cinemaArrayList;
    private ArrayList<Integer> moviesArrayList;

    public Cineplex(int cineplexID, String cineplexName, String location, ArrayList<Cinema> cinemaArrayList, ArrayList<Integer> moviesArrayList) {
        this.cineplexID = cineplexID;
        this.cineplexName = cineplexName;
        this.location = location;
        this.cinemaArrayList = cinemaArrayList;
        this.moviesArrayList = moviesArrayList;
    }

    public int getCineplexID() {
        return cineplexID;
    }

    public void setCineplexID(int cineplexID) {
        this.cineplexID = cineplexID;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Cinema> getCinemaArrayList() {
        return cinemaArrayList;
    }

    public void setCinemaArrayList(ArrayList<Cinema> cinemaArrayList) {
        this.cinemaArrayList = cinemaArrayList;
    }

    public ArrayList<Integer> getMoviesArrayList() {
        return moviesArrayList;
    }

    public void setMoviesArrayList(ArrayList<Integer> moviesArrayList) {
        this.moviesArrayList = moviesArrayList;
    }
}
