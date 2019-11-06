package Controller;

import Entity.Movie;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieController implements ControllerInterface{
    private HandlerInterface database;
    private ArrayList<Movie> movieArrayList;
    //the movie here represent all the movie in moblima, each cineplex hav full/subset of it

    public static String wordWrap(String a) {
        StringBuilder sb = new StringBuilder(a);

        int i = 0;
        int x = 100;
        while (i + 100 < sb.length() && (i = sb.lastIndexOf(" ", i + x)) != -1) {
            sb.replace(i, i + 1, "\n                ");
            x = 115;
        }

        return sb.toString();
    }
    public MovieController()
    {
        database = new DataHandler();
        movieArrayList = database.readSerializedObject("movie");
    }

    /**
     * Checks whether the addition of new Movie details is successful
     * @param movie
     * @return boolean
     */
    public boolean addNewMovie(Movie movie){
        if(movie != null){
            movieArrayList.add(movie);
            updateDat();
            return true;
        }
        return false;
    }

    /**
     * Checks whether the removal of Movie using MovieId is successful
     * @param movieId
     * @return boolean
     */
    public boolean removeMovieById(int movieId){
        for(Movie movie: movieArrayList){
            if(movie.getMovieId() == movieId){
                movieArrayList.remove(movie);
                updateDat();
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether movieArrayList is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return movieArrayList.isEmpty();
    }

    /**
     * View all movie in MovieArrayList
     */
    public void viewAllMovie(){
        for(Movie movie: movieArrayList){
            System.out.println("Movie ID: " + movie.getMovieId());
            System.out.println("Movie Title: " + movie.getMovieTitle());
            System.out.println("Movie Status: " + movie.getMovieStatus());
            System.out.println("Movie Synopsis: " + wordWrap(movie.getMovieSynopsis()));
            System.out.println("Movie Director: " + movie.getMovieDirector());
            System.out.print("Movie Cast: "); Arrays.stream(movie.getMovieCast().split(",")).forEach(cast -> System.out.print(cast +" "));
            System.out.println("\n" + "Movie Rating: " + movie.getMovieRating());
            System.out.println("Movie Duration: " + movie.getMovieDuration());
            System.out.println("Movie Type: " + movie.getMovieType());
            System.out.println("\n");
        }
    }

    /**
     * Print the details of the movie based on MovieId and chosenIndex!
     * @param chosenMovieId
     * @param chosenIndex
     */
    public void printIndex(int chosenMovieId, int chosenIndex) {
        for(Movie movie: movieArrayList){
            if(movie.getMovieId() == chosenMovieId){
                switch(chosenIndex){
                    case 1:
                        System.out.println("Movie ID: " + movie.getMovieId());
                        break;
                    case 2:
                        System.out.println("Movie Title: " + movie.getMovieTitle());
                        break;
                    case 3:
                        System.out.println("Movie Status: " + movie.getMovieStatus());
                        break;
                    case 4:
                        System.out.println("Movie Synopsis: " + wordWrap(movie.getMovieSynopsis()));
                        break;
                    case 5:
                        System.out.println("Movie Director: " + movie.getMovieDirector());
                        break;
                    case 6:
                        System.out.print("Movie Cast: "); Arrays.stream(movie.getMovieCast().split(",")).forEach(cast -> System.out.print(cast +" "));
                        break;
                    case 7:
                        System.out.println("Movie Rating: " + movie.getMovieRating());
                        break;
                    case 8:
                        System.out.println("Movie Duration: " + movie.getMovieDuration());
                        break;
                    case 9:
                        System.out.println("Movie Type: " + movie.getMovieType());
                        break;
                    default:
                        System.out.println("An error has occurred :(");
                }
            }
        }
    }

    /**
     * Updates Existing Movie Details
     * @param chosenMovieId
     * @param chosenIndex
     * @param changedString
     */
    public void updateExistingMovieDetail(int chosenMovieId, int chosenIndex, String changedString) {
        for(Movie movie: movieArrayList){
            if(movie.getMovieId() == chosenMovieId){
                switch(chosenIndex){
                    case 1:
                        movie.setMovieId(Integer.parseInt(changedString));
                        break;
                    case 2:
                        movie.setMovieTitle(changedString);
                        break;
                    case 3:
                        movie.setMovieStatus(changedString);
                        break;
                    case 4:
                        movie.setMovieSynopsis(changedString);
                        break;
                    case 5:
                        movie.setMovieDirector(changedString);
                        break;
                    case 6:
                        movie.setMovieCast(changedString);
                        break;
                    case 7:
                        movie.setMovieRating(changedString);
                        break;
                    case 8:
                        movie.setMovieDuration(changedString);
                        break;
                    case 9:
                        movie.setMovieType(changedString);
                        break;
                    default:
                        System.out.println("An error has occurred :(");
                }
            }
        }
        updateDat();
    }

    /**
     * updates file where we store data for movieArrayList
     */
    @Override
    public void updateDat() {
        database.writeSerializedObject("Movie", movieArrayList);
    }


}
