package dk.eplusi.dev.enrollments.common;

import org.springframework.security.core.parameters.P;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final Integer THIS_YEAR = CALENDAR.get(Calendar.YEAR);

    public static Date getThisYear() throws ParseException {
        return new SimpleDateFormat("yyyy").parse(String.valueOf(THIS_YEAR));
    }

    public static Date getNextYear() throws ParseException {
        return new SimpleDateFormat("yyyy").parse(String.valueOf(THIS_YEAR + 1));
    }

    public static Date getToday() {
        long time = System.currentTimeMillis();
        return new Date(time);
    }

    public static Date parse(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
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
        return parse(year + "-" + month + "-" + lastDay);
    }
}
