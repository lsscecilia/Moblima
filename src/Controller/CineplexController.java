package Controller;

import Entity.Cineplex;
import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

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

    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}