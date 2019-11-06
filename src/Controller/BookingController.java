package Controller;

import Entity.ShowTime;
import Entity.Ticket;

import java.util.ArrayList;

//
public class BookingController {
    private PricingChartController pricingChartController;
    private PublicHolidayController publicHolidayController;
    private ArrayList<Ticket> ticketArrayList;
    private ShowTime showTime;
    private String customerClass;

    public BookingController()
    {

        ticketArrayList = new ArrayList<>();
    }

    public void newTicket(ShowTime showTime,String customerClass, String seat)
    {
        double price = getPrice();

    }

    public void chooseSeat()
    {

    }

    public boolean seatAval(String seat)
    {
        return true;
    }

    public double getPrice()
    {
        return 0.0;
    }


    public void newTransaction()
    {

    }


}
