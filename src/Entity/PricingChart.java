package Entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @version 1
 * @since 2019-11-13
 * @typeofclass entity
 * PriceChart provides an automated price ticket calculator based on the different factors such as age.
 *
 */
public class PricingChart implements Serializable {
    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = 3338247823531836590L;

    private int pricingChartID;
    /**
     * cinema type for this pricing
     */
    private String cinemaType;
    /**
     * customer class for this pricing
     */
    private String customerClass;
    /**
     * day for this pricing
     */
    private DayOfWeek dayOfTheWeek;
    /**
     * movie type for this pricing
     */
    private String movieType;
    /**
     * price for this pricing
     */
    private double price;
    /**
     * start time for this pricing
     */
    private LocalTime fromTime;
    /**
     * end time for this pricing
     */
    private LocalTime toTime;

    /**
     * Creates pricing with given pricingChartID, type of cinema, customer class, day of the week, type of movie, price, start time and end time
     * @param pricingChartID
     * @param cinemaType
     * @param customerClass
     * @param dayOfTheWeek
     * @param movieType
     * @param price
     * @param fromTime
     * @param toTime
     */
    public PricingChart(int pricingChartID, String cinemaType, String customerClass, DayOfWeek dayOfTheWeek,
                        String movieType, double price, LocalTime fromTime, LocalTime toTime) {
        this.pricingChartID = pricingChartID;
        this.cinemaType = cinemaType;
        this.customerClass = customerClass;
        this.dayOfTheWeek = dayOfTheWeek;
        this.movieType = movieType;
        this.price = price;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    /**
     * get cinema type for this pricing
     * @return cinema type for this pricing
     */
    public String getCinemaType() {
        return cinemaType;
    }

    /**
     * get customer class for this pricing
     * @return customer class for this pricing
     */
    public String getCustomerClass() {
        return customerClass;
    }

    /**
     * get day of the week for this pricing
     * @return day of the week for this pricing
     */
    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    /**
     * get movie type for this pricing
     * @return movie type for this pricing
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * get price for this pricing
     * @return price for this pricing
     */
    public double getPrice() {
        return price;
    }


    /**
     * get start time for this pricing
     * @return start time for this pricing
     */
    public LocalTime getFromTime() {
        return fromTime;
    }

    /**
     * get end time for this pricing
     * @return end time for this pricing
     */
    public LocalTime getToTime() {
        return toTime;
    }
}
