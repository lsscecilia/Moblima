package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class Ticket implements Serializable{

    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = 8626450327498985680L;

    /**
     * show time of this ticket
     */
    private ShowTime showTime;
    /**
     * customer class of this ticket (eg. student, senior citizen, adult)
     */
    private String customerClass;
    /**
     * price of this ticket
     */
    private double price;
    /**
     * seat of this ticket
     */
    private String seat;

    /**
     * creates ticket with given show time, customer class, price and seat
     * @param showTime
     * @param customerClass
     * @param price
     * @param seat
     */
    public Ticket(ShowTime showTime, String customerClass, double price, String seat) {
        this.showTime = showTime;
        this.customerClass = customerClass;
        this.price = price;
        this.seat = seat;
    }

    /**
     * get show time of this show time
     * @return show time of this show time
     */
    public ShowTime getShowTime() {
        return showTime;
    }

    /**
     * get customer class of this ticket
     * @return customer class of this ticket
     */
    public String getCustomerClass() {
        return customerClass;
    }

    /**
     * get price of this ticket
     * @return price of this ticket
     */
    public double getPrice() {
        return price;
    }

    /**
     * Change price of this ticket
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * get seat of this ticket
     * @return seat of this ticket
     */
    public String getSeat() {
        return seat;
    }
}
