package org.loscon.registration;

import org.loscon.registration.core.ParseUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

public class Convention {
    private String name;
    private Date startDate;

    public void setFromProperties(Properties properties) throws ParseException {
        name = properties.getProperty("CONVENTION");
        String startDateString = properties.getProperty("STARTDATE");
        if (startDateString != null && startDateString.length() != 0 && !startDateString.toUpperCase().equals("NULL")) {
            startDate = ParseUtils.Date_from_DBFDateString(startDateString);
        }
    }
}
