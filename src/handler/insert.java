package handler;

import entity.Movie;
import entity.Review;

import java.util.ArrayList;
import java.util.List;

public class insert {
    public static void main(String[] args)
    {
        ArrayList reviewArrayList = new ArrayList();
        List movieArrayList = new ArrayList();
        MovieHandler movieHandler = new MovieHandler();


        Review review = new Review("Very good movie", 4);
        Review review1 = new Review("good movie", 3);
        Review review2 = new Review("average movie", 3);
        reviewArrayList.add(review);
        reviewArrayList.add(review1);
        reviewArrayList.add(review2);

        Movie movie = new Movie(11,"Ah Boys To Men 4","Now Showing","Singapore's most successful movie franchise is back" +
                "! After leaving the military Wayang King	Sergeant Ong	and Ken Chow are all busy with their " +
                "respective career as civilians. That's until they are called back to serve the nation again under the " +
                "Singapore Armed Forces' Armoured Formation. Now they must juggle between work and their reservist duties." +
                " What hilarious situations will happen as they train together and their military roles are reversed? " +
                "There'll be new enemy threats and their brotherhood will be put to the test." , "Jack Neo" ,
                "Josh Zhang	Noah Yap Joshua Tan	Maxi Lim", "PG13", 4.0, "133min","2D", reviewArrayList);

        //movieArrayList = movieHandler.readSerializedObject();
        //movieArrayList.add(movie);
        //movieHandler.writeSerializedObject(movieArrayList);
    }
}
    /*private int movieId;
    private String movieTitle;
    private String movieStatus;
    private String movieSynopsis;
    private String movieDirector;
    private String movieCast;
    private String movieRating;
    private double overallMovieRating;
    private String movieDuration;
    private String movieType;
    private ArrayList <Review> movieReviews;*/