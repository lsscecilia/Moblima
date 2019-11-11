package Controller;

import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.io.Serializable;
import java.util.HashMap;

public class ReviewController implements ControllerInterface{
    private HandlerInterface database;
    private HashMap<Transaction,Integer> reviewTracker;

    public ReviewController()
    {
        database = new DataHandler();
        reviewTracker = database.readSerializedHashMap("ReviewTracker.ser");
    }

    //add one by one
    public boolean updateNumReview(Transaction transaction)
    {
        if (reviewTracker!=null)
        {
            for (Transaction t: reviewTracker.keySet())
            {
                if (t.getTID().compareTo(transaction.getTID())==0)
                {
                    if (t.getTicketArrayList().size()>reviewTracker.get(t))
                    {
                        reviewTracker.put(t, reviewTracker.get(t)+1);
                        updateDat();
                        return true;
                    }

                    else
                        return false;

                }
            }
        }

        reviewTracker.put(transaction, 1);
        updateDat();
        return true;
    }

    @Override
    public void updateDat() {
        database.writeSerializedHashMap("ReviewTracker.ser", reviewTracker);
    }
}
