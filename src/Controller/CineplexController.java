package Controller;

import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;
import java.util.Collections;

public class CineplexController implements ControllerInterface{
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;


    public CineplexController() {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
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

    public boolean addMovieToCineplex(int cineplexId, Movie movie){
        for(Cineplex cineplex: cineplexArrayList){
            if(cineplex.getCineplexID() == cineplexId){
                for(Movie movie1:cineplex.getMovieInCineplexArrayList()){
                    if(movie1.getMovieId() == movie.getMovieId()){
                        return false;
                    }
                }
                cineplex.getMovieInCineplexArrayList().add(movie);
                //sort cineplex arraylist
                updateDat();
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}