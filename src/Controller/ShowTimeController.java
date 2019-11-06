package Controller;

import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class ShowTimeController implements  ControllerInterface{
    private HandlerInterface database;
    private ArrayList<ShowTime> showTimeArrayList;
    //all the showtime regardless of which cineplex

    public ShowTimeController()
    {
        database = new DataHandler();
        showTimeArrayList = database.readSerializedObject("ShowTime.dat");
    }

    @Override
    public void display() {

    }

    @Override
    public void updateDat(){
        database.writeSerializedObject("ShowTime.dat", showTimeArrayList);
    }
}
