package Controller;

import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class MovieController {
    private HandlerInterface database;
    private ArrayList<Movie> movieArrayList;
    //the movie here represent all the movie in moblima, each cineplex hav full/subset of it

    public MovieController()
    {
        database = new DataHandler();
        movieArrayList = database.readSerializedObject("movie.dat");

    }
}
