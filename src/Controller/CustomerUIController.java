package Controller;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main control class to dedicate job to other control classes
 * @version 1.0
 * @since 2019-11-13
 */

public class CustomerUIController {

    private CustomerDisplayController customerDisplayController;
    private MovieController movieController;
    private CineplexController cineplexController;
    private ShowTimeController showTimeController;
    private BookingController bookingController;
    private TransactionController transactionController;
    private ReviewController reviewController;

    /**
     * CustomerUIController initialise the different controllers that it need to dedicate job to
     */
    public CustomerUIController() {
        customerDisplayController = new CustomerDisplayController();
        movieController = new MovieController();
        cineplexController = new CineplexController();
        showTimeController = new ShowTimeController();
        bookingController = new BookingController();
        transactionController = new TransactionController();
        reviewController = new ReviewController();
    }

    /**
     * print out all movies
     */
    public void showMovieList()
    {
        customerDisplayController.displayMovieTitle(movieController.getMovieArrayListWithoutDuplicate());
    }

    /**
     * retrieve array list of movies that are available for booking and print out movies that are available for booking
     * @return array list of movies that are available for booking
     */
    public ArrayList<Movie> showMovieListAvalBooking()
    {
        ArrayList<Movie> movieAvalBookingArrayList = movieController.getMovieArrayListAvalBooking();
        customerDisplayController.displayMovieTitle(movieAvalBookingArrayList );
        return movieAvalBookingArrayList ;
    }


    /**
     * get movieId base on its index in the array list
     * @param movieArrayList
     * @param index
     * @return movieId
     */

    public int getMovieId(ArrayList<Movie> movieArrayList, int index)
    {
        return movieController.getMovieId(movieArrayList, index);
    }

    /**
     * retrieve array list of Cineplexes that shows a particular movie base on it's movieId and print it
     * @param movieId
     * @return arraylist of Cinplex
     */
    public ArrayList<Cineplex> showCineplexAval(int movieId)
    {
        ArrayList<Cineplex> cineplexAvalBookingArrayList = cineplexController.cineplexShowingMovie(movieId);
       customerDisplayController.displayCineplex(cineplexAvalBookingArrayList ); //get cineplex that show movie and display
        return cineplexAvalBookingArrayList;
    }

    /**
     * get cineplexId base on its index in the array list
     * @param cineplexArrayList
     * @param index
     * @return cineplexId
     */
    public int getCineplexId(ArrayList<Cineplex> cineplexArrayList, int index)
    {
        return cineplexController.getCineplexId(cineplexArrayList, index);
    }

    /**
     * retrieve showTime available for a particular movie and particular cineplex
     * @param movieId
     * @param cineplexId
     * @return arraylist of available ShowTimes
     */
    public ArrayList<ShowTime> showShowTime(int movieId, int cineplexId)
    {
        ArrayList<ShowTime> showTimeAvalBookingArrayList;
        showTimeAvalBookingArrayList = showTimeController.getShowTimeAval(movieId, cineplexId);
        customerDisplayController.displayShowTime(showTimeAvalBookingArrayList);
        return showTimeAvalBookingArrayList;
    }

    /**
     * get ShowTime base on its index in the arraylist
     * @param showTimeArrayList
     * @param index
     * @return ShowTime
     */

    public ShowTime getShowTime(ArrayList<ShowTime> showTimeArrayList, int index)
    {
        return showTimeController.getShowTime(showTimeArrayList, index);
    }

    /**
     * Prints seating layout of the cinema where the movie is screened
     * @param showTime
     */
    public void showLayout(ShowTime showTime)
    {
        customerDisplayController.displaySeatLayout(showTime.getSeatLayout(), showTime.getRow(),showTime.getColumn());
    }

    /**
     * check if special price for student and senior citizen are applicable
     * @param showTime
     * @return true if special price is applicable, else return false
     */
    public boolean studentSeniorCitizenCheck(ShowTime showTime)
    {
        return bookingController.studentSeniorCitizenCheck(showTime);
    }

    /**
     * Check if there are duplicated seats selected by moviegoer
     * @param seatSelected
     * @return true if there is no duplicated seats, else return false
     */
    public boolean checkNoDuplicateSeat(String[] seatSelected)
    {
        return bookingController.checkNoDuplicateSeat(seatSelected);
    }

    /**
     * Check if user leaves a single unoccupied seat between selected seats
     * @param seatSelected
     * @param showTime
     * @param numSeats
     * @return true if the seats selected does not violate this rule, else return false
     */
    public boolean checkSingleSeat(String[] seatSelected, ShowTime showTime, int numSeats)
    {
        ShowTime showTimeDraft = bookingController.draftLayout(seatSelected, showTime, numSeats);
        boolean result = bookingController.checkSingleSeat(seatSelected, showTimeDraft, numSeats);
        if (result)
            customerDisplayController.displaySeatLayout(showTimeDraft.getSeatLayout(), showTimeDraft.getRow(), showTimeDraft.getColumn());
        return result;
    }


    /**
     * retrieve the number of empty in the cinema for a particular showtime
     * @param showTime
     * @return number of empty in the cinema for a particular showtime
     */
    public int numAvalSeats(ShowTime showTime)
    {
        return bookingController.numAvalSeats(showTime);
    }

    /**
     * Checks if a particular seat is available for a particular showtime
     * @param showTime
     * @param row
     * @param column
     * @return true if seat is available, else return false
     */

