package Entity;

import java.io.Serializable;

/**
 * @version 1
 * @since 2019-11-13
 * @typeofclass entity
 */
public class Review implements Serializable {
    /**
     * review comments for this review
     */
    private String movieGoerReview;
    /**
     * review ratings for this review
     */
    private int rating;

    /**
     * creates review base on review comments
     * @param movieGoerReview
     * @param rating
     */
    public Review(String movieGoerReview, int rating) {
        this.movieGoerReview = movieGoerReview;
        this.rating = rating;
    }

    /**
     * get review for this review
     * @return
     */
    public String getMovieGoerReview() {
        return movieGoerReview;
    }

    /**
     * get rating for this review
     * @return
     */
    public int getRating() {
        return rating;
    }

    @Override
    public String toString(){
        return ("Rating: " + rating + "\n" +
                " MovieGoerReview: " + movieGoerReview + "\n");
    }
}
