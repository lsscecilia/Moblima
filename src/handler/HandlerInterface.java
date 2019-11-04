package handler;

import java.util.List;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    List readSerializedObject(String filename);
    void writeSerializedObject(String filename, List list);

}
