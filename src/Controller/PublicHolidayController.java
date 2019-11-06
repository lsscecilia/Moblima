package Controller;

import entity.PublicHoliday;
import handler.DataHandler;
import handler.HandlerInterface;

import java.util.ArrayList;

public class PublicHolidayController {
    private HandlerInterface handlerInterface;
    private ArrayList<PublicHoliday> publicHolidayArrayList;

    public PublicHolidayController()
    {
        handlerInterface = new DataHandler();
        publicHolidayArrayList = handlerInterface.readSerializedObject("PublicHoliday");

    }
}
