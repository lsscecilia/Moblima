package Controller;

import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class TransactionController {
    //add transaction aft any booking
    private HandlerInterface database;
    private ArrayList<Transaction> transactionArrayList;

    public TransactionController()
    {
        database = new DataHandler();
        transactionArrayList = database.readSerializedObject("Transaction.dat");
    }
}
