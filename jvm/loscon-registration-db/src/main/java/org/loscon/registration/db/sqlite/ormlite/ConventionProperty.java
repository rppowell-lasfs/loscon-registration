package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Property")
public class ConventionProperty {
    public static final String COLUMNNAME_NAME = "name";
    public static final String COLUMNNAME_VALUE = "value";

    @DatabaseField(id = true, columnName = COLUMNNAME_NAME)
    private String name;

    @DatabaseField(columnName = COLUMNNAME_VALUE)
    private String value;

    ConventionProperty() {}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;};

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;};

}
