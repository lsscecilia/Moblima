package Controller;

import Entity.Cineplex;
import Entity.Movie;
import Entity.ShowTime;
import Entity.Ticket;

import java.util.ArrayList;

public class CustomerUIController {
    private CustomerDisplayController display;
    private MovieController movieController;
    private CineplexController cineplexController;
    private ShowTimeController showTimeController;
    private BookingController bookingController;
    private TransactionController transactionController;

    public CustomerUIController() {
        display = new CustomerDisplayController();
        movieController = new MovieController();
        cineplexController = new CineplexController();
        showTimeController = new ShowTimeController();
        bookingController = new BookingController();
        transactionController = new TransactionController();
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

    public int getCineplexId(ArrayList<Cineplex> cineplexArrayList, int index)
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


}
