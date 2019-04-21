package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

@DatabaseTable(tableName = "Membership")
public class Membership {

    public static final String COLUMNNAME_ID = "id";
    public static final String COLUMNNAME_FIRSTNAME = "firstname";
    public static final String COLUMNNAME_LASTNAME = "lastname";

    @DatabaseField(id=true, columnName = COLUMNNAME_ID)
    private UUID uuid;
    public void setUUID(UUID uuid) { this.uuid = uuid; }
    public UUID getUUID() { return uuid; }

    @DatabaseField(columnName = COLUMNNAME_FIRSTNAME)
    private String firstName;
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    @DatabaseField(columnName = COLUMNNAME_LASTNAME)
    private String lastName;
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

}
