package org.loscon.registration.db.dbf.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class RegkitMember {
    public final static List<String> DBFHeaders = Arrays.asList(
            "NUMBER", "FNAME", "LNAME",
            "ADDR1", "ADDR2", "CITY", "STATE", "ZIP", "COUNTRY",
            "PHONE", "EMAIL",
            "ID", "BADGE1", "BADGE2", "NOTES",
            "CLASS", "AMOUNT", "PICKEDUP", "ENTERED", "VERSION", "TYPE", "PMT_METHOD"
    );

    public BigDecimal NUMBER;
    public String FNAME;
    public String LNAME;

    public String ADDR1;
    public String ADDR2;
    public String CITY;
    public String STATE;
    public String ZIP;
    public String COUNTRY;

    public String PHONE;
    public String EMAIL;

    public BigDecimal ID;
    public String BADGE1;
    public String BADGE2;
    public String NOTES;

    public String CLASS;
    public BigDecimal AMOUNT;
    public String PICKEDUP;
    public String ENTERED;
    public String VERSION;
    public String TYPE;
    public String PMT_METHOD;


    public RegkitMember(BigDecimal NUMBER, String FNAME, String LNAME, String ADDR1, String ADDR2, String CITY, String STATE, String ZIP, String COUNTRY, String PHONE, String EMAIL, BigDecimal ID, String BADGE1, String BADGE2, String NOTES, String CLASS, BigDecimal AMOUNT, String PICKEDUP, String ENTERED, String VERSION, String TYPE, String PMT_METHOD) {
        this.NUMBER = NUMBER;
        this.FNAME = FNAME;
        this.LNAME = LNAME;

        this.ADDR1 = ADDR1;
        this.ADDR2 = ADDR2;
        this.CITY = CITY;
        this.STATE = STATE;
        this.ZIP = ZIP;
        this.COUNTRY = COUNTRY;

        this.PHONE = PHONE;
        this.EMAIL = EMAIL;

        this.ID = ID;
        this.BADGE1 = BADGE1;
        this.BADGE2 = BADGE2;
        this.NOTES = NOTES;

        this.CLASS = CLASS;
        this.AMOUNT = AMOUNT;
        this.PICKEDUP = PICKEDUP;
        this.ENTERED = ENTERED;
        this.VERSION = VERSION;
        this.TYPE = TYPE;
        this.PMT_METHOD = PMT_METHOD;
    }


    public String toString() {
        LinkedHashMap m = new LinkedHashMap<String, String>();

        m.put("NUMBER", this.NUMBER);
        m.put("FNAME", this.FNAME);
        m.put("LNAME", this.LNAME);

        m.put("ADDR1", this.ADDR1);
        m.put("ADDR2", this.ADDR2);
        m.put("CITY", this.CITY);
        m.put("STATE", this.STATE);
        m.put("ZIP", this.ZIP);
        m.put("COUNTRY", this.COUNTRY);

        m.put("PHONE", this.PHONE);
        m.put("EMAIL", this.EMAIL);

        m.put("ID", this.ID);
        m.put("BADGE1", this.BADGE1);
        m.put("BADGE2", this.BADGE2);
        m.put("NOTES", this.NOTES);

        m.put("CLASS", this.CLASS);
        m.put("AMOUNT", this.AMOUNT);
        m.put("PICKEDUP", this.PICKEDUP);
        m.put("ENTERED", this.ENTERED);
        m.put("VERSION", this.VERSION);
        m.put("TYPE", this.TYPE);
        m.put("PMT_METHOD", this.PMT_METHOD);

        return m.toString();
    }

    public static RegkitMember ExtractFromMemberDBFRecord(Object[] dbfrecord) {
        RegkitMember m = new RegkitMember(
                (BigDecimal)dbfrecord[RegkitMember.DBFHeaders.indexOf("NUMBER")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("FNAME")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("LNAME")],

                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("ADDR1")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("ADDR2")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("CITY")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("STATE")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("ZIP")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("COUNTRY")],

                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("PHONE")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("EMAIL")],

                (BigDecimal)dbfrecord[RegkitMember.DBFHeaders.indexOf("ID")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("BADGE1")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("BADGE2")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("NOTES")],

                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("CLASS")],
                (BigDecimal)dbfrecord[RegkitMember.DBFHeaders.indexOf("AMOUNT")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("PICKEDUP")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("ENTERED")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("VERSION")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("TYPE")],
                (String)dbfrecord[RegkitMember.DBFHeaders.indexOf("PMT_METHOD")]
                );
        return m;
    }
}
