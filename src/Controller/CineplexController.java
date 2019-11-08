package Controller;

import Entity.Cineplex;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.util.ArrayList;

public class CineplexController implements ControllerInterface{
    private HandlerInterface database;
    private ArrayList<Cineplex> cineplexArrayList;


    public CineplexController() {
        this.database = new DataHandler();
        this.cineplexArrayList = database.readSerializedObject("Cineplex");
    }

    /**
     * Displays all the Cineplex Information
     */
    public void displayAllCineplexInfo(){
        if(cineplexArrayList != null){
            for(Cineplex cineplex : cineplexArrayList){
                System.out.println(cineplex.toString());
            }
        }
        else{
            System.out.println("There isn't any Cineplex :(");
        }

    }

    @Override
    public void updateDat() {
        database.writeSerializedObject("Cineplex", cineplexArrayList);
    }
}