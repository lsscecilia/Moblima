package Controller;
import java.util.*;
import Entity.Movie;
import Entity.Review;
import Handler.DataHandler;
import Handler.HandlerInterface;

import static java.util.stream.Collectors.toMap;

/**
 *
 * @version 1.0
 * @since 2019-11-13
 */
public class MovieController implements ControllerInterface{
    private HandlerInterface database;
    /**
     * arraylist of entire movie collection in the database
     */
    private ArrayList<Movie> movieArrayList;

    /**
     * As movieController is created, data is retrieved from file i/o
     */
    public MovieController()
    {
        database = new DataHandler();
        movieArrayList = database.readSerializedObject("movie");
    }
    /**
     * format string into a readable paragraph
     * @param a
     * @return formatted string
     */
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

    /**
     * @param movie
     * @return overall ratings for a particular movie
     */

    public static double getOverallRatings(Movie movie){
        return calculateOverallRatings(movie.getMovieReviews());
    }

    /**
     * calculate overall ratings from all ratings given by all moviegoer who reviewed a particular movie
     * @param reviewArrayList
     * @return overall ratings
     */
    private static double calculateOverallRatings(ArrayList<Review> reviewArrayList){
        int total=0;
        int count=0;
        for (Review review: reviewArrayList)
        {
            total += review.getRating();
            count++;
        }
        return (double) total/count;
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
     * print Movie Id and Title
     */
    public void printMovieIdAndTitle(){
        for(Movie movie: movieArrayList){
            System.out.println("Movie ID: " + movie.getMovieId() +
                               " | Movie Title: " + movie.getMovieTitle() +
                               " | " + movie.getMovieType());
        }
    }

    /**
     * returns Movie Object based on movie ID
     * @param movieId
     * @return Movie
     */
    public Movie returnMovieFromId(int movieId){
        Movie movieReturn = null;
        for(Movie movie: movieArrayList){
            if(movie.getMovieId() == movieId){
                movieReturn = movie;
                break;
            }
        }
        return movieReturn;
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
     * get all the movies
     * @return arraylist of entire movie collection
     */
    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    /**
     * get all movies with unique titles
     * @return arraylist of movies that have unique title
     */
    public ArrayList<Movie> getMovieArrayListWithoutDuplicate() {
        ArrayList<Movie> movies = new ArrayList<>();
        boolean flag=true;
        for (Movie movie: movieArrayList)
        {
            flag = true;
            if (!movies.isEmpty())
            {
                for (Movie m1: movies)
                {
                   if(m1.compareTo(movie)==0)
                   {
                       flag = false;
                       break;
                   }
                }
            }
            if (flag)
                movies.add(movie);
        }
        return movies;
    }

    /**
     * filter out movies that are not available for booking as for now
     * @return arraylist of movies that are available for booking
     */
    public ArrayList<Movie> getMovieArrayListAvalBooking(){
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (Movie movie: movieArrayList)
        {
            if (movie.getMovieStatus().compareTo("Coming Soon")!=0)
            {
                newMovies.add(movie);
            }
        }
        return newMovies;
    }

    /**
     * insert new review for a particular movie into the database
     * @param movieId
     * @param comment
     * @param ratings
     */
    public void insertReview(int movieId, String comment, int ratings)
    {
        ArrayList<Review> reviewArrayList;
        for (Movie movie: movieArrayList)
        {
            if (movie.getMovieId()==movieId)
            {
                movie.addReview(new Review(comment, ratings));
            }
        }
        updateDat();
    }

    /**
     * get overall ratings for each movie and sort them in descending order
     * @return hashmap where its key = movie and value = overall ratings, and sorted in descending order
     */
    public HashMap<Movie, Double> top5ByRatings()
    {
        HashMap<Movie, Double> ratings = new HashMap<>();
        for (Movie movie: movieArrayList)
        {
            ratings.put(movie, getOverallRatings(movie));
        }
        HashMap<Movie, Double> sorted = ratings
                .entrySet()
                .stream()
                .filter(d ->  ! Double.isNaN(d.getValue()))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));


        return sorted;
    }

    /**
     * search movie in entire movie collections
     * @param search
     * @return arraylist of movies that fulfill the search
     */
    public ArrayList<Movie> searchMovie(String search)
    {
        ArrayList<Movie> searchArrayList = new ArrayList<>();
        for (Movie movie: movieArrayList)
        {
            if (movie.getMovieTitle().toLowerCase().contains(search.toLowerCase()))
            {
                searchArrayList.add(movie);
            }
        }
        return searchArrayList;
    }

    /**
     * @param movieArrayList
     * @return true if arraylist is empty
     */
    public boolean noResultFound(ArrayList<Movie> movieArrayList)
    {
        if (movieArrayList.isEmpty())
        {
            System.out.println("No results found");
            return true;
        }
        return false;
    }

    /**
     * get movieId base on the index where the movie is found in the arraylist
     * @param movieArrayList
     * @param index
     * @return movieId
     */
    public int getMovieId(ArrayList<Movie> movieArrayList, int index)
    {
        return movieArrayList.get(index).getMovieId();
    }

    /**
     * update file i/o with current data for movies
     */
    @Override
    public void updateDat() {
        database.writeSerializedObject("Movie", movieArrayList);
    }




}
