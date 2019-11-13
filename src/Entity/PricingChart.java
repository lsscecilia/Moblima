package Entity;


import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 * PriceChart provides an automated price ticket calculator based on the different factors such as age.
 *
 */
public class PricingChart implements Serializable {
    /**
     * unique id is used to represent a pricing
     */
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
     * Creates pricing
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

    public int getPricingChartID() {
        return pricingChartID;
    }

    public void setPricingChartID(int pricingChartID) {
        this.pricingChartID = pricingChartID;
    }

    public String getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(String cinemaType) {
        this.cinemaType = cinemaType;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(DayOfWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
}
