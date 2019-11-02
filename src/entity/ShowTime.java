package entity;
import java.io.Serializable;

import java.util.Arrays;

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
