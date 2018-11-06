package dk.eplusi.dev.enrollments.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtility {
    private static final Integer THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    private static final Integer THIS_MONTH = Calendar.getInstance().get(Calendar.MONTH);
    private static final Integer DAY_OF_THIS_MONTH = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


    public static int getThisYear() {
        return getYearFromThisYear(0);
    }

    public static int getYearFromThisYear(int diff) {
        int result = THIS_YEAR + diff;
        if(result < 1)
            throw new IllegalArgumentException("The value of YEAR must be positve.");
        return result;
    }

    public static int getThisMonth() {
        return THIS_MONTH;
    }

    public static List<Integer> getMonths() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }

    public static List<Integer> getDays() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
    }

    public static Date getToday() {
        long time = System.currentTimeMillis();
        return new Date(time);
    }

    public static Date parse(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }

    public static Date parse(int year, int month, int day) throws ParseException {
        String monthStr = String.valueOf(month);
        if(month < 10)
            monthStr = "0" + monthStr;

        String dayStr = String.valueOf(day);
        if(day < 10)
            dayStr = "0" + dayStr;

        return parse(year + "-" + monthStr + "-" + dayStr);
    }

    public static Date parseYear(int year) throws ParseException {
        return parseYear(String.valueOf(year));
    }

    public static Date parseYear(String year) throws ParseException {
        return new SimpleDateFormat("yyyy").parse(year);
    }

    public static Date getFirstDay(int year) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(year + "-01-01");
    }

    public static Date getLastDay(int year) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(year + "-12-31");
    }

    public static Date getFirstDay(int year, int month) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
    }

    public static Date getLastDay(int year, int month) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return parse(year, month, lastDay);
    }
}
