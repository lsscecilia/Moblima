package Controller;

import java.util.List;

/**
 * Interface for UI
 * modifier package-private
 */
public interface HandlerInterface {
    public abstract List readSerializedObject(String filename);
    public abstract void writeSerializedObject(String filename, List list);

}
