package Entity;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @version 1
 * @since 2019-11-13
 * @typeofclass entity
 */
public class PublicHoliday implements Serializable {

    /**
     * serial version ID to match file i/o, ensures the right version is used
     */
    private static final long serialVersionUID = -79339066882145601L;

    /**
     * date of this public holiday
     */
    private LocalDate date;
    /**
     * name of this holiday name
     */
    private String holidayName;

    /**
     * creates public holiday with given date and holiday name
     * @param date
     * @param holidayName
     */
    public PublicHoliday(LocalDate date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }

    /**
     * get date for this public holiday
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * get holiday name for this public holiday
     * @return
     */
    public String getHolidayName() {
        return holidayName;
    }

}
