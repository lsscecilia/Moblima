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
    }

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
        weekend = weekend(showTime);
        if (weekend)
            dayOfTheWeek = "weekend";  //check spelling
        else
            dayOfTheWeek = "weekday";
        //-------Customer class --> publicHoliday -- no student, no seniorCitizen
        if (publicHoliday)
            customerClass = "adult";
        //-------from time / end time --> take from showTime

        for (PricingChart pricingChart: pricingChartArrayList)
        {
            if (pricingChart.getCinemaType().compareTo(cinemaType)==0)
            {
                if (pricingChart.getCustomerClass().compareTo(customerClass)==0)
                {
                    if (pricingChart.getDayOfTheWeek().compareTo(dayOfTheWeek)==0)
                    {
                        if (pricingChart.getMovieType().compareTo(movieType)==0)
                        {
                            if (pricingChart.getFromTime().isBefore(showTime.getDateTime().toLocalTime()))
                            {
                                if (pricingChart.getToTime().isAfter(showTime.getDateTime().toLocalTime()))
                                {
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