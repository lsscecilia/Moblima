package Controller;

import entity.ShowTime;
import handler.DataHandler;

import java.util.ArrayList;

public class ShowTimeController {
    private HandlerInterface handlerInterface;
    private ArrayList<ShowTime> showTimeArrayList;
    //all the showtime regardless of which cineplex
    public ShowTimeController()
    {
        handlerInterface = new DataHandler();
        showTimeArrayList = (ArrayList<ShowTime>) handlerInterface.readSerializedObject("ShowTime.dat");
    }
}
