package Entity;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Cineplex represents a collection of Cinema class, or cinema hall
 * @version 1
 * @since 2019-11-13
 */
public class Cineplex implements Serializable {
    /**
     * unique id is used to represent a cineplex
     */
    private int cineplexID;
    /**
     * name of this cineplex
     */
    private String cineplexName;
    /**
     * location of this cineplex
     */
    private String location;
    /**
     * array list of cinemas in this cineplex
     */
    private ArrayList<Cinema> cinemaArrayList;
    /**
     * array list of movies showing in this cineplex
     */
    private ArrayList<Movie> movieInCineplexArrayList;

    /**
     * Creates cineplex with given cineplexID, name of cineplex, location of cineplex, array list of cinemas in this
     * cineplex, and array list of movies in this cineplex
     * @param cineplexID
     * @param cineplexName
     * @param location
     * @param cinemaArrayList
     * @param movieInCineplexArrayList
     */
    public Cineplex(int cineplexID, String cineplexName, String location,
                    ArrayList<Cinema> cinemaArrayList, ArrayList<Movie> movieInCineplexArrayList) {
        this.cineplexID = cineplexID;
        this.cineplexName = cineplexName;
        this.location = location;
        this.cinemaArrayList = cinemaArrayList;
        this.movieInCineplexArrayList = movieInCineplexArrayList;
    }

    /**
     * gets cineplexID of this cineplex
     * @return cineplexID
     */
    public int getCineplexID() {
        return cineplexID;
    }

    /**
     * Change cineplexID of this cineplex
     * @param cineplexID
     */
    public void setCineplexID(int cineplexID) {
        this.cineplexID = cineplexID;
    }

    /**
     * get name of this cineplex
     * @return name of this cineplex
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Change cineplex name of this cineplex
     * @param cineplexName
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * get location of this cineplex
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * change location of this cineplex
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get array list of cinemas in this cineplex
     * @return array list of cinemas in this cineplex
     * @see Cinema
     */
    public ArrayList<Cinema> getCinemaArrayList() {
        return cinemaArrayList;
    }

    /**
     * Change array list of cinemas in this cineplex
     * @param cinemaArrayList
     * @see Cinema
     */
    public void setCinemaArrayList(ArrayList<Cinema> cinemaArrayList) {
        this.cinemaArrayList = cinemaArrayList;
    }

    /**
     * get array list of movies in this cineplex
     * @return array list of movies in this cineplex
     * @see Movie
     */
    public ArrayList<Movie> getMovieInCineplexArrayList() {
        return movieInCineplexArrayList;
    }


    /**
     * Change array list of movies in this cineplex
     * @param movieInCineplexArrayList
     * @see Movie
     */
    public void setMovieInCineplexArrayList(ArrayList<Movie> movieInCineplexArrayList) {
        this.movieInCineplexArrayList = movieInCineplexArrayList;
    }

}
