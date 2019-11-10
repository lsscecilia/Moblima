package Controller;

import Entity.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CustomerDisplayController implements ControllerInterface{

    public CustomerDisplayController() {
    }

    //is there anything to update for the this class?
    @Override
    public void updateDat() {

    }

    public void displayTicket(ArrayList<Ticket> ticketArrayList)
    {
        int count =1;
        System.out.println("Movie: " + ticketArrayList.get(0).getShowTime().getMovie().getMovieTitle());
        System.out.println("Number of tickets: " + ticketArrayList.size());
        System.out.println("Date: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalDate().toString());
        System.out.println("start time: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalTime().toString());
        for (Ticket ticket: ticketArrayList)
        {
            System.out.println("Ticket " + count +".  Ticket Type: " + ticket.getCustomerClass() + ", Seat: "+
                    ticket.getSeat() + ", Price: " + ticket.getPrice() );
            count++;
        }
    }

    public void displaySeatLayout(int[][] array, int row, int column)
    {
        String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print(" ");
        for (int i=1; i<column+1;i++)
        {
            System.out.print("|"+ i + "|");
        }

        System.out.println();
        for (int i=0; i<row;i++)
        {
            for (int j=0;j<column;j++)
            {
                System.out.print(" __ ");
            }
            System.out.println();
            System.out.print(letters.charAt(i));
            for (int j=0;j<column;j++)
            {
                System.out.print("|");
                if (array[i][j]==1)
                    System.out.print("X");
                else
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
        for (int j=0;j<column;j++)
        {
            System.out.println(" __ ");
        }
    }

    //sorted in terms of date and time
    public void displayShowTime(ArrayList<ShowTime> showTimeArrayList)
    {
        int count = 1;
        LocalDateTime dateTime = LocalDateTime.of(0,1,1,0,0);
        for (ShowTime showTime: showTimeArrayList)
        {
            if (dateTime.toLocalDate().compareTo(showTime.getDateTime().toLocalDate())!=0)
            {
                System.out.print("Date: " + showTime.getDateTime().toLocalDate().toString());
                dateTime = showTime.getDateTime();
                System.out.println(";   Showtimes: ");
            }

            System.out.print(count +". ");
            System.out.println(showTime.getDateTime().toLocalTime().toString());
            count++;
        }
    }


    public void displayCineplex(ArrayList<Cineplex> cineplexArrayList)
    {
        int count =1;
        for (Cineplex cineplex: cineplexArrayList)
        {
            System.out.print(count +". ");
            System.out.println(cineplex.getCineplexName());
            count++;
        }
        System.out.println();
    }

    public void displayCineplexInformation(ArrayList<Cineplex> cineplexArrayList, int index)
    {
        Cineplex cineplex = cineplexArrayList.get(index);
        System.out.println("======================" + cineplex.getCineplexName()+"=========================");
        System.out.println("Location: " + cineplex.getLocation());
        System.out.println();
    }

    public void displayMovieTitle(ArrayList<Movie> movieArrayList)
    {
        int count=1;
        for (Movie m: movieArrayList)
        {
            //if (m.getMovieStatus().compareTo("Preview")==0)

            System.out.print(count+". ");
            System.out.println(m.getMovieTitle());
            count++;
        }
        System.out.println();
    }

    //index here is the array index, so should be count-1
    public void movieInformation(ArrayList<Movie> movieArrayList, int index)
    {

        Movie movie = movieArrayList.get(index);
        System.out.println("======================" + movie.getMovieTitle() +"=========================");
        System.out.println("Showing status: "+ movie.getMovieStatus());
        System.out.println("Synopsis: "+movie.getMovieSynopsis());
        System.out.println("Director: " + movie.getMovieDirector());
        System.out.print("Cast :");
        Arrays.stream(movie.getMovieCast().split(",")).forEach(cast -> System.out.print(cast +" "));
        System.out.println();
        System.out.println("Movie type: " + movie.getMovieType());
        System.out.println("Movie ratings: " + movie.getMovieRating());
        System.out.println("Reviewer rating: " + MovieController.getOverallRatings(movie));
        System.out.println("Reviews: ");
        displayReview(movie.getMovieReviews());
        System.out.println();
    }

    public void displayReview(ArrayList<Review> reviewArrayList)
    {
        int count=1;
        for (Review review: reviewArrayList)
        {
            System.out.print(count+". ");
            System.out.println(review.getMovieGoerReview());
            count++;
        }
    }


}
