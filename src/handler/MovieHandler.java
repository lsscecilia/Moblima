package handler;

import entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieHandler extends DataHandler {
    private ArrayList<Movie> movieArrayList;

    public MovieHandler() {
        this.movieArrayList = readSerializedObject();
    }

    public ArrayList readSerializedObject() {
        return (ArrayList) super.readSerializedObject("Movie.dat");
    }

    public void writeSerializedObject(List list) {
        super.writeSerializedObject("Movie.dat", list);
    }

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }
}
