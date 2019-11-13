package Controller;

import Entity.Transaction;
import Handler.DataHandler;
import Handler.HandlerInterface;
import java.util.HashMap;

/**
 *
 * @version 1.0
 * @since 2019-11-13
 */
public class ReviewController implements ControllerInterface{
    private HandlerInterface database;
    /**
     * Maps a transaction to the number of reviews submitted
     */
    private HashMap<Transaction,Integer> reviewTracker;

    /**
     * As ReviewController is created, data is retrieved from file i/o
     */
    public ReviewController()
    {
        database = new DataHandler();
        reviewTracker = database.readSerializedHashMap("ReviewTracker");
    }


    /**
     * Checks that moviegoer is eligible to make a review (n tickets can only make n reviews)
     * update the number of reviews if moviegoer is eligible
     * @param transaction
     * @return true if
     */
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

    /**
     * update file i/o with current data for reviewTracker
     */
    @Override
    public void updateDat() {
        database.writeSerializedHashMap("ReviewTracker", reviewTracker);
    }
}
