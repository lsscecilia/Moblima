package Entity;


/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class PublicHoliday {

    private String date;
    private String holidayName;

    public PublicHoliday(String date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }
//should create a method to toggle holiday in the public holiday controller class

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}
