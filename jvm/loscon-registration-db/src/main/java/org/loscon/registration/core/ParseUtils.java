package org.loscon.registration.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseUtils {
    public static Date Date_yyyyMMdd(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(s);
    }
    public static Date Date_from_DBFDateString(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM 0d HH:mm:ss z yyyy");
        return format.parse(s);
    }

}
