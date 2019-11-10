package Controller;

import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ShowTimeController implements  ControllerInterface{
    private HandlerInterface database;
    private ArrayList<ShowTime> showTimeArrayList;
    //all the showtime regardless of which cineplex

    public ShowTimeController()
    {
        database = new DataHandler();
        showTimeArrayList = database.readSerializedObject("ShowTime");
    }

    //already sorted
    public ArrayList<ShowTime> getShowTimeAval(int movieId, int cineplexId)
    {
        ArrayList<ShowTime> showTimeAvalBookingArrayList = new ArrayList<>();
        for (ShowTime showTime: showTimeArrayList)
        {
            if ((showTime.getCineplex().getCineplexID() == cineplexId) && (showTime.getMovie().getMovieId() == movieId))
            {
                showTimeAvalBookingArrayList.add(showTime);
            }
        }
        sortShowTime(showTimeAvalBookingArrayList);
        return showTimeAvalBookingArrayList;
    }

    //can do this private
    public ArrayList<ShowTime> sortShowTime(ArrayList<ShowTime> showTimes)
    {
        Collections.sort(showTimes);
        return showTimes;
    }

    public ShowTime getShowTime(ArrayList<ShowTime> showTimes, int index)
    {
        return showTimes.get(index);
    }

    public boolean checkSeatAval(ShowTime showTime, char row, int column)
    {
        column--;
        String letters =" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int rowInt = letters.indexOf(row);
        if (showTime.getSeatLayout()[rowInt][column]==0)
            return true;
        return false;
    }

    public void updateSeatAval(ShowTime showTimeSelected, String[] selectedSeats, int numSeats)
    {
        char rowAlpha;
        int row, column;
        String letters =" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (ShowTime showTime: showTimeArrayList)
        {
            if (showTime.compareTo(showTimeSelected)==0)
            {
                for (int i=0; i<numSeats;i++)
                {
                    rowAlpha = selectedSeats[i].charAt(0);
                    row = letters.indexOf(rowAlpha);
                    column = Character.getNumericValue(selectedSeats[i].charAt(1))-1;
                    showTime.seatOccupied(row, column);
                }
                break;
            }
        }
        updateDat();
    }

    @Override
    public void updateDat(){
        database.writeSerializedObject("ShowTime", showTimeArrayList);
    }
}
