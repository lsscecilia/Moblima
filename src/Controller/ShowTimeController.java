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

    /**
     * Method to sort ShowTimeArrayList using Collections.sort
     * @param showTimes
     * @return
     */
    public ArrayList<ShowTime> sortShowTime(ArrayList<ShowTime> showTimes)
    {
        Collections.sort(showTimes);
        return showTimes;
    }

    /**
     * Returns ShowTime Object from it's index
     * @param showTimes
     * @param index
     * @return
     */
    public ShowTime getShowTime(ArrayList<ShowTime> showTimes, int index)
    {
        return showTimes.get(index);
    }

    /**
     * Checks whether the seat selected is available, if available return true, else false.
     * @param showTime
     * @param row
     * @param column
     * @return boolean true/false
     */
    public boolean checkSeatAvailable(ShowTime showTime, char row, int column)
    {
        column--;
        String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int rowInt = letters.indexOf(row);
        if (showTime.getSeatLayout()[rowInt][column]==1)
            return false;
        return true;
    }

    /**
     * Update the availability of the Seats
     * @param showTimeSelected
     * @param selectedSeats
     * @param numSeats
     */
    public void updateSeatAvailability(ShowTime showTimeSelected, String[] selectedSeats, int numSeats)
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
     * Displays value of Attributes in Showtime object
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     * @param choice
     */
    public void displaySpecificAttributeInShowTime(int cineplexId, int cinemaId, int showTimeIndex, int choice){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }

        ShowTime showtime1 = showTimeArrayListDisplay.get(showTimeIndex);
        if(choice == 1){
            System.out.println(showtime1.getMovie().getMovieTitle());
        }
        else if(choice == 2){
            System.out.println(showtime1.getDateTime().toLocalDate().toString());
        }
        else if(choice == 3){
            System.out.println(showtime1.getDateTime().toLocalTime().toString());
        }
    }

    /**
     * Displays Specific ShowTime from showTimeIndex
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     */
    public void displaySpecificShowTime(int cineplexId, int cinemaId, int showTimeIndex){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }
        ShowTime specificShowTime = showTimeArrayListDisplay.get(showTimeIndex);
        System.out.println("==============");
        System.out.println("| ShowTime " + (showTimeIndex+1) + " |");
        System.out.println("==============");
        System.out.println("Cineplex: " + specificShowTime.getCineplex().getCineplexName());
        System.out.println("Cinema Hall " + specificShowTime.getCinemaID());
        System.out.println("Movie Showing: " + specificShowTime.getMovie().getMovieTitle());
        System.out.println("Show Time: " + specificShowTime.getDateTime().toLocalDate().toString() + " " +
                            specificShowTime.getDateTime().toLocalTime().toString());
        System.out.println();
    }

    /**
     * Displays All ShowTime from the cineplexId and cinemaId
     * @param cineplexId
     * @param cinemaId
     */
    public void displayAllShowTime(int cineplexId, int cinemaId){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }
        for(int i=0; i<showTimeArrayListDisplay.size();i++){
            System.out.println("==============");
            System.out.println("| ShowTime " + (i+1) + " |");
            System.out.println("==============");
            System.out.println("Cineplex: " + showTimeArrayListDisplay.get(i).getCineplex().getCineplexName());
            System.out.println("Cinema Hall " + showTimeArrayListDisplay.get(i).getCinemaID());
            System.out.println("Movie Showing: " + showTimeArrayListDisplay.get(i).getMovie().getMovieTitle());
            System.out.println("Show Time: " + showTimeArrayListDisplay.get(i).getDateTime().toLocalDate().toString() + " " +
                                showTimeArrayListDisplay.get(i).getDateTime().toLocalTime().toString());
            System.out.println();
        }
    }


    /**
     * Checks whether the slot is available or taken, if it is available then Add to showTimeArrayList. Else return false and exit.
     * @param cineplex Object
     * @param cineplexId cineplex object Id
     * @param cinemaId cinemaId
     * @param movieId MovieId
     * @param timeSlot time, formatted in hh,mm
     * @param date date, formatted in yyyy,dd,mm
     * @return
     */
    public boolean checkSlotAvailable(Cineplex cineplex, int cineplexId, int cinemaId, int movieId, String timeSlot, String date){
        Movie movie1 = null;
        Cinema cinema1 = null;
        boolean duplicate = false;
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
            if(showTime1.getCineplex().getCineplexID() == showTime.getCineplex().getCineplexID()){
                if(showTime1.getCinemaID()==showTime.getCinemaID()){
                    if(showTime1.getDateTime().isEqual(showTime.getDateTime())){
                        duplicate = true;
                        break;
                    }
                }
            }
        }
        if(!duplicate){
            showTimeArrayList.add(showTime);
            updateDat();
        }

        return !duplicate;
    }

    /**
     * Modifies the Movie in a particular ShowTime
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     * @param movieChoice
     */
    public void modifyMovieInShowTime(int cineplexId, int cinemaId, int showTimeIndex, int movieChoice){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }
        ShowTime showtime1 = showTimeArrayListDisplay.get(showTimeIndex);
        for(Movie movie: showtime1.getCineplex().getMovieInCineplexArrayList()){
            if(movie.getMovieId()==movieChoice){
                showtime1.setMovie(movie);
            }
        }
        updateDat();
    }

    /**
     * Modifies the Date aspect in ShowTime
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     * @param dateString
     */
    public void modifyDateInShowTime(int cineplexId, int cinemaId, int showTimeIndex, String dateString){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }

        ShowTime showtime1 = showTimeArrayListDisplay.get(showTimeIndex);
        String newDateTime = (dateString + "-" + showtime1.getDateTime().toLocalTime()
                                                                        .toString()
                                                                        .replace(":","-"))
                                                                        .replace("-",",");
        int[] time = Stream.of((newDateTime).split(",")).mapToInt(Integer::parseInt).toArray();
        showtime1.setDateTime(LocalDateTime.of(time[0],time[1],time[2],time[3],time[4]));
        updateDat();
    }

    /**
     * Modifies the Time aspect in ShowTime
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     * @param timeString
     */
    public void modifyTimeInShowTime(int cineplexId, int cinemaId, int showTimeIndex, String timeString){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }
        ShowTime showtime1 = showTimeArrayListDisplay.get(showTimeIndex);
        String newDateTime = (showtime1.getDateTime().toLocalDate().toString() + "-" + timeString).replace("-",",");
        int[] time = Stream.of((newDateTime).split(",")).mapToInt(Integer::parseInt).toArray();
        showtime1.setDateTime(LocalDateTime.of(time[0],time[1],time[2],time[3],time[4]));
        updateDat();
    }

    /**
     * Removes ShowTime from showTimeArrayList
     * @param cineplexId
     * @param cinemaId
     * @param showTimeIndex
     */
    public void removeShowTime(int cineplexId, int cinemaId, int showTimeIndex){
        ArrayList<ShowTime> showTimeArrayListDisplay = new ArrayList<>();
        for(ShowTime showTime:showTimeArrayList){
            if(showTime.getCineplex().getCineplexID() == cineplexId && showTime.getCinemaID() == cinemaId){
                showTimeArrayListDisplay.add(showTime); //ShowTime object in showTimeArrayListDisplay references from the objects in showTimeArrayList
            }
        }
        ShowTime showtime1 = showTimeArrayListDisplay.get(showTimeIndex);
        showTimeArrayList.remove(showtime1);
        updateDat();
    }

    @Override
    public void updateDat(){
        database.writeSerializedObject("ShowTime", showTimeArrayList);
    }
}
