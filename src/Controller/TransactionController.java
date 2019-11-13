package Controller;

import Entity.Movie;
import Entity.Ticket;
import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class TransactionController implements ControllerInterface {
    //add transaction aft any booking
    private HandlerInterface database;
    private ArrayList<Transaction> transactionArrayList;

    public TransactionController()
    {
        database = new DataHandler();
        transactionArrayList = database.readSerializedObject("Transaction");
    }

    /**
     * Finds Booking history from phone number provided by user
     * @param num
     * @return ArrayList<Transaction> ArrayList of Booking History
     */
    public ArrayList<Transaction> findBookingHistory(long num)
    {
        ArrayList<Transaction> transactionArrayList1 = new ArrayList<>();
        for (Transaction transaction: transactionArrayList)
        {
            if (transaction.getMobileNumber() == num)
            {
                transactionArrayList1.add(transaction);
            }
        }
        return transactionArrayList1;
    }

    /**
     * Checks if there is any booking history
     * Returns true if booking history exist, else return false
     * @param transactions
     * @return boolean
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
        LocalDateTime dateTime = LocalDateTime.now();  //see if you can find sg time zone
        String dateTimeString = dateTime.toString();
        //2019-01-21T06:47:22.756
        int cinemaID = ticketArrayList.get(0).getShowTime().getCinemaID();
        String transactionID = cinemaID + dateTimeString.substring(0,3) +dateTimeString.substring(5,6) + dateTimeString.substring(8,9) +
                dateTimeString.substring(11,12) +dateTimeString.substring(14,15)+dateTimeString.substring(17,18);
        System.out.println("test: transactionID: " + transactionArrayList);
        transactionArrayList.add(new Transaction(transactionID, name, mobileNum, email, totalPrice, ticketArrayList));
        updateDat();
    }

    /**
     * Returns HashMap of Top5 Movie by TicketSales
     * @return
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

    @Override
    public void updateDat() {
        database.writeSerializedObject("Transaction", transactionArrayList);
    }
}
