package Controller;

import Entity.Cinema;
import Entity.PricingChart;
import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.DayOfWeek;
import java.util.ArrayList;

/**
 * Controls ????
 * @version 1.0
 * @since 2019-11-13
 */

class PricingChartController {
    private HandlerInterface database;
    /**
     * contains pricing chart for all showtime
     */
    private ArrayList<PricingChart> pricingChartArrayList;

    /**
     * As PricingChartController is created, data is retrieved from file i/o
     */
    PricingChartController()
    {
        database = new DataHandler();
        pricingChartArrayList = database.readSerializedObject("PricingChart");
    }

    /**
     * get price of a ticket base on a particular show time, taking into consideration of various factors
     * @param showTime
     * @param publicHoliday
     * @param customerClass
     * @return price of a ticket
     */

    double getPrice(ShowTime showTime, boolean publicHoliday, String customerClass)
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

        //-------Customer class
        DayOfWeek day;
        if (publicHoliday)
        {
            customerClass = "Adult";
            day = DayOfWeek.SATURDAY;
        }
        else
            day = showTime.getDateTime().toLocalDate().getDayOfWeek();

        //-------from time / end time

        for (PricingChart pricingChart: pricingChartArrayList)
        {
            if (pricingChart.getCinemaType().compareTo(cinemaType)==0)
            {
                //System.out.println("Check cinema type: " + cinemaType);
                if (pricingChart.getCustomerClass().compareTo(customerClass)==0)
                {
                    if (pricingChart.getDayOfTheWeek().compareTo(day)==0)
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
        return -1;  //--> if cannot find but this situation shouldn't happen
    }
}

