package org.loscon.registration.db.dbf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RegConfi {

    long id;

    public String name;
    public String value;

    public RegConfi(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return name+"="+value;
    }
}
