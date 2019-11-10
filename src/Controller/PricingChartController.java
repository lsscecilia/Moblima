package Controller;

import Entity.Cinema;
import Entity.PricingChart;
import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class PricingChartController {
    private HandlerInterface database;
    private ArrayList<PricingChart> pricingChartArrayList;

    public PricingChartController()
    {
        database = new DataHandler();
        pricingChartArrayList = database.readSerializedObject("PricingChart");
    }

    /*
    private boolean weekend(ShowTime showTime)
    {
        DayOfWeek sat = DayOfWeek.SATURDAY;
        DayOfWeek sun = DayOfWeek.SUNDAY;
        if (showTime.getDateTime().getDayOfWeek().compareTo(sat)!=0)
        {
            if (showTime.getDateTime().getDayOfWeek().compareTo(sun)!=0)
                return false;
        }
        return false;
    }*/

    public double getPrice(ShowTime showTime, boolean publicHoliday, String customerClass)
    {
        int cinemaID = showTime.getCinemaID();
        boolean weekend;
        String cinemaType =null, dayOfTheWeek, movieType;
        //-------CinemaTye
        ArrayList<Cinema> cinemaArrayList =showTime.getCineplex().getCinemaArrayList();
        for (Cinema cinema: cinemaArrayList)
        {
            if (cinema.getCinemaID() == cinemaID)
                cinemaType = cinema.getCinemaType();
        }
        //-------movieType
        movieType = showTime.getMovie().getMovieType();
        //-------dayOfTheWeek / weekend
       /* weekend = weekend(showTime);
        if (weekend)
            dayOfTheWeek = "weekend";  //check spelling
        else
            dayOfTheWeek = "weekday";*/
        //-------Customer class --> publicHoliday -- no student, no seniorCitizen
        DayOfWeek day;
        if (publicHoliday)
        {
            System.out.println("public holiday check"); //delete
            customerClass = "Adult";
            day = DayOfWeek.SATURDAY;
        }
        else
            day = showTime.getDateTime().toLocalDate().getDayOfWeek();

        //-------from time / end time --> take from showTime

        for (PricingChart pricingChart: pricingChartArrayList)
        {
            if (pricingChart.getCinemaType().compareTo(cinemaType)==0)
            {
                //System.out.println("Check cinema type: " + cinemaType);
                if (pricingChart.getCustomerClass().compareTo(customerClass)==0)
                {
                    //System.out.println("Check customer class: " + customerClass);
                    //System.out.println("pricing chart : " +pricingChart.getDayOfTheWeek() );
                    //System.out.println("showtime day: "+showTime.getDateTime().toLocalDate().getDayOfWeek() );
                    if (pricingChart.getDayOfTheWeek().compareTo(day)==0)
                    {
                        //System.out.println("Check day of the week: " +showTime.getDateTime().toLocalDate().getDayOfWeek().toString() );
                        if (pricingChart.getMovieType().compareTo(movieType)==0)
                        {
                            //System.out.println("Check movie type: " + movieType);
                            if (pricingChart.getFromTime().isBefore(showTime.getDateTime().toLocalTime()))
                            {
                                //System.out.println("Check time 1: ");
                                if (pricingChart.getToTime().isAfter(showTime.getDateTime().toLocalTime()))
                                {
                                    //System.out.println("Check time 2: ");
                                    return pricingChart.getPrice();
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;  //--> if cannot find but this situation shouldnt happen
    }
}

//    private int pricingChartID;
//    private String cinemaType;
//    private String customerClass;
//    private String dayOfTheWeek;
//    private String movieType;
//    private double price;
//    private int fromTime;
//    private int toTime;