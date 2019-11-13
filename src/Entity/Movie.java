package Entity;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Comparator;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class Movie implements Serializable, Comparable<Movie>{

    /**
     * unique id is used to represent a Movie
     */
    private int movieId;

    /**
     * title of this movie
     */
    private String movieTitle;

    /**
     * showing status of this movie (eg. "Now Showing", "Preview", "Coming Soon", "End of showing")
     */
    private String movieStatus;

    /**
     * synopsis of this movie
     */
    private String movieSynopsis;

    /**
     * director of this movie
     */
    private String movieDirector;

    /**
     * actors for this movie
     */
    private String movieCast;

    /**
     * ratings for this movie (eg. pg13, nc16, r21 - according to America's film rating system)
     */
    private String movieRating;

    /**
     * duration of this movie
     */
    private String movieDuration;

    /**
     * type of this movie (eg. 2D, 3D)
     */
    private String movieType;

    /**
     * array list of reviews by moviegoer for this movie
     */
    private ArrayList <Review> movieReviews;

    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = -5830846618847949096L;

    /**
     * Creates movie with given movieId, title, status, synopsis, director ,cast, ratings, duration, type, array list of reviews
     * @param movieId
     * @param movieTitle
     * @param movieStatus
     * @param movieSynopsis
     * @param movieDirector
     * @param movieCast
     * @param movieRating
     * @param movieDuration
     * @param movieType
     * @param movieReviews
     */
    public Movie(int movieId, String movieTitle, String movieStatus, String movieSynopsis, String movieDirector, String movieCast, String movieRating
            , String movieDuration, String movieType, ArrayList<Review> movieReviews) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.movieRating = movieRating;
        this.movieDuration = movieDuration;
        this.movieType = movieType;
        this.movieReviews = movieReviews;
    }

    /**
     * creates movie with given movieId
     * @param movieId
     */
    public Movie(int movieId) {
        this.movieId = movieId;
    }

    /**
     * get movieId for this movie
     * @return movieId for this movie
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Change movieId for this movie
     * @param movieId
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * get title for this movie
     * @return title for this movie
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Change title of this movie
     * @param movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * get status of this movie
     * @return status of this movie
     */
    public String getMovieStatus() {
        return movieStatus;
    }

    /**
     * Change status of this movie
     * @param movieStatus
     */
    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    /**
     * get synopsis of this movie
     * @return synopsis of this movie
     */
    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    /**
     * Change synopsis of this movie
     * @param movieSynopsis
     */
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    /**
     * get director of this movie
     * @return director of this movie
     */
    public String getMovieDirector() {
        return movieDirector;
    }

    /**
     * Change director of this movie
     * @param movieDirector
     */
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    /**
     * get cast of this movie
     * @return cast of this movie
     */
    public String getMovieCast() {
        return movieCast;
    }

    /**
     * Change cast of this movie
     * @param movieCast
     */
    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    /**
     * get rating of this movie
     * @return ratings of this movie
     */
    public String getMovieRating() {
        return movieRating;
    }

    /**
     * Change rating of this movie
     * @param movieRating
     */
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    /**
     * get duration of movie
     * @return duration of movie
     */
    public String getMovieDuration() {
        return movieDuration;
    }

    /**
     * Change duration of movie
     * @param movieDuration
     */
    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    /**
     * get type of this movie
     * @return type of this movie
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * Change type of this movie
     * @param movieType
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * get array list of reviews for this movie
     * @return array list of reviews for this movie
     * @see Review
     */
    public ArrayList<Review> getMovieReviews() {
        return movieReviews;
    }

    /**
     * Change array list of reviews for this movie
     * @param movieReviews
     * @see Review
     */
    public void setMovieReviews(ArrayList<Review> movieReviews) {
        this.movieReviews = movieReviews;
    }

    /**
     * add review to array list of reviews
     * @param review
     * @see Review
     */
    public void addReview(Review review)
    {
        movieReviews.add(review);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return("movieId: " + movieId +
                " movieTitle: " + movieTitle);
    }

    /**
     * compare this movie to that movie base on the titles of the movies
     * @param movie
     * @return integer, if this movie's title = that movie's title return 0, if this movie's title > that movie's title, return positive integer, if this movie's title < that movie's title, return positive integer
     */
    @Override
    public int compareTo(Movie movie) {
        return movieTitle.compareTo(movie.getMovieTitle());
    }
}
