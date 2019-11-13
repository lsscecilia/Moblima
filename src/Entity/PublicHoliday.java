package Entity;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @version 1
 * @since 17/10/2019
 * @typeofclass entity
 */
public class PublicHoliday implements Serializable {

    private LocalDate date;
    private String holidayName;

    public PublicHoliday(LocalDate date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }

    //should create a method to toggle holiday in the public holiday controller class

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}
