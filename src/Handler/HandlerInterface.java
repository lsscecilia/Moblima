package Handler;

import java.util.ArrayList;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    public <T> ArrayList<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, ArrayList<T> list);

}
