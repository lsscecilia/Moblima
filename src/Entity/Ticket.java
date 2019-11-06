package Entity;
import java.io.Serializable;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class Ticket implements Serializable{
    private ShowTime showTime;
    private String customerClass;
    private double price;
    private String seat;
    //change attribute


    public Ticket(ShowTime showTime, String customerClass, double price, String seat) {
        this.showTime = showTime;
        this.customerClass = customerClass;
        this.price = price;
        this.seat = seat;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
