package org.loscon.registration.db.dbf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Member {

    public final static List<String> DBFHeaders = Arrays.asList(
            "CLASS", "NUMBER", "LNAME", "FNAME", "ADDR1", "ADDR2", "CITY", "STATE", "ZIP", "COUNTRY", "ENTERED", "AMOUNT", "EMAIL", "BADGE1", "BADGE2", "NOTES", "ID", "PICKEDUP", "VERSION"
    );

    @Id
    @Column(name="id")
    public BigDecimal NUMBER;

    @Column(nullable = false)
    public String FNAME;
    @Column(nullable = false)
    public String LNAME;

    public String CLASS;

    public String ADDR1;
    public String ADDR2;
    public String CITY;
    public String STATE;
    public String ZIP;
    public String COUNTRY;

    public String ENTERED;
    public BigDecimal AMOUNT;
    public String EMAIL;
    public String BADGE1;
    public String BADGE2;
    public String NOTES;

    public Member(String CLASS, BigDecimal NUMBER, String LNAME, String FNAME, String ADDR1, String ADDR2, String CITY, String STATE, String ZIP, String COUNTRY, String ENTERED, BigDecimal AMOUNT, String EMAIL, String BADGE1, String BADGE2, String NOTES) {
        this.CLASS = CLASS;
        this.NUMBER = NUMBER;
        this.LNAME = LNAME;
        this.FNAME = FNAME;
        this.ADDR1 = ADDR1;
        this.ADDR2 = ADDR2;
        this.CITY = CITY;
        this.STATE = STATE;
        this.ZIP = ZIP;
        this.COUNTRY = COUNTRY;
        this.ENTERED = ENTERED;
        this.AMOUNT = AMOUNT;
        this.EMAIL = EMAIL;
        this.BADGE1 = BADGE1;
        this.BADGE2 = BADGE2;
        this.NOTES = NOTES;
    }


    public String toString() {
        LinkedHashMap m = new LinkedHashMap<String, String>();
        m.put("CLASS", this.CLASS);
        m.put("NUMBER", this.NUMBER);
        m.put("LNAME", this.LNAME);
        m.put("FNAME", this.FNAME);
        m.put("ADDR1", this.ADDR1);
        m.put("ADDR2", this.ADDR2);
        m.put("CITY", this.CITY);
        m.put("STATE", this.STATE);
        m.put("ZIP", this.ZIP);
        m.put("COUNTRY", this.COUNTRY);
        m.put("ENTERED", this.ENTERED);
        m.put("AMOUNT", this.AMOUNT);
        m.put("EMAIL", this.EMAIL);
        m.put("BADGE1", this.BADGE1);
        m.put("BADGE2", this.BADGE2);
        m.put("NOTES", this.NOTES);
        return m.toString();
    }

    public static Member ExtractFromMemberDBFRecord(Object[] dbfrecord) {
        Member m = new Member(
                (String)dbfrecord[Member.DBFHeaders.indexOf("CLASS")],
                (BigDecimal)dbfrecord[Member.DBFHeaders.indexOf("NUMBER")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("LNAME")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("FNAME")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("ADDR1")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("ADDR2")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("CITY")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("STATE")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("ZIP")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("COUNTRY")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("ENTERED")],
                (BigDecimal)dbfrecord[Member.DBFHeaders.indexOf("AMOUNT")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("EMAIL")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("BADGE1")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("BADGE2")],
                (String)dbfrecord[Member.DBFHeaders.indexOf("NOTES")]
        );
        return m;
    }

}
