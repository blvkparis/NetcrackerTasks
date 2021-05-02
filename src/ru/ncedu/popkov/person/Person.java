package ru.ncedu.popkov.person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Represents Person class
 *
 * @author Anton Popkov
 */
public class Person {
    private Calendar birthDate;

    /**
     * Default constructor
     */
    public Person() {

    }

    /**
     * Constructor with parameters
     *
     * @param birthDate Person's birthday
     */
    public Person(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Method that returns the string value of the day of the week
     *
     * @return the string value of the day of the week
     */
    public String getDayName() {
        birthDate.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        return formatter.format(birthDate.getTime());
    }

    @Override
    public String toString() {
        return "Birth Date - " + birthDate.getTime();
    }

    /**
     * Method that returns the formatted string of Person's birthday<br><br>
     * <p>
     * Sample formats:
     * <li>01-01-1960 - "dd-MM-YYYY"</li>
     * <li>01 January 1960 - "dd MMMM yyyy"</li>
     * <li>01 January 1960 00:00:00 - "yyyy-MM-dd HH:mm:ss"</li>
     *
     * @param pattern template for string
     * @return formatted string
     */
    public String formattedDate(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return formatter.format(birthDate.getTime());
    }
}