    public boolean checkSeatAval(ShowTime showTime, char row, int column)
    {
        return showTimeController.checkSeatAvailable(showTime, row, column);
    }

    /**
     * Generate tickets for a booking
     * @param showTime
     * @param numTickets
     * @param numStudent
     * @param numSC
     * @param seatSelected
     * @return arraylist of tickets
     */
    //ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    public ArrayList<Ticket> generateTicket(ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    {
        ArrayList<Ticket> ticketArrayList = bookingController.newTicketArrayList(showTime ,numTickets, numStudent, numSC, seatSelected);
        customerDisplayController.displayTicket(ticketArrayList);
        return ticketArrayList;
    }

    /**
     * Calculate total Price of all the tickets in a booking
     * @param ticketArrayList
     * @return total price
     */
    public double calculateTotalPrice(ArrayList<Ticket> ticketArrayList)
    {
        return bookingController.calculateTotalPrice(ticketArrayList);
    }

    /**
     * update database on a successful transaction and update seat availability after tickets are brought
     * @param name
     * @param mobileNum
     * @param email
     * @param totalPrice
     * @param ticketArrayList
     * @param seatSelected
     */
    public void updateSuccessfulPayment(String name, long mobileNum, String email, double totalPrice,
                                        ArrayList<Ticket> ticketArrayList, String[] seatSelected)
    {
        transactionController.addTransaction(name, mobileNum, email, totalPrice, ticketArrayList);
        showTimeController.updateSeatAvailability(ticketArrayList.get(0).getShowTime(),seatSelected, ticketArrayList.size());
    }

    /**
     * print movie information base on the index of the movie in the arraylist that is in movieController
     * @param index
     */
    //overload
    public void showMovieInformation(int index)
    {
        customerDisplayController.movieInformation(movieController.getMovieArrayList(), index);
    }

    /**
     * print movie information base on the index of movie of the movieArrayList
     * @param movieArrayList
     * @param index
     */
    public void showMovieInformation(ArrayList<Movie> movieArrayList,int index)
    {
        customerDisplayController.movieInformation(movieArrayList, index);
    }

    /**
     * retrieve movies and its respective ratings from a hash map and print 5 highest rated movies
     */
    public void showTop5MovieByRatings()
    {
        HashMap<Movie, Double> top5 = movieController.top5ByRatings();
        customerDisplayController.displayTop5Rating(top5);
    }

    /**
     * retrieve movies and its respective ticket sales from a hash map and print 5 movie that have highest ticket sales
     */
    public void showTop5MovieByTicketSales()
    {
        HashMap<Movie,Integer> top5 = transactionController.top5ByTicketSales();
        customerDisplayController.displayTop5TicketSale(top5);
    }

    /**
     * print all cineplexes
     */
    public void showCineplexList()
    {
        customerDisplayController.displayCineplex(cineplexController.getCineplexArrayList());
    }

    /**
     * print information about a particular cineplex
     * @param index
     */
    public void showCineplexInformation(int index)
    {
        customerDisplayController.displayCineplexInformation(cineplexController.getCineplexArrayList(), index);
    }

    /**
     * search movie and prints out movies that match the search
     * @param search
     * @return array list of movies that match the search
     */
    public ArrayList<Movie> showSearchMovieResult(String search)
    {
        ArrayList<Movie> searchArrayList = movieController.searchMovie(search);
        customerDisplayController.displayMovieTitle(searchArrayList);
        return searchArrayList;
    }

    /**
     * Check if movieArrayList is empty
     * @param movieArrayList
     * @return true if movieArrayList is empty
     */
    public boolean noResultFound(ArrayList<Movie> movieArrayList)
    {
        return movieController.noResultFound(movieArrayList);
    }

    /**
     * retrieve booking history of a moviegoer base on his number and print booking history
     * @param number
     * @return arraylist of transactions that belong to a particular moviegoer base on his number
     */
    public ArrayList<Transaction> showBookingHistory(long number)
    {
        ArrayList<Transaction> transactionArrayList =transactionController.findBookingHistory(number);
        if (transactionController.bookingHistoryExist(transactionArrayList))
            customerDisplayController.displayBookingHistory(transactionArrayList);
        else
            System.out.println("Sorry, no transactions can be found.");
        return transactionArrayList;
    }

    /**
     * retrieve movies that a particular moviegoer is have watched
     * @param num
     * @return array list of a transaction that belong to a particular moviegoer base on his number
     */

    public ArrayList<Transaction> retrieveMovieToReview(long num)
    {
        ArrayList<Transaction> transactionArrayList =transactionController.findBookingHistory(num);
        if (transactionController.bookingHistoryExist(transactionArrayList))
            customerDisplayController.displayMovieTitleBookingHistory(transactionArrayList);
        else
            System.out.println("Sorry, no transactions can be found.");
        return transactionArrayList;
    }

    /**
     * Check if movie goer have already did review(s) - number of reviews based on the number of tickets bought
     * @param transaction
     * @return true if moviegoer eligible to review movie
     */
    public boolean eligibleToReview(Transaction transaction)
    {
        return reviewController.updateNumReview(transaction);
    }

    /**
     * submit review of a movie goer
     * @param movieId
     * @param comment
     * @param ratings
     */
    public void submitReview(int movieId, String comment, int ratings)
    {
        movieController.insertReview(movieId, comment, ratings);
    }

}
