package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DBFUtils {

    static public List<String> extractTableHeaderNames(DBFReader reader) throws DBFException {
        ArrayList<String> headerNames = null;

        if (reader != null) {
            headerNames = new ArrayList<String>();

            // TODO: verify MasterDBF Header & Field Types

            int i;
            for(i = 0; i<reader.getFieldCount(); i++) {
                headerNames.add(reader.getField(i).getName());
                //System.out.println(reader.getField(i).getName() + ": " + reader.getField(i).getDataType());
            }
        }
        return headerNames;
    }

    public final static List<String> RegistrationClassDBFHeader = Arrays.asList(
            //"AMOUNT", "BADGEOK", "CLASS", "EDATE", "FRIDAY", "KEY", "METACLASS", "NAME", "ONBADGE", "ORDER", "SATURDAY", "SDATE", "SUNDAY", "THURSDAY", "TIMESTAMP"
            "ORDER", "KEY", "CLASS", "SDATE", "EDATE", "AMOUNT", "METACLASS", "BADGEOK", "TIMESTAMP", "ONBADGE", "NAME", "FRIDAY", "SATURDAY", "SUNDAY", "THURSDAY"
    );

    public final static List<String> MemberDBFHeader = Arrays.asList(
            "CLASS", "NUMBER", "LNAME", "FNAME", "ADDR1", "ADDR2", "CITY", "STATE", "ZIP", "COUNTRY", "ENTERED", "AMOUNT", "EMAIL", "BADGE1", "BADGE2", "NOTES", "ID", "PICKEDUP", "VERSION"
    );

    public final static List<String> MasterDBFHeader = Arrays.asList(
            "FNAME", "LNAME", "SUFFIX", "ADDR1", "ADDR2", "CITY", "STATE", "ZIP", "COUNTRY", "ID", "PHONE", "EMAIL", "ADDRSTAT", "MODDATE", "CATEGORY", "BADGENAME", "PREV_CITY", "VANITYNUM", "POSITION"
    );

    public static RegistrationClass RegistrationClassFromDBFRecord(Object[] dbfrecord) {
        RegistrationClass r = new RegistrationClass(
                (String)dbfrecord[RegistrationClassDBFHeader.indexOf("CLASS")], // String registrationClass,
                (String)dbfrecord[RegistrationClassDBFHeader.indexOf("NAME")], // String registrationDescription,
                (String)dbfrecord[RegistrationClassDBFHeader.indexOf("ONBADGE")], // String displayOnBadge,
                (BigDecimal)dbfrecord[RegistrationClassDBFHeader.indexOf("AMOUNT")], // Double amount,
                (boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("BADGEOK")], // boolean badgeOk,
                (Date)dbfrecord[RegistrationClassDBFHeader.indexOf("EDATE")], // Date eDate,
                (Date)dbfrecord[RegistrationClassDBFHeader.indexOf("SDATE")], // Date sDate,
                (String)dbfrecord[RegistrationClassDBFHeader.indexOf("KEY")], // String key,
                (String)dbfrecord[RegistrationClassDBFHeader.indexOf("METACLASS")], // String metaClass,
                (BigDecimal)dbfrecord[RegistrationClassDBFHeader.indexOf("ORDER")], // Double listOrder,
                (dbfrecord[RegistrationClassDBFHeader.indexOf("THURSDAY")] != null) ? ((boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("THURSDAY")]) : false,
                (dbfrecord[RegistrationClassDBFHeader.indexOf("FRIDAY")] != null) ? ((boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("FRIDAY")]) : false,
                (dbfrecord[RegistrationClassDBFHeader.indexOf("SATURDAY")] != null) ? ((boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("SATURDAY")]) : false,
                (dbfrecord[RegistrationClassDBFHeader.indexOf("SUNDAY")] != null) ? ((boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("SUNDAY")]) : false,
                (boolean)dbfrecord[RegistrationClassDBFHeader.indexOf("TIMESTAMP")]  // boolean hasTimestamp
        );
        return r;
    }

    public static Member MemberFromMemberDBFRecord(Object[] dbfrecord) {
        Member m = new Member(
                (String)dbfrecord[MemberDBFHeader.indexOf("CLASS")],
                (BigDecimal)dbfrecord[MemberDBFHeader.indexOf("NUMBER")],
                (String)dbfrecord[MemberDBFHeader.indexOf("LNAME")],
                (String)dbfrecord[MemberDBFHeader.indexOf("FNAME")],
                (String)dbfrecord[MemberDBFHeader.indexOf("ADDR1")],
                (String)dbfrecord[MemberDBFHeader.indexOf("ADDR2")],
                (String)dbfrecord[MemberDBFHeader.indexOf("CITY")],
                (String)dbfrecord[MemberDBFHeader.indexOf("STATE")],
                (String)dbfrecord[MemberDBFHeader.indexOf("ZIP")],
                (String)dbfrecord[MemberDBFHeader.indexOf("COUNTRY")],
                (String)dbfrecord[MemberDBFHeader.indexOf("ENTERED")],
                (BigDecimal)dbfrecord[MemberDBFHeader.indexOf("AMOUNT")],
                (String)dbfrecord[MemberDBFHeader.indexOf("EMAIL")],
                (String)dbfrecord[MemberDBFHeader.indexOf("BADGE1")],
                (String)dbfrecord[MemberDBFHeader.indexOf("BADGE2")],
                (String)dbfrecord[MemberDBFHeader.indexOf("NOTES")]
        );
        return m;
    }

    public static Master MasterFromMasterDBFRecord(Object[] dbfrecord) {
        Master m = new Master(
                (String)dbfrecord[MasterDBFHeader.indexOf("FNAME")],
                (String)dbfrecord[MasterDBFHeader.indexOf("LNAME")],
                (String)dbfrecord[MasterDBFHeader.indexOf("SUFFIX")],
                (String)dbfrecord[MasterDBFHeader.indexOf("ADDR1")],
                (String)dbfrecord[MasterDBFHeader.indexOf("ADDR2")],
                (String)dbfrecord[MasterDBFHeader.indexOf("CITY")],
                (String)dbfrecord[MasterDBFHeader.indexOf("STATE")],
                (String)dbfrecord[MasterDBFHeader.indexOf("ZIP")],
                (String)dbfrecord[MasterDBFHeader.indexOf("COUNTRY")],
                (BigDecimal)dbfrecord[MasterDBFHeader.indexOf("ID")],
                (String)dbfrecord[MasterDBFHeader.indexOf("PHONE")],
                (String)dbfrecord[MasterDBFHeader.indexOf("EMAIL")],
                (BigDecimal)dbfrecord[MasterDBFHeader.indexOf("ADDRSTAT")],
                (Date)dbfrecord[MasterDBFHeader.indexOf("MODDATE")],
                (String)dbfrecord[MasterDBFHeader.indexOf("CATEGORY")],
                (String)dbfrecord[MasterDBFHeader.indexOf("BADGENAME")],
                (String)dbfrecord[MasterDBFHeader.indexOf("PREV_CITY")],
                (String)dbfrecord[MasterDBFHeader.indexOf("VANITYNUM")],
                (String)dbfrecord[MasterDBFHeader.indexOf("POSITION")]
        );
        return m;
    }
}
