package handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    public <T> ArrayList<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, ArrayList<T> list);

}
