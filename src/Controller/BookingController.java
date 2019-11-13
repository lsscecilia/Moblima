package Controller;

import Entity.ShowTime;
import Entity.Ticket;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @version 1.0
 * @since 2019-11-13
 */
public class BookingController {
    /**
     * booking controller utilises pricing chart controller to get pricing for respective tickets
     */
    private PricingChartController pricingChartController;
    /**
     * booking controller utilises public holiday controller to get public holidays date
     */
    private PublicHolidayController publicHolidayController;
    /**
     * booking controller utilises show time controller
     */
    private ShowTimeController showTimeController;

    /**
     * Creating booking controller initialises all other controller required
     */
    public BookingController()
    {
        pricingChartController = new PricingChartController();
        publicHolidayController = new PublicHolidayController();
        showTimeController = new ShowTimeController();

    }

    /**
     * calculate total price for all the tickets
     * @param ticketArrayList
     * @return total price
     */
    public double calculateTotalPrice(ArrayList<Ticket> ticketArrayList)
    {
        double totalPrice=0;
        for (Ticket ticket: ticketArrayList)
        {
            totalPrice+=ticket.getPrice();
        }
        return totalPrice;
    }

    /**
     * generate tickets according to moviegoer's choice in showtime and seat selected
     * @param showTime
     * @param numTickets
     * @param numStudent
     * @param numSC
     * @param seatSelected
     * @return array list of ticket
     */
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

    /**
     * get price from pricing chart via pricing chart controller
     * @param showTime
     * @param customerClass
     * @return price
     */

    public double getPrice(ShowTime showTime, String customerClass)
    {
        boolean publicHoliday;
        publicHoliday = publicHolidayController.evePublicHoliday(showTime.getDateTime().toLocalDate());
        return pricingChartController.getPrice(showTime,publicHoliday,customerClass);
    }

    /**
     * check if student tickets and senior citizen tickets are available
     * @param showTime
     * @return true if student tickets and senior citizen tickets are available, else return false
     */
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

    /**
     * Draft layout for the seats selected by user
     * @param seatSelected
     * @param showTime
     * @param numSeats
     * @return show time will the draft layout
     */
    public ShowTime draftLayout (String[] seatSelected, ShowTime showTime, int numSeats)
    {
        char rowAlpha;
        int row, column, numEmpty = 0;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ShowTime showTimeClone = new ShowTime(showTime);
        for (int i = 0; i < numSeats; i++) {
            rowAlpha = seatSelected[i].charAt(0);
            row = letters.indexOf(rowAlpha);
            column = Character.getNumericValue(seatSelected[i].charAt(1)) - 1;
            showTimeClone.seatOccupiedDraft(row, column);
        }
        return showTimeClone;
    }

    /**
     * check if movie goer entered any duplicated seats
     * @param seatSelected
     * @return true if there is no duplicated seats, else return false
     */

    public boolean checkNoDuplicateSeat(String[] seatSelected)
    {
        for (int i =0;i<seatSelected.length; i++)
        {
            for (int r=i+1; r<seatSelected.length; r++)
            {
                if (seatSelected[i].compareTo(seatSelected[r])==0)
                    return false;
            }
        }
        return true;
    }

    /**
     * check that movie goer does not leave a single unoccupied seat between selected seats
     * @param seatSelected
     * @param showTime
     * @param numSeats
     * @return true if movie goer does not leave a single unoccupied seat between selected seats, else return false
     */

    public boolean checkSingleSeat(String[] seatSelected, ShowTime showTime, int numSeats){
        int numEmpty=0;
        for (int i=0; i<showTime.getRow(); i++)
        {
            numEmpty =0;
            for (int r=0;r<showTime.getColumn();r++)
            {
                if (showTime.getSeatLayout()[i][r]!=1)
                {
                    numEmpty++;
                }
                else if (numEmpty==1)
                {
                    return false;
                }
                else
                    numEmpty=0;
            }
            if  (numEmpty==1)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * calculate the number of available seats in the show time
     * @param showTime
     * @return number of available seats in the show time
     */
    public int numAvalSeats(ShowTime showTime)
    {
        int[][] seatLayout = showTime.getSeatLayout();
        int row = showTime.getRow();
        int column = showTime.getColumn();
        int numAvalSeat=0;
        for (int i=0;i<row;i++)
        {
            for (int r=0; r<column;r++)
            {
                if (seatLayout[i][r] == 0)
                    numAvalSeat++;
            }
        }
        return numAvalSeat;
    }
}
