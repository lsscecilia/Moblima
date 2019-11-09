package Controller;

import Entity.PublicHoliday;
import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.LocalDate;
import java.util.ArrayList;

public class PublicHolidayController {
    private HandlerInterface database;
    private ArrayList<PublicHoliday> publicHolidayArrayList;

    public PublicHolidayController()
    {
        database = new DataHandler();
        publicHolidayArrayList = database.readSerializedObject("PublicHoliday");

    }

    public boolean evePublicHoliday(LocalDate date)
    {
        LocalDate eve;
        for (PublicHoliday publicHoliday: publicHolidayArrayList)
        {
            eve = publicHoliday.getDate().minusDays(1);
            if (date.compareTo(publicHoliday.getDate())==0)
                return true;
            if (date.compareTo(eve)==0)
                return true;
        }
        return false;
    }
}
