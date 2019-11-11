package Handler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    public <T> ArrayList<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, ArrayList<T> list);
    public HashMap readSerializedHashMap(String filename);
    public <T> void writeSerializedHashMap(String filename, HashMap list);

}
