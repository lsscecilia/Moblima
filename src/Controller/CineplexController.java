package Controller;

import Entity.Cineplex;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class CineplexController implements ControllerInterface{
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;
    // have all the cineplex in molbima, each cineplex have their own set of movie, and own set of cinema

    public CineplexController() {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
    }

    public void displayAllCineplexInfo(){

    }

    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}
