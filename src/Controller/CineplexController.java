package Controller;

import entity.Cineplex;
import handler.DataHandler;
import handler.HandlerInterface;

import java.util.ArrayList;

public class CineplexController {
    private HandlerInterface handlerInterface;
    private ArrayList<Cineplex> cineplexArrayList;
    // have all the cineplex in molbima, each cineplex have their own set of movie, and own set of cinema

    public CineplexController( ArrayList<Cineplex> cineplexArrayList) {
        this.handlerInterface = new DataHandler();
        this.cineplexArrayList = (ArrayList<Cineplex>) handlerInterface.readSerializedObject("Cineplex.dat");
    }
}
