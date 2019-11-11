package Controller;

import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
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
import java.util.stream.Stream;

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

    /**
     * Checks whether the slot is avilable or taken
     */
    public boolean checkSlotAvailable(Cineplex cineplex, int cineplexId, int cinemaId, int movieId, String timeSlot, String date){
        Movie movie1 = null;
        Cinema cinema1 = null;
        for(Movie movie: cineplex.getMovieInCineplexArrayList()){
            if(movie.getMovieId() == movieId){
                movie1=movie;
            }
        }
        for(Cinema cinema: cineplex.getCinemaArrayList()){
            if(cinema.getCinemaID() == cinemaId){
                cinema1 = cinema;
            }
        }
        int[] time = Stream.of((date+timeSlot).split(",")).mapToInt(Integer::parseInt).toArray();

        ShowTime showTime = new ShowTime(cineplex
                , movie1
                , cinemaId
                , cinema1.getColumn()
                , cinema1.getRows()
                , LocalDateTime.of(time[0],time[1],time[2],time[3],time[4]), new int[cinema1.getRows()][cinema1.getColumn()]);

        for(ShowTime showTime1: showTimeArrayList){
            if(showTime1.equals(showTime)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void updateDat(){
        database.writeSerializedObject("ShowTime", showTimeArrayList);
    }
}
