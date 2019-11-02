package entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cineplex represents a collection of Cinema class, or cinema hall
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
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

}
