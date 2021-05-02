package ru.ncedu.popkov.person;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Main class
 *
 * @author Anton Popkov
 */
public class PersonMain {
    public static void main(String[] args) {
        Calendar birth = new GregorianCalendar(1960, Calendar.JANUARY, 1);
        Person person = new Person(birth);

        String pattern1 = "dd-MM-YYYY";
        String pattern2 = "dd MMMM yyyy";
        String pattern3 = "dd MMMM yyyy HH:mm:ss";

        System.out.println(person.formattedDate(pattern3));
        //System.out.println(person.getDayName());
    }
}
