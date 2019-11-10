package Controller;

import Entity.ShowTime;
import Entity.Ticket;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

//
public class BookingController {
    private PricingChartController pricingChartController;
    private PublicHolidayController publicHolidayController;
    private ShowTimeController showTimeController;

    public BookingController()
    {
        pricingChartController = new PricingChartController();
        publicHolidayController = new PublicHolidayController();
        showTimeController = new ShowTimeController();

    }

    public double calculateTotalPrice(ArrayList<Ticket> ticketArrayList)
    {
        double totalPrice=0;
        for (Ticket ticket: ticketArrayList)
        {
            totalPrice+=ticket.getPrice();
        }
        return totalPrice;
    }
    public ArrayList<Ticket> newTicketArrayList(ShowTime showTime, int numTickets, int numStudent, int numSC, String[] seatSelected)
    {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>();
        double studentPrice, scPrice, adultPrice;
        int count=0;
        if (publicHolidayController.evePublicHoliday(showTime.getDateTime().toLocalDate()))
        {
            adultPrice = getPrice(showTime, "Adult");
            for (int i=0; i<numTickets;i++)
            {
                ticketArrayList.add(new Ticket(showTime, "Adult", adultPrice, seatSelected[i]));
            }
        }
        else
        {
            if (numStudent!=0)
            {
                studentPrice = getPrice(showTime, "Student");
                for (int i=0; i<numStudent;i++)
                {
                    ticketArrayList.add(new Ticket(showTime, "Student", studentPrice, seatSelected[count]));
                    count++;
                }
            }

            if (numSC!=0)
            {
                scPrice = getPrice(showTime, "Senior Citizen");
                for (int i=0; i<numSC;i++)
                {
                    ticketArrayList.add(new Ticket(showTime, "Senior Citizen", scPrice, seatSelected[count]));
                    count++;
                }
            }
            if (numTickets>numStudent+numSC)
            {
                adultPrice = getPrice(showTime, "Adult");
                for (int i=0; i<numTickets-numSC-numStudent;i++)
                {
                    ticketArrayList.add(new Ticket(showTime, "Adult", adultPrice, seatSelected[count]));
                    count++;
                }
            }
        }
        return ticketArrayList;
    }

    //can private
    public double getPrice(ShowTime showTime, String customerClass)
    {
        boolean publicHoliday;
        publicHoliday = publicHolidayController.evePublicHoliday(showTime.getDateTime().toLocalDate());
        return pricingChartController.getPrice(showTime,publicHoliday,customerClass);
    }

    public boolean studentSeniorCitizenCheck(ShowTime showTime)
    {
        LocalTime time = LocalTime.of(18, 0);
        if (publicHolidayController.evePublicHoliday(showTime.getDateTime().toLocalDate()))
            return false;
        if (showTime.getDateTime().toLocalDate().getDayOfWeek().compareTo(DayOfWeek.SATURDAY)==0)
            return false;
        if (showTime.getDateTime().toLocalDate().getDayOfWeek().compareTo(DayOfWeek.SUNDAY)==0)
            return false;
        if (showTime.getDateTime().toLocalTime().isAfter(time))
            return false;
        return true;
    }



    public void newTransaction()
    {

    }


}
