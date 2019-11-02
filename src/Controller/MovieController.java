package Controller;

import entity.Movie;
import handler.DataHandler;
import handler.HandlerInterface;

import java.util.ArrayList;

public class MovieController {
    private HandlerInterface handlerInterface;
    private ArrayList<Movie> movieArrayList;
    //the movie here represent all the movie in moblima, each cineplex hav full/subset of it

    public MovieController()
    {
        handlerInterface = new DataHandler();
        movieArrayList = (ArrayList<Movie>) handlerInterface.readSerializedObject("movie.dat");
    }
}
