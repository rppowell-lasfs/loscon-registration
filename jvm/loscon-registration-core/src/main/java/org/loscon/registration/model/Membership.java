package org.loscon.registration.model;

import java.util.UUID;

public class Membership {
    public UUID uuid;
    public Integer version;
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String postcode;
    public String country;
    public String notes;

    public MembershipType membershipType;
    public boolean badgeprinted;

    public Membership(String firstname, String lastname) {
        uuid = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        version = 0;
    }

    public void update() {
        version++;
    }
}
