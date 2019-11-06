package handler;

import java.util.List;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    public <T> List<T> readSerializedObject(String filename);
    public <T> void writeSerializedObject(String filename, List<T> list);

}
