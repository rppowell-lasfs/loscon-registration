package org.loscon.registration.db.dbf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

@Entity
public class RegistrationClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public RegistrationClass(
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
}
