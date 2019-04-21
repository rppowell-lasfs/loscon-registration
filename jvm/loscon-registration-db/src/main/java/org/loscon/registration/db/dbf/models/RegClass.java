package org.loscon.registration.db.dbf.models;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class RegClass {

    public final static List<String> DBFHeaders = Arrays.asList(
            //"AMOUNT", "BADGEOK", "CLASS", "EDATE", "FRIDAY", "KEY", "METACLASS", "NAME", "ONBADGE", "ORDER", "SATURDAY", "SDATE", "SUNDAY", "THURSDAY", "TIMESTAMP"
            "ORDER", "KEY", "CLASS", "SDATE", "EDATE", "AMOUNT", "METACLASS", "BADGEOK", "TIMESTAMP", "ONBADGE", "NAME", "FRIDAY", "SATURDAY", "SUNDAY", "THURSDAY"
    );

    public long ID;

    public BigDecimal amount;
    public boolean badgeOk;
    public String registrationClass;
    public Date eDate;
    public boolean isAvailableFriday;
    public String key;
    public String metaClass;
    public String registrationDescription;
    public String displayOnBadge;
    public BigDecimal listOrder;
    public boolean isAvailableSaturday;
    public Date sDate;
    public boolean isAvailableSunday;
    public boolean isAvailableThursday;
    public boolean hasTimestamp;


    public RegClass(
            String registrationClass,
            String registrationDescription,
            String displayOnBadge,
            BigDecimal amount,
            boolean badgeOk,
            Date eDate,
            Date sDate,
            String key,
            String metaClass,
            BigDecimal listOrder,
            boolean isAvailableThursday,
            boolean isAvailableFriday,
            boolean isAvailableSaturday,
            boolean isAvailableSunday,
            boolean hasTimestamp
    ) {
        this.registrationClass = registrationClass;
        this.registrationDescription = registrationDescription;
        this.displayOnBadge = displayOnBadge;
        this.amount = amount;
        this.badgeOk = badgeOk;
        this.eDate = eDate;
        this.sDate = sDate;
        this.key = key;
        this.metaClass = metaClass;
        this.listOrder = listOrder;
        this.isAvailableThursday = isAvailableThursday;
        this.isAvailableFriday = isAvailableFriday;
        this.isAvailableSaturday = isAvailableSaturday;
        this.isAvailableSunday = isAvailableSunday;
        this.hasTimestamp = hasTimestamp;
    }

    public String toString() {
        LinkedHashMap m = new LinkedHashMap<String, String>();
        m.put("registrationClass", this.registrationClass);
        m.put("registrationDescription", this.registrationDescription);
        m.put("displayOnBadge", this.displayOnBadge);
        m.put("amount", this.amount);
        m.put("badgeOk", this.badgeOk);
        m.put("eDate", this.eDate);
        m.put("sDate", this.sDate);
        m.put("key", this.key);
        m.put("metaClass", this.metaClass);
        m.put("listOrder", this.listOrder);
        m.put("isAvailableThursday", this.isAvailableThursday);
        m.put("isAvailableFriday", this.isAvailableFriday);
        m.put("isAvailableSaturday", this.isAvailableSaturday);
        m.put("isAvailableSunday", this.isAvailableSunday);
        m.put("hasTimestamp", this.hasTimestamp);
        return m.toString();
    }

    public String oldToString() {
        return Arrays.asList(
                this.registrationClass,
                this.registrationDescription,
                this.displayOnBadge,
                String.valueOf(this.amount),
                String.valueOf(this.badgeOk),
                (eDate != null) ? eDate.toString() : "null",
                (sDate != null) ? sDate.toString() : "null",
                this.key,
                this.metaClass,
                String.valueOf(this.listOrder),
                String.valueOf(this.isAvailableThursday),
                String.valueOf(this.isAvailableFriday),
                String.valueOf(this.isAvailableSaturday),
                String.valueOf(this.isAvailableSunday)
        ).toString();
    }

    public static RegClass ExtractFromDBFRecord(Object[] dbfrecord) {
        RegClass r = new RegClass(
                (String)dbfrecord[DBFHeaders.indexOf("CLASS")], // String registrationClass,
                (String)dbfrecord[DBFHeaders.indexOf("NAME")], // String registrationDescription,
                (String)dbfrecord[DBFHeaders.indexOf("ONBADGE")], // String displayOnBadge,
                (BigDecimal)dbfrecord[DBFHeaders.indexOf("AMOUNT")], // Double amount,
                (boolean)dbfrecord[DBFHeaders.indexOf("BADGEOK")], // boolean badgeOk,
                (Date)dbfrecord[DBFHeaders.indexOf("EDATE")], // Date eDate,
                (Date)dbfrecord[DBFHeaders.indexOf("SDATE")], // Date sDate,
                (String)dbfrecord[DBFHeaders.indexOf("KEY")], // String key,
                (String)dbfrecord[DBFHeaders.indexOf("METACLASS")], // String metaClass,
                (BigDecimal)dbfrecord[DBFHeaders.indexOf("ORDER")], // Double listOrder,
                (dbfrecord[DBFHeaders.indexOf("THURSDAY")] != null) ? ((boolean)dbfrecord[DBFHeaders.indexOf("THURSDAY")]) : false,
                (dbfrecord[DBFHeaders.indexOf("FRIDAY")] != null) ? ((boolean)dbfrecord[DBFHeaders.indexOf("FRIDAY")]) : false,
                (dbfrecord[DBFHeaders.indexOf("SATURDAY")] != null) ? ((boolean)dbfrecord[DBFHeaders.indexOf("SATURDAY")]) : false,
                (dbfrecord[DBFHeaders.indexOf("SUNDAY")] != null) ? ((boolean)dbfrecord[DBFHeaders.indexOf("SUNDAY")]) : false,
                (boolean)dbfrecord[DBFHeaders.indexOf("TIMESTAMP")]  // boolean hasTimestamp
        );
        return r;
    }
}
