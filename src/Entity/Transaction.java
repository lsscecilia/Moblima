package Entity;

import java.util.ArrayList;
import java.io.Serializable;

/**
* @version 1
* @since 17/10/2019
* @typeofclass entity
*/
public class Transaction implements Serializable{
    private String TID;
    private String namePurchaser;
    private long mobileNumber;
    private String emailAddress;
    private double totalPrice;
    private ArrayList<Ticket> ticketArrayList;

    public Transaction(String TID, String namePurchaser, long mobileNumber, String emailAddress, double totalPrice, ArrayList<Ticket> ticketArrayList) {
        this.TID = TID;
        this.namePurchaser = namePurchaser;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.totalPrice = totalPrice;
        this.ticketArrayList = ticketArrayList;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getNamePurchaser() {
        return namePurchaser;
    }

    public void setNamePurchaser(String namePurchaser) {
        this.namePurchaser = namePurchaser;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Ticket> getTicketArrayList() {
        return ticketArrayList;
    }

    public void setTicketArrayList(ArrayList<Ticket> ticketArrayList) {
        this.ticketArrayList = ticketArrayList;
    }
}
