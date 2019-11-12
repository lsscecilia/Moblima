package Controller;

import Entity.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class CustomerDisplayController implements ControllerInterface {

    public CustomerDisplayController() {
    }

    //is there anything to update for the this class?
    @Override
    public void updateDat() {

    }

    public void displayCinemaType(String[] cinemaType) {
        for (int i = 1; i < cinemaType.length; i++) {
            System.out.println(i + ". " + cinemaType[i - 1]);
        }
    }

    public void displayTicket(ArrayList<Ticket> ticketArrayList) {
        int count = 1;
        System.out.println("Movie: " + ticketArrayList.get(0).getShowTime().getMovie().getMovieTitle());
        System.out.println("Number of tickets: " + ticketArrayList.size());
        System.out.println("Date: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalDate().toString());
        System.out.println("start time: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalTime().toString());
        for (Ticket ticket : ticketArrayList) {
            System.out.println("Ticket " + count + ".  Ticket Type: " + ticket.getCustomerClass() + ", Seat: " +
                    ticket.getSeat() + ", Price: " + ticket.getPrice());
            count++;
        }
    }

    public void displaySeatLayout(int[][] array, int row, int column) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print(" ");
        for (int i = 1; i < column + 1; i++) {
            System.out.print("|" + i + "|");
        }

        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" __ ");
            }
            System.out.println();
            System.out.print(letters.charAt(i));
            for (int j = 0; j < column; j++) {
                System.out.print("|");
                if (array[i][j] == 1)
                    System.out.print("X");
                else
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
        for (int j = 0; j < column; j++) {
            System.out.println(" __ ");
        }
    }

    //sorted in terms of date and time
    public void displayShowTime(ArrayList<ShowTime> showTimeArrayList) {
        int count = 1;
        LocalDateTime dateTime = LocalDateTime.of(0, 1, 1, 0, 0);
        for (ShowTime showTime : showTimeArrayList) {
            if (dateTime.toLocalDate().compareTo(showTime.getDateTime().toLocalDate()) != 0) {
                System.out.print("Date: " + showTime.getDateTime().toLocalDate().toString());
                dateTime = showTime.getDateTime();
                System.out.println(";   Showtimes: ");
            }

            System.out.print(count + ". ");
            System.out.print(showTime.getDateTime().toLocalTime().toString());
            for (Cinema cinema : showTime.getCineplex().getCinemaArrayList()) {
                if (showTime.getCinemaID() == cinema.getCinemaID()) {
                    System.out.println(", Cinema Type: " + cinema.getCinemaType());
                }

            }
            count++;
        }
    }



    public void displayTop5Rating(HashMap<Movie, Double> top5)
    {
        int count = 1;
        for (Movie movie: top5.keySet())
        {
            if (top5.get(movie)==null)
            {
                continue;
            }
            if (count==6)
                break;
            System.out.println(count+". " + movie.getMovieTitle() + ", Ratings: " + top5.get(movie));
            count++;
        }
    }

    public void displayTop5TicketSale(HashMap<Movie, Integer> top5)
    {
        int count = 1;
        if (top5.isEmpty())
        {
            System.out.println("Sorry, there are no ticket sales yet");
            return;
        }
        for (Movie movie: top5.keySet())
        {
            if (count==6)
                break;
            System.out.println(count+". " + movie.getMovieTitle() + ", Ticket Sales: " + top5.get(movie));
            count++;
        }
    }

    public void displayBookingHistory(ArrayList<Transaction> transactions)
    {
        int count=1;
        System.out.println("Phone Number: " + transactions.get(0).getMobileNumber());
        System.out.println("Name: " + transactions.get(0).getNamePurchaser());
        System.out.println("Email: " + transactions.get(0).getEmailAddress());
        for (Transaction transaction:transactions)
        {
            System.out.println(count + ". ");
            System.out.println("TID: " + transaction.getTID());
            System.out.println("Movie name: " + transaction.getTicketArrayList().get(0).getShowTime().getMovie().getMovieTitle());
            System.out.println("Show time: " + transaction.getTicketArrayList().get(0).getShowTime().getDateTime().toString());
            System.out.println("Cineplex: " + transaction.getTicketArrayList().get(0).getShowTime().getCineplex().getCineplexName());
            System.out.println("Cinema number: " + transaction.getTicketArrayList().get(0).getShowTime().getCinemaID());
            System.out.println("Number of tickets brought: " + transaction.getTicketArrayList().size());
            for (Ticket ticket: transaction.getTicketArrayList())
            {
                System.out.println("Seat number for ticket "+count+ ": " + ticket.getSeat());
            }
            System.out.println("Total price: " + transaction.getTotalPrice());
            count++;
        }
    }

    public void displayMovieTitleBookingHistory(ArrayList<Transaction> transactions)
    {
        int count=1;
        for (Transaction transaction:transactions)
        {
            System.out.println(count + ". " + transaction.getTicketArrayList().get(0).getShowTime().getMovie().getMovieTitle());
            count++;
        }
    }

    public void displayCineplex(ArrayList<Cineplex> cineplexArrayList) {
        int count = 1;
        for (Cineplex cineplex : cineplexArrayList) {
            System.out.print(count + ". ");
            System.out.println(cineplex.getCineplexName());
            count++;
        }
        System.out.println();
    }

    public void displayCineplexInformation(ArrayList<Cineplex> cineplexArrayList, int index) {
        Cineplex cineplex = cineplexArrayList.get(index);
        System.out.println("======================" + cineplex.getCineplexName() + "=========================");
        System.out.println("Location: " + cineplex.getLocation());
        System.out.println();
    }

    public void displayMovieTitle(ArrayList<Movie> movieArrayList) {
        int count = 1;
        for (Movie m : movieArrayList) {
            //if (m.getMovieStatus().compareTo("Preview")==0)

            System.out.print(count + ". ");
            System.out.println(m.getMovieTitle());
            count++;
        }
        System.out.println();
    }

    //index here is the array index, so should be count-1
    public void movieInformation(ArrayList<Movie> movieArrayList, int index) {

        Movie movie = movieArrayList.get(index);
        System.out.println("======================" + movie.getMovieTitle() + "=========================");
        System.out.println("Showing status: " + movie.getMovieStatus());
        System.out.println("Synopsis: " + MovieController.wordWrap(movie.getMovieSynopsis()));
        System.out.println("Director: " + movie.getMovieDirector());
        System.out.print("Cast :");
        Arrays.stream(movie.getMovieCast().split(",")).forEach(cast -> System.out.print(cast + " "));
        System.out.println();
        System.out.println("Movie type: " + movie.getMovieType());
        System.out.println("Movie ratings: " + movie.getMovieRating());
        System.out.println("Reviewer rating: " + MovieController.getOverallRatings(movie));
        System.out.println("Reviews: ");
        displayReview(movie.getMovieReviews());
        System.out.println();
    }

    public void displayReview(ArrayList<Review> reviewArrayList) {
        int count = 1;
        for (Review review : reviewArrayList) {
            System.out.print(count + ". ");
            System.out.println(review.getMovieGoerReview());
            count++;

        }


    }
}
