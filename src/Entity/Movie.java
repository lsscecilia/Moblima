package Entity;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Comparator;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class Movie implements Serializable{

    private static final long serialVersionUID = -5830846618847949096L;
    private int movieId;
    private String movieTitle;
    private String movieStatus;
    private String movieSynopsis;
    private String movieDirector;
    private String movieCast;
    private String movieRating;
    private String movieDuration;
    private String movieType;
    private ArrayList <Review> movieReviews;

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

    public Movie(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString(){
        return("movieId: " + movieId +
                " movieTitle: " + movieTitle);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public ArrayList<Review> getMovieReviews() {
        return movieReviews;
    }

    public void setMovieReviews(ArrayList<Review> movieReviews) {
        this.movieReviews = movieReviews;
    }

    public void addReview(Review review)
    {
        movieReviews.add(review);
    }
}
