package ru.ncedu.popkov.calendar;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anton Popkov
 */
class TaskDatesTest {

    @Test
    public void createDateFromString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hhmm");

        Date date1 = new Date(71, Calendar.JANUARY, 3);
        Date date2 = new Date(-100, Calendar.APRIL, 15);
        Date date3 = sdf.parse("2140");

        Date actualDate1 = TaskDates.createDateFromString("1971January03");
        Date actualDate2 = TaskDates.createDateFromString("1800April15");
        Date actualDate3 = TaskDates.createDateFromString("2140");


        assertEquals(date1, actualDate1,
                date1 + " and " + actualDate1 + " are equals!");
        assertEquals(date2, actualDate2,
                date2 + " and " + actualDate2 + " are equals!");
        assertEquals(date3, actualDate3,
                date3 + " and " + actualDate3 + " are equals!");
    }

    @Test
    public void createCalendarFromString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hhmm");

        Calendar date1 = new GregorianCalendar(1971, Calendar.JANUARY, 3);
        Calendar date2 = new GregorianCalendar(1800, Calendar.APRIL, 15);
        Calendar date3 = new GregorianCalendar();
        date3.setTime(sdf.parse("2140"));

        Calendar actualDate1 = TaskDates.createCalendarFromString("1971January03");
        Calendar actualDate2 = TaskDates.createCalendarFromString("1800April15");
        Calendar actualDate3 = TaskDates.createCalendarFromString("2140");

        assertEquals(date1, actualDate1,
                date1 + " and " + actualDate1 + " are equals!");
        assertEquals(date2, actualDate2,
                date2 + " and " + actualDate2 + " are equals!");
        assertEquals(date3, actualDate3,
                date3 + " and " + actualDate3 + " are equals!");
    }
}