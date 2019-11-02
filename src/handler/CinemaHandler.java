package handler;

import java.util.ArrayList;
import java.util.List;

public class CinemaHandler extends DataHandler {
    private ArrayList cinemaArrayList;

    public CinemaHandler()
    {
        cinemaArrayList = readSerializedObject();
    }
    private ArrayList readSerializedObject() {
        return (ArrayList) super.readSerializedObject("Cinema.dat");
    }

    private void writeSerializedObject(List list) {
        super.writeSerializedObject("Cinema.dat", list);
    }

    public ArrayList getCinemaArrayList() {
        return cinemaArrayList;
    }

    public void setCinemaArrayList(ArrayList cinemaArrayList) {
        this.cinemaArrayList = cinemaArrayList;
        writeSerializedObject(cinemaArrayList);
    }
}
