package Controller;

import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.spi.AbstractResourceBundleProvider;

public class CineplexController implements ControllerInterface{
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;


    public CineplexController() {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
    }

    public ArrayList<Cineplex> getCineplexArrayList() {
        return cineplexArrayList;
    }

    /**
     * Displays all the Cineplex Information
     */
    public void displayAllCineplexInfo(){
        if(cineplexArrayList != null){
            try{
                for(Cineplex cineplex : cineplexArrayList){
                    System.out.println(cineplexArrayList.indexOf(cineplex)+1 + ".  " + cineplex.getCineplexName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("There isn't any Cineplex :(");
        }
    }



    public void viewCineplex(int cineplexID){
        if(cineplexArrayList!= null){
            for(Cineplex cineplex:cineplexArrayList){
                if(cineplex.getCineplexID() == cineplexID){
                    System.out.println("Cineplex ID: " + cineplex.getCineplexID());
                    System.out.println("Cineplex Name: " + cineplex.getCineplexName());
                    System.out.println("Cineplex location: " + cineplex.getLocation() + "\n");
                    System.out.println("Movie showing in " + cineplex.getCineplexName() + ": ");
                    for(Movie movie: cineplex.getMovieInCineplexArrayList()){
                        System.out.println("Movie ID: " + movie.getMovieId() + " Movie Title: " + movie.getMovieTitle());
                    }
                    System.out.println("\n" + "Cinema Halls: ");
                    System.out.println("==============");
                    for(Cinema cinema: cineplex.getCinemaArrayList()){
                        System.out.println("Cinema Hall: " + cinema.getCinemaID());
                        System.out.println("Cinema Size: ");
                        System.out.println("Number of Rows: " + cinema.getRows());
                        System.out.println("Number of Columns: " + cinema.getColumn() + "\n");
                    }
                }
            }
        }
    }

    public Cineplex returnCineplexFromId(int cineplexId){
        Cineplex returnCineplex = null;
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID()==cineplexId){
                return cineplex;
            }
        }
        return returnCineplex;
    }

    public boolean addMovieToCineplex(int cineplexId, Movie movie){
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){ //if cinplex is what we want
                for(Movie movie1:cineplex.getMovieInCineplexArrayList()){ //check if the movie already exist
                    if(movie1.getMovieId() == movie.getMovieId()){
                        return false;
                    }
                }
                cineplex.getMovieInCineplexArrayList().add(movie); //means movie doesn't exist in this cineplexId
                for(Movie movie1:cineplex.getMovieInCineplexArrayList()){
                    System.out.println(movie1.getMovieTitle());
                }
                //need to implement sort cineplex arraylist
                //updateDat();
                // DONT TURN ^^ updateDat ON CAUSE it will write to file then need to keep adding new movie to test
                // just test on adding movie 5.
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cineplex> cineplexShowingMovie(int movieId)
    {
        ArrayList<Movie> movieArrayList;
        ArrayList<Cineplex> newCineplexArray = new ArrayList<>();
        for (Cineplex cineplex: cineplexArrayList)
        {
            movieArrayList = cineplex.getMovieInCineplexArrayList();
            for (Movie movie: movieArrayList)
            {
                if (movie.getMovieId()==movieId)
                {
                    newCineplexArray.add(cineplex);
                    break;
                }

            }

        }
        return newCineplexArray;
    }


    public int getCineplexId(ArrayList<Cineplex> cineplexArrayList, int index)
    {
        return cineplexArrayList.get(index).getCineplexID();
    }

    public boolean cineplexExistChecker(ArrayList<Cineplex> cineplexArrayList)
    {
        return cineplexArrayList.isEmpty();
    }

    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}