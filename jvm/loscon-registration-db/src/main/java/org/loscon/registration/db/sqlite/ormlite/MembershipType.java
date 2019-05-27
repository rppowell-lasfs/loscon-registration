package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MembershipType {
    public static class Builder {
        private String name;
        private String description;
        private String displayOnBadge;
        private BigDecimal amount;
        private Date startDate;
        private Date endDate;

        public Builder withName(String name) { this.name = name; return this; }
        public Builder withDescription(String description) { this.description = description; return this; }
        public Builder displayOnBadge(String displayOnBadge) { this.displayOnBadge = displayOnBadge; return this; }
        public Builder withAmount(BigDecimal amount) { this.amount = amount; return this; }
        public Builder withStartDate(Date startDate) { this.startDate = startDate; return this; }
        public Builder withEndDate(Date endDate) { this.endDate = endDate; return this; }

        public Builder() {};

        public MembershipType build() {
            MembershipType membershipType = new MembershipType();
            membershipType.setName(name);
            membershipType.setDescription(description);
            membershipType.setDisplayOnBadge(displayOnBadge);
            membershipType.setAmount(amount);
            return membershipType;
        }
    }

    public static final String COLUMNNAME_ID = "id";
    @DatabaseField(generatedId = true, columnName = COLUMNNAME_ID)
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

    public MembershipType() {}

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
