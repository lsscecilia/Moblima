package Entity;


import java.time.LocalTime;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 * PriceChart provides an automated price ticket calculator based on the different factors such as age.
 *
 */
public class PricingChart {
    private int pricingChartID;
    private String cinemaType;
    private String customerClass;
    private String dayOfTheWeek;
    private String movieType;
    private double price;
    private LocalTime fromTime;
    private LocalTime toTime;

    public PricingChart(int pricingChartID, String cinemaType, String customerClass, String dayOfTheWeek, String movieType, double price, LocalTime fromTime, LocalTime toTime) {
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

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
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
