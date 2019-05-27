package org.loscon.registration;

import org.loscon.registration.core.ParseUtils;
import org.loscon.registration.db.sqlite.ormlite.MembershipType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MembershipTypesFactory {

    public static List<MembershipType> defaultMembershipTypes() throws ParseException {
        List<MembershipType> defaultMembershipTypes = new ArrayList<>();

        //MembershipType newMembershipType = new MembershipType();
        // {
        //  registrationClass=Test, registrationDescription=Testing records, displayOnBadge=, amount=1.00,
        //  badgeOk=true, eDate=Sun Jan 31 00:00:00 PST 2016, sDate=Fri Jan 01 00:00:00 PST 2016,
        //  key=T, metaClass=, listOrder=123.00,
        //  \isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false,
        //  hasTimestamp=false
        // }

        MembershipType.Builder b = new MembershipType.Builder();

        MembershipType membershipType = new MembershipType.Builder()
                .withName("Test")
                .withDescription("Testing records")
                .withAmount(new BigDecimal(1.00))
                .withStartDate(ParseUtils.Date_yyyyMMdd("2016-01-01"))
                .withEndDate(ParseUtils.Date_yyyyMMdd("2016-01-06"))
                .build();

        defaultMembershipTypes.add(membershipType);

/*
        {registrationClass=COA,        registrationDescription=Report COAs for nonmembers,               displayOnBadge=,       amount=0.00,  badgeOk=false, eDate=null,                         sDate=Fri Dec 31 00:00:00 PST 2088, key=Z, metaClass=X, listOrder=99.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Void,       registrationDescription=Void,                                     displayOnBadge=,       amount=0.00,  badgeOk=false, eDate=null,                         sDate=Fri Dec 31 00:00:00 PST 2088, key=0, metaClass=X, listOrder=999.00, isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=K12min,     registrationDescription=K-12, advance from previous Boskone,      displayOnBadge=,       amount=20.00, badgeOk=true,  eDate=Tue Mar 31 00:00:00 PDT 2015, sDate=Fri Feb 13 00:00:00 PST 2015, key=R, metaClass=R, listOrder=7.00,   isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Collmin,    registrationDescription=College, advance from previous Boskone,   displayOnBadge=,       amount=30.00, badgeOk=true,  eDate=Tue Mar 31 00:00:00 PDT 2015, sDate=Fri Feb 13 00:00:00 PST 2015, key=C, metaClass=R, listOrder=4.00,   isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=AdultMin,   registrationDescription=Advance, from previous Boskone,           displayOnBadge=,       amount=40.00, badgeOk=true,  eDate=Tue Mar 31 00:00:00 PDT 2015, sDate=Fri Feb 13 00:00:00 PST 2015, key=X, metaClass=R, listOrder=80.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=AdultPre,   registrationDescription=Adult, normal prereg,                     displayOnBadge=,       amount=50.00, badgeOk=true,  eDate=Tue Jan 19 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=X, metaClass=R, listOrder=82.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Collpre,    registrationDescription=College Student, normal prereg,           displayOnBadge=,       amount=35.00, badgeOk=true,  eDate=Tue Jan 19 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=C, metaClass=R, listOrder=5.00,   isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Friday,     registrationDescription=Friday only (for any age),                displayOnBadge=FRI,    amount=25.00, badgeOk=true,  eDate=Fri Feb 19 00:00:00 PST 2016, sDate=Wed Jan 20 00:00:00 PST 2016, key=F, metaClass=R, listOrder=22.00,  isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Dealer,     registrationDescription=Huckster rate,                            displayOnBadge=,       amount=50.00, badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Fri Feb 13 00:00:00 PST 2015, key=Q, metaClass=R, listOrder=21.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=AdultAtCon, registrationDescription=Adult, full weekend,                      displayOnBadge=,       amount=65.00, badgeOk=true,  eDate=Sat Feb 20 00:00:00 PST 2016, sDate=Tue Jan 20 00:00:00 PST 2015, key=A, metaClass=,  listOrder=2.00,   isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=AdultSat,   registrationDescription=Adult Saturday,                           displayOnBadge=SAT,    amount=45.00, badgeOk=true,  eDate=Sat Feb 20 00:00:00 PST 2016, sDate=Fri Feb 19 00:00:00 PST 2016, key=J, metaClass=R, listOrder=30.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=true,  isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=KIT,        registrationDescription=Kid-in-Tow (with parent),                 displayOnBadge=Kid,    amount=0.01,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Fri Feb 13 00:00:00 PST 2015, key=K, metaClass=R, listOrder=10.00,  isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Staff,      registrationDescription=Staff,                                    displayOnBadge=Staff,  amount=40.00, badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Fri Feb 13 00:00:00 PST 2015, key=S, metaClass=R, listOrder=20.00,  isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Sunday,     registrationDescription=Sunday only (for any age),                displayOnBadge=SUN,    amount=25.00, badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Sun Feb 21 00:00:00 PST 2016, key=N, metaClass=R, listOrder=40.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Fri&Sunday, registrationDescription=Friday & Sunday all ages,                 displayOnBadge=,       amount=50.00, badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Fri Feb 19 00:00:00 PST 2016, key=H, metaClass=R, listOrder=52.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=ProgPart,   registrationDescription=Program Participant,                      displayOnBadge=Pgm,    amount=0.00,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Thu Feb 19 00:00:00 PST 2015, key=P, metaClass=G, listOrder=60.00,  isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Rollover,   registrationDescription=Rollover membership,                      displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Thu Feb 19 00:00:00 PST 2015, key=R, metaClass=R, listOrder=71.00,  isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=K12,        registrationDescription=K-12 (with ID or parent),                 displayOnBadge=,       amount=25.00, badgeOk=true,  eDate=Sat Feb 20 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=D, metaClass=R, listOrder=6.00,   isAvailableThursday=true,  isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=SvcAnimal,  registrationDescription=Working (service) animals,                displayOnBadge=SvcDog, amount=0.01,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Thu Feb 19 00:00:00 PST 2015, key=V, metaClass=X, listOrder=90.00,  isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Mascot,     registrationDescription=Stuffed animals, etc.,                    displayOnBadge=Mascot, amount=5.00,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Thu Feb 19 00:00:00 PST 2015, key=M, metaClass=X, listOrder=91.00,  isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=CollAtCon,  registrationDescription=College student and active military (ID), displayOnBadge=,       amount=40.00, badgeOk=true,  eDate=Sat Feb 20 00:00:00 PST 2016, sDate=Wed Jan 20 00:00:00 PST 2016, key=C, metaClass=R, listOrder=17.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Guest,      registrationDescription=GOHs and former GOHs,                     displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=Sun Feb 21 00:00:00 PST 2016, sDate=Thu Feb 19 00:00:00 PST 2015, key=G, metaClass=G, listOrder=70.00,  isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Life,       registrationDescription=Life Members,                             displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=null,                         sDate=Fri Dec 31 00:00:00 PST 2088, key=X, metaClass=G, listOrder=72.00,  isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Carryover,  registrationDescription=Carryover membership,                     displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=Mon Feb 15 00:00:00 PST 2016, sDate=Sun Feb 15 00:00:00 PST 2015, key=X, metaClass=G, listOrder=8.00,   isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=K12Pre,     registrationDescription=K-12, normal prereg,                      displayOnBadge=,       amount=25.00, badgeOk=true,  eDate=Tue Jan 19 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=X, metaClass=G, listOrder=3.00,   isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=College,    registrationDescription=Full college, regardless of amount paid,  displayOnBadge=,       amount=45.00, badgeOk=true,  eDate=Tue Jan 19 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=X, metaClass=G, listOrder=3.00,   isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=FormerGOH,  registrationDescription=Former GoH,                               displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=Tue Jan 19 00:00:00 PST 2016, sDate=Wed Apr 01 00:00:00 PDT 2015, key=X, metaClass=G, listOrder=3.00,   isAvailableThursday=false, isAvailableFriday=true,  isAvailableSaturday=true,  isAvailableSunday=true,  hasTimestamp=false}
        {registrationClass=Comp,       registrationDescription=Complimentary membership,                 displayOnBadge=,       amount=0.00,  badgeOk=true,  eDate=null,                         sDate=null,                         key=B, metaClass=,  listOrder=94.00,  isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Barred,     registrationDescription=Do not register! Call for help!,          displayOnBadge=VOID,   amount=0.00,  badgeOk=false, eDate=null,                         sDate=null,                         key=,  metaClass=,  listOrder=0.00,   isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
        {registrationClass=Test,       registrationDescription=Testing records,                          displayOnBadge=,       amount=1.00,  badgeOk=true,  eDate=Sun Jan 31 00:00:00 PST 2016, sDate=Fri Jan 01 00:00:00 PST 2016, key=T, metaClass=,  listOrder=123.00, isAvailableThursday=false, isAvailableFriday=false, isAvailableSaturday=false, isAvailableSunday=false, hasTimestamp=false}
 */
        return defaultMembershipTypes;
    }
}
