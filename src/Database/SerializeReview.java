package Database;

import java.util.ArrayList;
import java.util.List;

public class SerializeReview extends SerializeDB {
    private List list;

    public SerializeReview(List list) {
        this.list = list;
    }

    public List readSerializedObject() {
        return  (ArrayList) super.readSerializedObject("Review.dat");
    }

    public void writeSerializedObject(List list) {
        super.writeSerializedObject("Review.dat", list);
    }

}
