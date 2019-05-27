package org.loscon.registration.GasLight2016;

import org.loscon.registration.db.sqlite.ormlite.MembershipType;

import java.util.ArrayList;
import java.util.List;

public class MembershipTypesGenerator {

    public static Object[][] GasLight2016MembershipTypeParts () {
        Object[][] o = {
        //  {"name         description                                onBadge   amount   badgeok,   endDate                         starDate                        key    metaclass, listOrder Thu      Fri      Sat      Sun      timestamp},
            {"COA",        "Report COAs for nonmembers",              "",       "0.00",  "false",   "null",                         "Fri Dec 31 00:00:00 PST 2088", "Z",   "X",       "99.00",  "false", "false", "false", "false", "false"},
            {"Void",       "Void",                                    "",       "0.00",  "false",   "null",                         "Fri Dec 31 00:00:00 PST 2088", "0",   "X",       "999.00", "false", "false", "false", "false", "false"},
            {"K12min",     "K-12, advance from previous Boskone",     "",       "20.00", "true",    "Tue Mar 31 00:00:00 PDT 2015", "Fri Feb 13 00:00:00 PST 2015", "R",   "R",       "7.00",   "false", "false", "false", "false", "false"},
            {"Collmin",    "College, advance from previous Boskone",  "",       "30.00", "true",    "Tue Mar 31 00:00:00 PDT 2015", "Fri Feb 13 00:00:00 PST 2015", "C",   "R",       "4.00",   "false", "false", "false", "false", "false"},
            {"AdultMin",   "Advance, from previous Boskone",          "",       "40.00", "true",    "Tue Mar 31 00:00:00 PDT 2015", "Fri Feb 13 00:00:00 PST 2015", "X",   "R",       "80.00",  "false", "false", "false", "false", "false"},
            {"AdultPre",   "Adult, normal prereg",                    "",       "50.00", "true",    "Tue Jan 19 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "X",   "R",       "82.00",  "false", "false", "false", "false", "false"},
            {"Collpre",    "College Student, normal prereg",          "",       "35.00", "true",    "Tue Jan 19 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "C",   "R",       "5.00",   "true",  "true",  "true",  "false", "false"},
            {"Friday",     "Friday only (for any age)",               "FRI",    "25.00", "true",    "Fri Feb 19 00:00:00 PST 2016", "Wed Jan 20 00:00:00 PST 2016", "F",   "R",       "22.00",  "true",  "true",  "false", "false", "false"},
            {"Dealer",     "Huckster rate",                           "",       "50.00", "true",    "Sun Feb 21 00:00:00 PST 2016", "Fri Feb 13 00:00:00 PST 2015", "Q",   "R",       "21.00",  "false", "false", "false", "false", "false"},
            {"AdultAtCon", "Adult, full weekend",                     "",       "65.00", "true",    "Sat Feb 20 00:00:00 PST 2016", "Tue Jan 20 00:00:00 PST 2015", "A",   "",        "2.00",   "true",  "true",  "true",  "false", "false"},
            {"AdultSat",   "Adult Saturday",                          "SAT",    "45.00", "true",    "Sat Feb 20 00:00:00 PST 2016", "Fri Feb 19 00:00:00 PST 2016", "J",   "R",       "30.00",  "false", "false", "true",  "false", "false"},
            {"KIT",        "Kid-in-Tow (with parent)",                "Kid",    "0.01",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Fri Feb 13 00:00:00 PST 2015", "K",   "R",       "10.00",  "true",  "true",  "true",  "true",  "false"},
            {"Staff",      "Staff",                                   "Staff",  "40.00", "true",    "Sun Feb 21 00:00:00 PST 2016", "Fri Feb 13 00:00:00 PST 2015", "S",   "R",       "20.00",  "true",  "true",  "true",  "true",  "false"},
            {"Sunday",     "Sunday only (for any age)",               "SUN",    "25.00", "true",    "Sun Feb 21 00:00:00 PST 2016", "Sun Feb 21 00:00:00 PST 2016", "N",   "R",       "40.00",  "false", "false", "false", "true",  "false"},
            {"Fri&Sunday", "Friday & Sunday all ages",                "",       "50.00", "true",    "Sun Feb 21 00:00:00 PST 2016", "Fri Feb 19 00:00:00 PST 2016", "H",   "R",       "52.00",  "false", "false", "false", "true",  "false"},
            {"ProgPart",   "Program Participant",                     "Pgm",    "0.00",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Thu Feb 19 00:00:00 PST 2015", "P",   "G",       "60.00",  "true",  "true",  "true",  "true",  "false"},
            {"Rollover",   "Rollover membership",                     "",       "0.00",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Thu Feb 19 00:00:00 PST 2015", "R",   "R",       "71.00",  "false", "true",  "true",  "true",  "false"},
            {"K12",        "K-12 (with ID or parent)",                "",       "25.00", "true",    "Sat Feb 20 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "D",   "R",       "6.00",   "true",  "true",  "true",  "false", "false"},
            {"SvcAnimal",  "Working (service) animals",               "SvcDog", "0.01",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Thu Feb 19 00:00:00 PST 2015", "V",   "X",       "90.00",  "false", "true",  "true",  "true",  "false"},
            {"Mascot",     "Stuffed animals, etc.",                   "Mascot", "5.00",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Thu Feb 19 00:00:00 PST 2015", "M",   "X",       "91.00",  "false", "true",  "true",  "true",  "false"},
            {"CollAtCon",  "College student and active military (ID)","",       "40.00", "true",    "Sat Feb 20 00:00:00 PST 2016", "Wed Jan 20 00:00:00 PST 2016", "C",   "R",       "17.00",  "false", "false", "false", "false", "false"},
            {"Guest",      "GOHs and former GOHs",                    "",       "0.00",  "true",    "Sun Feb 21 00:00:00 PST 2016", "Thu Feb 19 00:00:00 PST 2015", "G",   "G",       "70.00",  "false", "true",  "true",  "true",  "false"},
            {"Life",       "Life Members",                            "",       "0.00",  "true",    "null",                         "Fri Dec 31 00:00:00 PST 2088", "X",   "G",       "72.00",  "false", "true",  "true",  "true",  "false"},
            {"Carryover",  "Carryover membership",                    "",       "0.00",  "true",    "Mon Feb 15 00:00:00 PST 2016", "Sun Feb 15 00:00:00 PST 2015", "X",   "G",       "8.00",   "false", "true",  "true",  "true",  "false"},
            {"K12Pre",     "K-12, normal prereg",                     "",       "25.00", "true",    "Tue Jan 19 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "X",   "G",       "3.00",   "false", "true",  "true",  "true",  "false"},
            {"College",    "Full college, regardless of amount paid", "",       "45.00", "true",    "Tue Jan 19 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "X",   "G",       "3.00",   "false", "true",  "true",  "true",  "false"},
            {"FormerGOH",  "Former GoH",                              "",       "0.00",  "true",    "Tue Jan 19 00:00:00 PST 2016", "Wed Apr 01 00:00:00 PDT 2015", "X",   "G",       "3.00",   "false", "true",  "true",  "true",  "false"},
            {"Comp",       "Complimentary membership",                "",       "0.00",  "true",    "null",                         "null",                         "B",   "",        "94.00",  "false", "false", "false", "false", "false"},
            {"Barred",     "Do not register! Call for help!",         "VOID",   "0.00",  "false",   "null",                         "null",                         "",    "",        "0.00",   "false", "false", "false", "false", "false"},
            {"Test",       "Testing records",                         "",       "1.00",  "true",    "Sun Jan 31 00:00:00 PST 2016", "Fri Jan 01 00:00:00 PST 2016", "T",   "",        "123.00", "false", "false", "false", "false", "false"}
        };
        return o;
    }
}
