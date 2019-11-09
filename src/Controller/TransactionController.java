package Controller;

import Entity.Ticket;
import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class TransactionController implements ControllerInterface {
    //add transaction aft any booking
    private HandlerInterface database;
    private ArrayList<Transaction> transactionArrayList;

    public TransactionController()
    {
        database = new DataHandler();
        transactionArrayList = database.readSerializedObject("Transaction.dat");
    }
    //        this.TID = TID;
    //        this.namePurchaser = namePurchaser;
    //        this.mobileNumber = mobileNumber;
    //        this.emailAddress = emailAddress;
    //        this.totalPrice = totalPrice;
    //        this.ticketArrayList = ticketArrayList;

    public void addTransaction(String name, long mobileNum, String email, double totalPrice, ArrayList<Ticket> ticketArrayList)
    {
        ZoneId zid = ZoneId.of("Asia/Singapore");
        LocalDateTime dateTime = LocalDateTime.now(zid);  //see if you can find sg time zone
        String dateTimeString = dateTime.toString();
        //2019-01-21T06:47:22.756
        int cinemaID = ticketArrayList.get(0).getShowTime().getCinemaID();
        String transactionID = cinemaID + dateTimeString.substring(0,3) +dateTimeString.substring(5,6) + dateTimeString.substring(8,9) +
                dateTimeString.substring(11,12) +dateTimeString.substring(14,15)+dateTimeString.substring(17,18);
        System.out.println("test: transactionID: " + transactionArrayList);
        transactionArrayList.add(new Transaction(transactionID, name, mobileNum, email, totalPrice, ticketArrayList));
        updateDat();
    }

    @Override
    public void updateDat() {
        database.writeSerializedObject("Transaction.dat", transactionArrayList);
    }
}
