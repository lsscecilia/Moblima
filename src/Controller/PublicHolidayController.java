package Controller;

import Entity.PublicHoliday;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class PublicHolidayController {
    private HandlerInterface database;
    private ArrayList<PublicHoliday> publicHolidayArrayList;

    public PublicHolidayController()
    {
        database = new DataHandler();
        publicHolidayArrayList = database.readSerializedObject("PublicHoliday");

    }
}
