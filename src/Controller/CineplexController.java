package Controller;

import Entity.Cineplex;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class CineplexController implements ControllerInterface {
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;


    public CineplexController( ArrayList<Cineplex> cineplexArrayList) {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
    }

    private void viewAllCineplex(){

    }

    @Override
    public void updateDat() {

    }
}
