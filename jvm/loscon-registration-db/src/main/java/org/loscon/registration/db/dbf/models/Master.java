package org.loscon.registration.db.dbf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class Master {

    public final static List<String> DBFHeaders = Arrays.asList(
            "FNAME", "LNAME", "SUFFIX", "ADDR1", "ADDR2", "CITY", "STATE", "ZIP", "COUNTRY", "ID", "PHONE", "EMAIL", "ADDRSTAT", "MODDATE", "CATEGORY", "BADGENAME", "PREV_CITY", "VANITYNUM", "POSITION"
    );


    public BigDecimal ID;

    public String FNAME;
    public String LNAME;
    public String SUFFIX;
    public String ADDR1;
    public String ADDR2;
    public String CITY;
    public String STATE;
    public String ZIP;
    public String COUNTRY;
    public String PHONE;
    public String EMAIL;
    public BigDecimal ADDRSTAT;
    public Date MODDATE;
    public String CATEGORY;
    public String BADGENAME;
    public String PREV_CITY;
    public String VANITYNUM;
    public String POSITION;

    public Master(String FNAME, String LNAME, String SUFFIX, String ADDR1, String ADDR2, String CITY, String STATE, String ZIP, String COUNTRY, BigDecimal ID, String PHONE, String EMAIL, BigDecimal ADDRSTAT, Date MODDATE, String CATEGORY, String BADGENAME, String PREV_CITY, String VANITYNUM, String POSITION) {
        this.FNAME = FNAME;
        this.LNAME = LNAME;
        this.SUFFIX = SUFFIX;
        this.ADDR1 = ADDR1;
        this.ADDR2 = ADDR2;
        this.CITY = CITY;
        this.STATE = STATE;
        this.ZIP = ZIP;
        this.COUNTRY = COUNTRY;
        this.ID = ID;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.ADDRSTAT = ADDRSTAT;
        this.MODDATE = MODDATE;
        this.CATEGORY = CATEGORY;
        this.BADGENAME = BADGENAME;
        this.PREV_CITY = PREV_CITY;
        this.VANITYNUM = VANITYNUM;
        this.POSITION = POSITION;
    }

    public String toString() {
        LinkedHashMap m = new LinkedHashMap<String, String>();
        m.put("FNAME", this.FNAME);
        m.put("LNAME", this.LNAME);
        m.put("SUFFIX", this.SUFFIX);
        m.put("ADDR1", this.ADDR1);
        m.put("ADDR2", this.ADDR2);
        m.put("CITY", this.CITY);
        m.put("STATE", this.STATE);
        m.put("ZIP", this.ZIP);
        m.put("COUNTRY", this.COUNTRY);
        m.put("ID", this.ID);
        m.put("PHONE", this.PHONE);
        m.put("EMAIL", this.EMAIL);
        m.put("ADDDRSTAT", this.ADDRSTAT);
        m.put("MODDATE", this.MODDATE);
        m.put("CATEGORY", this.CATEGORY);
        m.put("BADGENAME", this.BADGENAME);
        m.put("PREV_CITY", this.PREV_CITY);
        m.put("VANITYNUM", this.VANITYNUM);
        m.put("POSITION", this.POSITION);
        return m.toString();
    }

    public static Master ExtractFromDBFRecord(Object[] dbfrecord) {
        Master m = new Master(
                (String)dbfrecord[DBFHeaders.indexOf("FNAME")],
                (String)dbfrecord[DBFHeaders.indexOf("LNAME")],
                (String)dbfrecord[DBFHeaders.indexOf("SUFFIX")],
                (String)dbfrecord[DBFHeaders.indexOf("ADDR1")],
                (String)dbfrecord[DBFHeaders.indexOf("ADDR2")],
                (String)dbfrecord[DBFHeaders.indexOf("CITY")],
                (String)dbfrecord[DBFHeaders.indexOf("STATE")],
                (String)dbfrecord[DBFHeaders.indexOf("ZIP")],
                (String)dbfrecord[DBFHeaders.indexOf("COUNTRY")],
                (BigDecimal)dbfrecord[DBFHeaders.indexOf("ID")],
                (String)dbfrecord[DBFHeaders.indexOf("PHONE")],
                (String)dbfrecord[DBFHeaders.indexOf("EMAIL")],
                (BigDecimal)dbfrecord[DBFHeaders.indexOf("ADDRSTAT")],
                (Date)dbfrecord[DBFHeaders.indexOf("MODDATE")],
                (String)dbfrecord[DBFHeaders.indexOf("CATEGORY")],
                (String)dbfrecord[DBFHeaders.indexOf("BADGENAME")],
                (String)dbfrecord[DBFHeaders.indexOf("PREV_CITY")],
                (String)dbfrecord[DBFHeaders.indexOf("VANITYNUM")],
                (String)dbfrecord[DBFHeaders.indexOf("POSITION")]
        );
        return m;
    }
}
