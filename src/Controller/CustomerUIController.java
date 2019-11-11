package Controller;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerUIController {
    private CustomerDisplayController display;
    private MovieController movieController;
    private CineplexController cineplexController;
    private ShowTimeController showTimeController;
    private BookingController bookingController;
    private TransactionController transactionController;
    private ReviewController reviewController;

    public CustomerUIController() {
        display = new CustomerDisplayController();
        movieController = new MovieController();
        cineplexController = new CineplexController();
        showTimeController = new ShowTimeController();
        bookingController = new BookingController();
        transactionController = new TransactionController();
        reviewController = new ReviewController();
    }

    public void showMovieList()
    {
        display.displayMovieTitle(movieController.getMovieArrayList());
    }

    //is this necessary?
    public void showMovieList(ArrayList<Movie> movieArrayList)
    {
        display.displayMovieTitle(movieArrayList);
    }

    public ArrayList<Movie> showMovieListAvalBooking()
    {
        ArrayList<Movie> movieAvalBookingArrayList = movieController.getMovieArrayListAvalBooking();
        display.displayMovieTitle(movieAvalBookingArrayList );
        return movieAvalBookingArrayList ;
    }

    public boolean studentSeniorCitizenCheck(ShowTime showTime)
    {
        return bookingController.studentSeniorCitizenCheck(showTime);
    }

    public int getMovieId(ArrayList<Movie> movieArrayList, int index)
    {
        return movieController.getMovieId(movieArrayList, index);
    }

    public ArrayList<Cineplex> showCineplexAval(int movieId)
    {
        ArrayList<Cineplex> cineplexAvalBookingArrayList = cineplexController.cineplexShowingMovie(movieId);
       display.displayCineplex(cineplexAvalBookingArrayList ); //get cineplex that show movie and display
        return cineplexAvalBookingArrayList;
    }

    public int getCinplexId(ArrayList<Cineplex> cineplexArrayList, int index)
    {
        return cineplexController.getCineplexId(cineplexArrayList, index);
    }

    public ArrayList<ShowTime> showShowTime(int movieId, int cineplexId)
    {
        ArrayList<ShowTime> showTimeAvalBookingArrayList;
        showTimeAvalBookingArrayList = showTimeController.getShowTimeAval(movieId, cineplexId);
        display.displayShowTime(showTimeAvalBookingArrayList);
        return showTimeAvalBookingArrayList;
    }

    public ShowTime getShowTime(ArrayList<ShowTime> showTimeArrayList, int index)
    {
        return showTimeController.getShowTime(showTimeArrayList, index);
    }

    public void showLayout(ShowTime showTime)
    {
        display.displaySeatLayout(showTime.getSeatLayout(), showTime.getRow(),showTime.getColumn());
    }

    public boolean checkSingleSeat(String[] seatSelected, ShowTime showTime, int numSeats)
    {
        return bookingController.checkSingleSeat(seatSelected, showTime, numSeats);
    }

    public int numAvalSeats(ShowTime showTime)
    {
        return bookingController.numAvalSeats(showTime);
    }

    public boolean checkSeatAval(ShowTime showTime, char row, int column)
    {
        return showTimeController.checkSeatAval(showTime, row, column);
    }
    //ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    public ArrayList<Ticket> generateTicket(ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    {
        ArrayList<Ticket> ticketArrayList = bookingController.newTicketArrayList(showTime ,numTickets, numStudent, numSC, seatSelected);
        display.displayTicket(ticketArrayList);
        return ticketArrayList;
    }

    public double calculateTotalPrice(ArrayList<Ticket> ticketArrayList)
    {
        return bookingController.calculateTotalPrice(ticketArrayList);
    }

    //update transaction, seataval, dat updated
    public void updateSuccessfulPayment(String name, long mobileNum, String email, double totalPrice,
                                        ArrayList<Ticket> ticketArrayList, String[] seatSelected)
    {
        transactionController.addTransaction(name, mobileNum, email, totalPrice, ticketArrayList);
        showTimeController.updateSeatAval(ticketArrayList.get(0).getShowTime(),seatSelected, ticketArrayList.size());
    }

    //overload
    public void showMovieInformation(int index)
    {
        display.movieInformation(movieController.getMovieArrayList(), index);
    }

    public void showMovieInformation(ArrayList<Movie> movieArrayList,int index)
    {
        display.movieInformation(movieArrayList, index);
    }

    public void showTop5MovieByRatings()
    {
        HashMap<Movie, Double> top5 = movieController.top5ByRatings();
        display.displayTop5Rating(top5);
    }

    public void showTop5MovieByTicketSales()
    {
        HashMap<Movie,Integer> top5 = transactionController.top5ByTicketSales();
        display.displayTop5TicketSale(top5);
    }

    public void showCineplexList()
    {
        display.displayCineplex(cineplexController.getCineplexArrayList());
    }

    public void showCineplexInformation(int index)
    {
        display.displayCineplexInformation(cineplexController.getCineplexArrayList(), index);
    }

    //can remove
   public ArrayList<Movie> searchMovieResult(String search)
    {
        return movieController.searchMovie(search);
    } //see if u nid this because its in showSearchResult


    public ArrayList<Movie> showSearchMovieResult(String search)
    {
        ArrayList<Movie> searchArrayList = movieController.searchMovie(search);
        display.displayMovieTitle(searchArrayList);
        return searchArrayList;
    }

    public boolean noResultFound(ArrayList<Movie> movieArrayList)
    {
        return movieController.noResultFound(movieArrayList);
    }

    public ArrayList<Transaction> showBookingHistory(long num)
    {
        ArrayList<Transaction> transactionArrayList =transactionController.findBookingHistory(num);
        if (transactionController.bookingHistoryExist(transactionArrayList))
            display.displayBookingHistory(transactionArrayList);
        else
            System.out.println("Sorry, no transactions can be found.");
        return transactionArrayList;
    }

    public ArrayList<Transaction> chooseMovieToReview(long num)
    {
        ArrayList<Transaction> transactionArrayList =transactionController.findBookingHistory(num);
        if (transactionController.bookingHistoryExist(transactionArrayList))
            display.displayMovieTitleBookingHistory(transactionArrayList);
        else
            System.out.println("Sorry, no transactions can be found.");
        return transactionArrayList;
    }

    public boolean review(Transaction transaction)
    {
        return reviewController.updateNumReview(transaction);
    }

    public void submitReview(int movieId, Review review)
    {
        movieController.insertReview(movieId, review);
    }



}
