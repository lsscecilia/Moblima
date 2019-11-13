package Handler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for UI
 * modifier package-private
 * @version 1.0
 * @since 2019-11-13
 */
public interface HandlerInterface {
    public <T> ArrayList<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, ArrayList<T> list);
    public HashMap readSerializedHashMap(String filename);
    public <T> void writeSerializedHashMap(String filename, HashMap list);

}
