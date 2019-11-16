package Controller;

import Entity.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Controls all display of objects or segment of object. Objects or segment of objects will be printed in a readable format
 * @version 1.0
 * @since 2019-11-13
 */

class CustomerDisplayController {

    /**
     * This creates the display controller.
     */
    CustomerDisplayController() {
    }

    /**
     * Displays Tickets details
     * @param ticketArrayList
     */
    void displayTicket(ArrayList<Ticket> ticketArrayList) {
        int count = 1;
        System.out.println("Movie: " + ticketArrayList.get(0).getShowTime().getMovie().getMovieTitle());
        System.out.println("Movie type: " + ticketArrayList.get(0).getShowTime().getMovie().getMovieType());
        for (Cinema cinema: ticketArrayList.get(0).getShowTime().getCineplex().getCinemaArrayList())
        {
            if (cinema.getCinemaID()==ticketArrayList.get(0).getShowTime().getCinemaID())
            {
                System.out.println("Cinema type: " + cinema.getCinemaType());
            }
        }
        System.out.println("Number of tickets: " + ticketArrayList.size());
        System.out.println("Date: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalDate().toString());
        System.out.println("start time: " + ticketArrayList.get(0).getShowTime().getDateTime().toLocalTime().toString());
        for (Ticket ticket : ticketArrayList) {
            System.out.println("Ticket " + count + ".  Ticket Type: " + ticket.getCustomerClass() + ", Seat: " +
                    ticket.getSeat() + ", Price: " + ticket.getPrice());
            count++;
        }
    }

    /**
     * Displays Seat Layout of cinema
     * @param array
     * @param row
     * @param column
     */
    void displaySeatLayout(int[][] array, int row, int column) {
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        String ANSI_RESET = "\u001B[0m";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int half = column/2;
        System.out.print("  ");
        System.out.println("-------------------------SCREEN-------------------------");
        for (int i = 1; i < column + 1; i++) {
            if (i==half+1)
            {
                System.out.print("|    |");
            }
            if (i%2==0)
                System.out.print(" " + i + "  ");
            else
                System.out.print("  " + i + "  ");
        }

        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(" ");
            }
            System.out.println();
            System.out.print(letters.charAt(i));
            for (int j = 0; j < column; j++) {
                if (j==half)
                    System.out.print("|    |");
                if (array[i][j] == 1)
                    System.out.print(" " + ANSI_RED_BACKGROUND + "☒" +  ANSI_RESET + "  ");
                else if (array[i][j]==5)
                {
                    System.out.print(" " +ANSI_YELLOW_BACKGROUND + "☒" + ANSI_RESET+ "  ");
                }
                else
                    System.out.print(" " + ANSI_BLUE_BACKGROUND + "☐" +ANSI_RESET+ "  " );
            }
            System.out.println();
        }

        System.out.println("-----------------------Entrance------------------------");
        System.out.println();
        System.out.println("LEGEND: ");
        System.out.println("seat available: " + ANSI_BLUE_BACKGROUND + "☐" +ANSI_RESET );
        System.out.println("seat taken: " + ANSI_RED_BACKGROUND + "☒" +  ANSI_RESET);
        System.out.println("|    | represents the walk way");
        System.out.println("--------------------------------------------");
    }

    /**
     * Displays ShowTime that is sorted by date and time
     * @param showTimeArrayList
     */
    void displayShowTime(ArrayList<ShowTime> showTimeArrayList) {
        int count = 1;
        LocalDateTime dateTime = LocalDateTime.of(0, 1, 1, 0, 0);
        for (ShowTime showTime : showTimeArrayList) {
            if (dateTime.toLocalDate().compareTo(showTime.getDateTime().toLocalDate()) != 0) {
                System.out.println("Date: " + showTime.getDateTime().toLocalDate().toString());
                dateTime = showTime.getDateTime();
            }

            System.out.print(count + ". ");
            System.out.print(showTime.getDateTime().toLocalTime().toString());
            for (Cinema cinema : showTime.getCineplex().getCinemaArrayList()) {
                if (showTime.getCinemaID() == cinema.getCinemaID()) {
                    System.out.print(", Cinema Type: " + cinema.getCinemaType());
                    System.out.println(", Movie Type: " + showTime.getMovie().getMovieType());
                }
            }
            count++;

        }
    }


    /**
     * Displays top 5 Movie with the highest ratings.
     * @param movieRatingHashMap
     */
    void displayTop5Rating(HashMap<Movie, Double> movieRatingHashMap)
    {
        int count = 1;
        for (Movie movie: movieRatingHashMap.keySet())
        {
            if (movieRatingHashMap.get(movie)==null)
            {
                continue;
            }
            if (count==6)
                break;
            System.out.println(count+". " + movie.getMovieTitle() + ", Ratings: " + movieRatingHashMap.get(movie));
            count++;
        }
    }

    /**
     * Displays top 5 Movie with the highest ticket sales.
     * @param movieTicketSaleHashMap
     */
    void displayTop5TicketSale(HashMap<Movie, Integer> movieTicketSaleHashMap)
    {
        int count = 1;
        if (movieTicketSaleHashMap.isEmpty())
        {
            System.out.println("Sorry, there are no ticket sales yet");
            return;
        }
        for (Movie movie: movieTicketSaleHashMap.keySet())
        {
            if (count==6)
                break;
            System.out.println(count+". " + movie.getMovieTitle() + ", Ticket Sales: " + movieTicketSaleHashMap.get(movie));
            count++;
        }
    }

    /**
     * Displays booking history
     * @param transactions
     */
    void displayBookingHistory(ArrayList<Transaction> transactions)
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

    /**
     * Displays all the Movie titles from user's booking history
     * @param transactions
     */
    void displayMovieTitleBookingHistory(ArrayList<Transaction> transactions)
    {
        int count=1;
        for (Transaction transaction:transactions)
        {
            System.out.println(count + ". " + transaction.getTicketArrayList().get(0).getShowTime().getMovie().getMovieTitle());
            count++;
        }
    }

    /**
     * Display Cineplex
     * @param cineplexArrayList
     */
    void displayCineplex(ArrayList<Cineplex> cineplexArrayList) {
        int count = 1;
        for (Cineplex cineplex : cineplexArrayList) {
            System.out.print(count + ". ");
            System.out.println(cineplex.getCineplexName());
            count++;
        }
        System.out.println();
    }

    /**
     * Display individual Cineplex information
     * @param cineplexArrayList
     * @param index
     */
    void displayCineplexInformation(ArrayList<Cineplex> cineplexArrayList, int index) {
        Cineplex cineplex = cineplexArrayList.get(index);
        System.out.println("======================" + cineplex.getCineplexName() + "=========================");
        System.out.println("Location: " + cineplex.getLocation());
        System.out.println();
    }

    /**
     * Display Movie Titles
     * @param movieArrayList
     */
    void displayMovieTitle(ArrayList<Movie> movieArrayList) {
        int count = 1;
        for (Movie m : movieArrayList) {
            System.out.print(count + ". ");
            System.out.println(m.getMovieTitle());
            count++;
        }
        System.out.println();
    }

    /**
     * Display information of a movie
     * @param movieArrayList
     * @param index
     */
    void displayMovieInformation(ArrayList<Movie> movieArrayList, int index) {

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

    /**
     * Display all reviews from a particular movie
     * @param reviewArrayList
     */
    private void displayReview(ArrayList<Review> reviewArrayList) {
        int count = 1;
        for (Review review : reviewArrayList) {
            System.out.print(count + ". ");
            System.out.println(review.getMovieGoerReview());
            count++;

        }
    }
}
