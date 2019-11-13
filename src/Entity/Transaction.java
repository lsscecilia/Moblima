package Entity;

import java.util.ArrayList;
import java.io.Serializable;

/**
* @version 1
* @since 17/10/2019
* @typeofclass entity
*/
public class Transaction implements Serializable{
    /**
     * unique id is used to represent a transaction (XXXYYYYMMDDHHMM: XXX - cinemaID, YYYY - MM - DD - HH - MM : current date and time)
     */
    private String TID;
    /**
     * name of moviegoer that make this transaction
     */
    private String namePurchaser;
    /**
     * mobile number of moviegoer that make this transaction
     */
    private long mobileNumber;
    /**
     * email address of moviegoer that make this transaction
     */
    private String emailAddress;
    /**
     * total price of this transaction
     */
    private double totalPrice;
    /**
     * array list of tickets in this transactions
     */
    private ArrayList<Ticket> ticketArrayList;

    /**
     * creates transactions with given TID, name, mobile number, email address, total price, array list of tickets
     * @param TID
     * @param namePurchaser
     * @param mobileNumber
     * @param emailAddress
     * @param totalPrice
     * @param ticketArrayList
     */
    public Transaction(String TID, String namePurchaser, long mobileNumber, String emailAddress, double totalPrice, ArrayList<Ticket> ticketArrayList) {
        this.TID = TID;
        this.namePurchaser = namePurchaser;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.totalPrice = totalPrice;
        this.ticketArrayList = ticketArrayList;
    }

    /**
     * get transaction ID
     * @return transaction ID
     */
    public String getTID() {
        return TID;
    }

    /**
     * get name of moviegoer
     * @return name of moviegoer
     */
    public String getNamePurchaser() {
        return namePurchaser;
    }

    /**
     * get mobile number of moviegoer
     * @return mobile number of moviegoer
     */
    public long getMobileNumber() {
        return mobileNumber;
    }

    /**
     * get email address of moviegoer
     * @return email address of moviegoer
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * get total price of this transaction
     * @return total price of this transaction
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * get array list of tickets of this transaction
     * @return array list of tickets of this transaction
     */
    public ArrayList<Ticket> getTicketArrayList() {
        return ticketArrayList;
    }
}
