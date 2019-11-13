package Controller;

import Entity.Movie;
import Entity.Ticket;
import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import static java.util.stream.Collectors.toMap;

/**
 * @version 1
 * @since 2019-11-13
 */
public class TransactionController implements ControllerInterface {
    private HandlerInterface database;
    /**
     * contains all the transactions across all the cineplexes
     */
    private ArrayList<Transaction> transactionArrayList;

    /**
     * As TransactionController is created, data is retrieved from file i/o
     */
    public TransactionController()
    {
        database = new DataHandler();
        transactionArrayList = database.readSerializedObject("Transaction");
    }

    /**
     * Finds Booking history from phone number provided by user
     * @param number
     * @return ArrayList<Transaction> ArrayList of Booking History
     */
    public ArrayList<Transaction> findBookingHistory(long number)
    {
        ArrayList<Transaction> transactionArrayList1 = new ArrayList<>();
        for (Transaction transaction: transactionArrayList)
        {
            if (transaction.getMobileNumber() == number)
            {
                transactionArrayList1.add(transaction);
            }
        }
        return transactionArrayList1;
    }

    /**
     * Checks if there is any booking history
     * @param transactions
     * @return true if booking history exist, else return false
     */
    public boolean bookingHistoryExist(ArrayList<Transaction> transactions)
    {
        if (transactions.isEmpty())
            return false;
        else
            return true;
    }

    /**
     * Add Transaction to transaction array list and update in file i/o
     * @param name
     * @param mobileNum
     * @param email
     * @param totalPrice
     * @param ticketArrayList
     */
    public void addTransaction(String name, long mobileNum, String email, double totalPrice, ArrayList<Ticket> ticketArrayList)
    {
        ZoneId zid = ZoneId.of("Asia/Singapore");
        LocalDateTime dateTime = LocalDateTime.now(zid);  //see if you can find sg time zone
        String dateTimeString = dateTime.toString();
        int cinemaID = ticketArrayList.get(0).getShowTime().getCinemaID();
        String transactionID = cinemaID + dateTimeString.substring(0,4) + dateTimeString.substring(5,7) + dateTimeString.substring(8,10) +
                dateTimeString.substring(11,13)+dateTimeString.substring(14,16)+dateTimeString.substring(17,19);
        transactionArrayList.add(new Transaction(transactionID, name, mobileNum, email, totalPrice, ticketArrayList));
        updateDat();
    }

    /**
     * get number of ticket sales for each movie
     * @return hashmap where key = movie, value = number of ticket sales, and sorted in descending order
     */
    public HashMap<Movie,Integer> top5ByTicketSales()
    {
        HashMap<Movie,Integer> top5 = new HashMap<>();
        int numTicket;
        for (Transaction transaction: transactionArrayList)
        {
            Movie movie = transaction.getTicketArrayList().get(0).getShowTime().getMovie();
            numTicket = transaction.getTicketArrayList().size();
            for (Movie movie1: top5.keySet())
            {
                if (movie1.getMovieId()==movie.getMovieId())
                {
                    numTicket = top5.get(movie1) + numTicket;
                    top5.remove(movie1);
                    break;
                }

            }
            top5.put(movie, numTicket);
        }
        HashMap<Movie, Integer> sorted = top5
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        return sorted;
    }

    /**
     * update file i/o with current data for transactions
     */
    @Override
    public void updateDat() {
        database.writeSerializedObject("Transaction", transactionArrayList);
    }
}
