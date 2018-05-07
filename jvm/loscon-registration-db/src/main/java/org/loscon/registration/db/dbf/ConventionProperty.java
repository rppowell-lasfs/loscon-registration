package org.loscon.registration.db.dbf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConventionProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    public String name;
    public String value;

    public ConventionProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return name+"="+value;
    }
}
