package handler;

import java.util.ArrayList;
import java.util.List;

public class ShowTimeHandler extends DataHandler{
    private ArrayList showTimeArrayList;

    public ShowTimeHandler()
    {
        showTimeArrayList = readSerializedObject();
    }
    private ArrayList readSerializedObject() {
        return (ArrayList) super.readSerializedObject("ShowTime.dat");
    }

    private void writeSerializedObject(List list) {
        super.writeSerializedObject("ShowTime.dat", list);
    }

    public ArrayList getShowTimeArrayList() {
        return showTimeArrayList;
    }

    public void setShowTimeArrayList(ArrayList showTimeArrayList) {
        this.showTimeArrayList = showTimeArrayList;
        writeSerializedObject(showTimeArrayList);
    }
}
