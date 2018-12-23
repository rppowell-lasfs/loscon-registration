package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "properties")
public class ConventionProperty {
    public static final String NAME_FIELD_NAME = "name";
    public static final String VALUE_FIELD_NAME = "value";

    @DatabaseField(id = true, columnName = NAME_FIELD_NAME)
    private String name;

    @DatabaseField(columnName = VALUE_FIELD_NAME)
    private String value;

    ConventionProperty() {}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;};

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;};

}
