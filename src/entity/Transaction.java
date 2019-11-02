package entity;

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
    private int mobileNumber;
    private String emailAddress;
    private double totalPrice;
    private ArrayList<Ticket> ticketArrayList;


}
