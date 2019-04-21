package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;

import java.math.BigDecimal;
import java.util.Date;

public class MembershipType {

    @DatabaseField(generatedId = true)
    private int id;

    public static final String COLUMNNAME_NAME = "name";
    @DatabaseField(columnName = COLUMNNAME_NAME)
    private String name;

    public static final String COLUMNNAME_DESCRIPTION = "description";
    @DatabaseField(columnName = COLUMNNAME_DESCRIPTION)
    private String description;

    public static final String COLUMNNAME_DISPLAYONBADGE = "displayOnBadge";
    @DatabaseField(columnName = COLUMNNAME_DISPLAYONBADGE)
    private String displayOnBadge;

    public static final String COLUMNNAME_AMOUNT = "amount";
    @DatabaseField(columnName = COLUMNNAME_AMOUNT)
    private BigDecimal amount;

    public static final String COLUMNNAME_STARTDATE = "startDate";
    @DatabaseField(columnName = COLUMNNAME_STARTDATE)
    private Date startDate;

    public static final String COLUMNNAME_ENDDATE = "endDate";
    @DatabaseField(columnName = COLUMNNAME_ENDDATE)
    private Date endDate;

    MembershipType() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayOnBadge() {
        return displayOnBadge;
    }

    public void setDisplayOnBadge(String displayOnBadge) {
        this.displayOnBadge = displayOnBadge;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

//    public boolean badgeOk;
//    public String registrationClass;
//    public String key;
//    public String metaClass;
//    public BigDecimal listOrder;
//    public boolean isAvailableFriday;
//    public boolean isAvailableSaturday;
//    public boolean isAvailableSunday;
//    public boolean isAvailableThursday;
//    public boolean hasTimestamp;

}
