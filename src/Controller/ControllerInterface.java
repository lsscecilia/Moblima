package Controller;

import java.util.ArrayList;

public interface ControllerInterface {
    /**
     * Display logical information from the Controller class after the user has choose an option in the UI
     */
    public void display();

    /**
     * After a user has chosen to modify the ArrayList such as deletion or addition, it will call this method
     * to write the ArrayList into the DAT file using DataHandler.
     */
    public void updateDat();
}
