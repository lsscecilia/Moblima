package Controller;

import Entity.PublicHoliday;
import Entity.ShowTime;
import Handler.DataHandler;
import Handler.HandlerInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PublicHolidayController implements ControllerInterface {
    private HandlerInterface database;
    private ArrayList<PublicHoliday> publicHolidayArrayList;

    public PublicHolidayController()
    {
        database = new DataHandler();
        publicHolidayArrayList = database.readSerializedObject("PublicHoliday");

    }

    /**
     * Checks if the date is the eve of a public holiday
     * @param date
     * @return
     */
    public boolean evePublicHoliday(LocalDate date)
    {
        LocalDate eve;
        for (PublicHoliday publicHoliday: publicHolidayArrayList)
        {
            eve = publicHoliday.getDate().minusDays(1);
            if (date.compareTo(publicHoliday.getDate())==0)
                return true;
            if (date.compareTo(eve)==0)
                return true;
        }
        return false;
    }

    /**
     * Displays all public holiday
     */
    public void displayAllPublicHoliday(){
        for(PublicHoliday publicHoliday:publicHolidayArrayList){
            System.out.println(publicHolidayArrayList.indexOf(publicHoliday)+1);
            System.out.println("Public Holiday Name: " + publicHoliday.getHolidayName());
            System.out.println("Date: " + publicHoliday.getDate().toString() + "\n");
        }
    }

    /**
     * Adds new public holiday
     * @param holidayName
     * @param date
     */
    public void addNewPublicHoliday(String holidayName, String date){

        int[] dateArray = Stream.of((date).split(",")).mapToInt(Integer::parseInt).toArray(); //year,month,day
        LocalDate localDate = LocalDate.of(dateArray[0], dateArray[1], dateArray[2]);
        PublicHoliday publicHoliday = new PublicHoliday(localDate, holidayName);
        publicHolidayArrayList.add(publicHoliday);
        updateDat();
    }

    /** Removes Existing Public Holiday
     *
     * @param arrayIndex
     */
    public boolean removePublicHoliday(int arrayIndex){
        if(publicHolidayArrayList.isEmpty()){
            System.out.println("ArrayList is empty!");
        }
        else if(arrayIndex>publicHolidayArrayList.size()-1){
            System.out.println("You have chosen the wrong index!");
        }
        else{
            publicHolidayArrayList.remove(arrayIndex);
            updateDat();
            return true;
        }
        return false;
    }



    /**
     * After a user has chosen to modify the ArrayList such as deletion or addition, it will call this method
     * to write the ArrayList into the DAT file using DataHandler.
     */
    @Override
    public void updateDat() {
        database.writeSerializedObject("PublicHoliday", publicHolidayArrayList);
    }
}
