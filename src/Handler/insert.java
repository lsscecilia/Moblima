package Handler;

import Entity.*;

import java.util.ArrayList;
import java.util.List;

public class insert {
    public static void main(String[] args)
    {

/*
        ArrayList reviewArrayList = new ArrayList();
        ArrayList<Movie> movieArrayList = new ArrayList();

        Review review = new Review("Very good movie", 5);
        Review review1 = new Review("Decent movie", 3);
        Review review2 = new Review("Bad movie", 1);
        reviewArrayList.add(review);
        reviewArrayList.add(review1);
        reviewArrayList.add(review2);

        Movie movie = new Movie(1,"Ah Boys To Men 4","Now Showing","Singapore's most successful movie franchise is back" +
                "! After leaving the military Wayang King Sergeant Ong and Ken Chow are all busy with their " +
                "respective career as civilians. That's until they are called back to serve the nation again under the " +
                "Singapore Armed Forces' Armoured Formation. Now they must juggle between work and their reservist duties." +
                " What hilarious situations will happen as they train together and their military roles are reversed? " +
                "There'll be new enemy threats and their brotherhood will be put to the test." , "Jack Neo" ,
                "Josh Zhang,Noah Yap,Joshua Tan,Maxi Lim", "PG13", "133min","2D", reviewArrayList);



        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList = database.readSerializedObject("Movie");
        for(Movie movie: movieArrayList){
            System.out.println(movie.toString());
        }









    movieArrayList.add(movie);
       //movieArrayList = database.readSerializedObject("Movie");

        database.writeSerializedObject("Movie", movieArrayList);




 */


/**
 *     private int cineplexID;
 *     private String cineplexName;
 *     private String location;
 *     private ArrayList<Cinema> cinemaArrayList;
 *     private ArrayList<Movie> movieInCineplexArrayList;
 *
 *    private int cinemaID;
 *     private int rows;
 *     private int column;
 */

        Cinema cinema1 = new Cinema(1,10,10);


        HandlerInterface database = new DataHandler();

        ArrayList<Cineplex> cineplexArrayList = new ArrayList<>();

        ArrayList<Cinema> cinemaArrayList = database.readSerializedObject("Movie");

        ArrayList<Movie> movieArrayList = database.readSerializedObject("Movie");

    }
}
