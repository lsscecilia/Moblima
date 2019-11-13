package Controller;

import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;
import java.util.ArrayList;

/**
 *
 * @version 1.0
 * @since 2019-11-13
 */

public class CineplexController implements ControllerInterface{
    private HandlerInterface database;
    /**
     * contains all the cineplexes managed by this system
     */
    private ArrayList<Cineplex> cineplexArrayList;

    /**
     * As cineplex controller is created, date is retrieved from file i/o
     */
    public CineplexController() {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
    }

    /**
     * @return array list of all cineplexes
     */
    public ArrayList<Cineplex> getCineplexArrayList() {
        return cineplexArrayList;
    }

    /**
     * Displays all the movies showing in a cineplex
     * @param cineplexId
     */
    public void displayAllMoviesShowingInCineplex(int cineplexId){
        for(Cineplex cineplex:cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){
                for(Movie movie:cineplex.getMovieInCineplexArrayList()){
                    System.out.println(movie.getMovieId() + ".  " + movie.getMovieTitle());
                }
            }
        }
    }


    /**
     * Remove movie showing from Cineplex
     * @param movieID
     * @param cineplexId
     * @return true if movie is removed
     */
    public boolean removeMovieFromCineplex(int movieID, int cineplexId){
        for(Cineplex cineplex:cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){
                for(Movie movie:cineplex.getMovieInCineplexArrayList()){
                    if(movie.getMovieId() == movieID){
                        cineplex.getMovieInCineplexArrayList().remove(movie);
                        updateDat();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * displays all cinema in a particular cineplex base on cineplexId
     * @param cineplexId
     */
    public void displayCinema(int cineplexId){
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){
                for(Cinema cinema: cineplex.getCinemaArrayList()){
                    System.out.println("Cinema ID: " + cinema.getCinemaID());
                    System.out.println("Cinema Type: " + cinema.getCinemaType());
                    System.out.println("Cinema Capacity: " + (cinema.getRows() * cinema.getColumn()));
                    System.out.println("Rows: " + cinema.getRows() + " Columns: " + cinema.getColumn());
                    System.out.println("\n");
                }
            }
        }
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


    /**
     * View individual Cineplex based on the cineplexID
     * @param cineplexID
     */
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

    /**
     * Returns Cineplex Object from cineplexId
     * @param cineplexId
     * @return
     */
    public Cineplex returnCineplexFromId(int cineplexId){
        Cineplex returnCineplex = null;
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID()==cineplexId){
                returnCineplex = cineplex;
            }
        }
        return returnCineplex;
    }

    /**
     * Add Movie object to cineplex based on cineplexId
     * @param cineplexId
     * @param movie
     * @return true if addition is successful
     */
    public boolean addMovieToCineplex(int cineplexId, Movie movie){
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){ //if cinplex is what we want
                for(Movie movie1:cineplex.getMovieInCineplexArrayList()){ //check if the movie already exist
                    if(movie1.getMovieId() == movie.getMovieId()){
                        return false;
                    }
                }
                cineplex.getMovieInCineplexArrayList().add(movie);
                updateDat();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all the Cineplex in an arraylist based on whether it is showing this particular Movie
     * @param movieId
     * @return
     */
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
                    updateDat();
                    break;
                }

            }

        }
        return newCineplexArray;
    }

    /**
     * get CineplexId from it's index
     * @param cineplexArrayList
     * @param index
     * @return
     */
    public int getCineplexId(ArrayList<Cineplex> cineplexArrayList, int index)
    {
        return cineplexArrayList.get(index).getCineplexID();
    }


    public boolean cineplexExistChecker(ArrayList<Cineplex> cineplexArrayList)
    {
        return cineplexArrayList.isEmpty();
    }

    /**
     * update file i/o with current data for cineplex
     */
    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}