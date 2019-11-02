package handler;

import java.util.ArrayList;
import java.util.List;

public class CineplexHandler extends DataHandler{
    private ArrayList cineplexArrayList;

    public CineplexHandler()
    {
        cineplexArrayList = readSerializedObject();
    }
    private ArrayList readSerializedObject() {
        return (ArrayList) super.readSerializedObject("Cineplex.dat");
    }

    private void writeSerializedObject(List list) {
        super.writeSerializedObject("Cineplex.dat", list);
    }

    public ArrayList getCineplexArrayList() {
        return cineplexArrayList;
    }

    public void setCineplexArrayList(ArrayList cineplexArrayList) {
        this.cineplexArrayList = cineplexArrayList;
        writeSerializedObject(cineplexArrayList);
    }
}
