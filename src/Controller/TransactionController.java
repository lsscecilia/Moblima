package Controller;

import entity.Transaction;
import handler.DataHandler;
import handler.HandlerInterface;

import java.util.ArrayList;

public class TransactionController {
    //add transaction aft any booking
    private HandlerInterface handlerInterface;
    private ArrayList<Transaction> transactionArrayList;

    public TransactionController()
    {
        handlerInterface = new DataHandler();
        transactionArrayList = (ArrayList<Transaction>) handlerInterface.readSerializedObject("Transaction.dat");
    }
}
