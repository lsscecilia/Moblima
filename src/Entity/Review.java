package Entity;


import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class Review implements Serializable {
    private String movieGoerReview;
    private int rating;


    public Review(String movieGoerReview, int rating) {
        this.movieGoerReview = movieGoerReview;
        this.rating = rating;
    }

    @Override
    public String toString(){
        return ("Rating: " + String.valueOf(rating) + "\n" +
                " MovieGoerReview: " + movieGoerReview + "\n");
    }
    public String getMovieGoerReview() {
        return movieGoerReview;
    }

    public void setMovieGoerReview(String movieGoerReview) {
        this.movieGoerReview = movieGoerReview;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
