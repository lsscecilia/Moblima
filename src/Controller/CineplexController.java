package Controller;

import Entity.Cineplex;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class CineplexController {
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;
    // have all the cineplex in molbima, each cineplex have their own set of movie, and own set of cinema

    public CineplexController( ArrayList<Cineplex> cineplexArrayList) {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex.dat");
    }
}
