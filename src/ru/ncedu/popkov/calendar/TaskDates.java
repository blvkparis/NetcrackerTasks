package ru.ncedu.popkov.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Class formatter from string to Date or Calendar
 *
 * @author Anton Popkov
 */
public class TaskDates {
    /**
     * Method that converts string date to actual Date object
     *
     * @param inputString string with date in <Year><Month><Day> or <Hours><Minutes> format
     * @return Date object
     */
    public static Date createDateFromString(String inputString) {
        SimpleDateFormat patternDate = new SimpleDateFormat("yyyyMMMMdd", Locale.ENGLISH);
        SimpleDateFormat patternTime = new SimpleDateFormat("hhmm", Locale.ENGLISH);

        Date result = null;
        SimpleDateFormat[] formats = {patternDate, patternTime};

        try {
            result = patternTime.parse(inputString);
            result = patternDate.parse(inputString);
        } catch (Exception ignored) {

        }
        return result;
    }

    /**
     * Method that converts string date to actual Calendar object
     *
     * @param inputString string with date in <Year><Month><Day> or <Hours><Minutes> format
     * @return Calendar object
     */
    public static Calendar createCalendarFromString(String inputString) {
        Calendar outputDate = new GregorianCalendar();
        outputDate.setTime(createDateFromString(inputString));
        return outputDate;
    }
}
