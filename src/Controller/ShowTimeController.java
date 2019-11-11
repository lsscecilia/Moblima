package Controller;

import Entity.Cinema;
import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        ZoneId zid = ZoneId.of("Asia/Singapore");
        LocalDateTime dateTime = LocalDateTime.now(zid);
        ArrayList<ShowTime> showTimeAvalBookingArrayList = new ArrayList<>();
        for (ShowTime showTime: showTimeArrayList)
        {
            if ((showTime.getCineplex().getCineplexID() == cineplexId) && (showTime.getMovie().getMovieId() == movieId)
            && showTime.getDateTime().isAfter(dateTime))
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

    //seat aval return true;
    public boolean checkSeatAval(ShowTime showTime, char row, int column)
    {
        column--;
        String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int rowInt = letters.indexOf(row);
        if (showTime.getSeatLayout()[rowInt][column]==1)
            return false;
        return true;
    }

    public void updateSeatAval(ShowTime showTimeSelected, String[] selectedSeats, int numSeats)
    {
        char rowAlpha;
        int row, column;
        String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        CustomerDisplayController display = new CustomerDisplayController();
        for (int i=0; i<numSeats;i++) {
            rowAlpha = selectedSeats[i].charAt(0);
            row = letters.indexOf(rowAlpha);
            column = Character.getNumericValue(selectedSeats[i].charAt(1)) - 1;
            showTimeSelected.seatOccupied(row, column);
        }

        updateDat();
    }


    @Override
    public void updateDat(){
        database.writeSerializedObject("ShowTime", showTimeArrayList);
    }
}
