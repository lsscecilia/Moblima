package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 */
public class ShowTime implements Serializable{
    private Movie movie;
    private Cinema cinema;
    private String date; // yyyy-MM-dd
    private int time;
    private int[][] seatLayout;

}
