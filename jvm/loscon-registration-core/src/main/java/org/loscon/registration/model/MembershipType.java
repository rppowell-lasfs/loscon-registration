package org.loscon.registration.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MembershipType {
    public String key;
    public String name;
    public String description;

    public MembershipType(String key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
    }

    public static List<MembershipType> defaultMembershipTypes() {
        return new ArrayList<MembershipType>(Arrays.asList(
            new MembershipType("1", "Full Membership", "Full attending member"),
            new MembershipType("2", "Child", "Child"),
            new MembershipType("3", "Today Daily Adult", "Today's daily adult"),
            new MembershipType("4", "Today Daily Child", "Today's daily child"),
            new MembershipType("G", "Guest", "Guest of the convention or program participant"),
            new MembershipType("P", "Program Participant", "Program Participant"),
            new MembershipType("0", "Miscellaneous", "Miscellaneous complimentary"),
            new MembershipType("D", "Miscellaneous Daily", "Miscellaneous complimentary daily membership"),
            new MembershipType("K", "Complimentary Child", "Complimentary child membership"),
            new MembershipType("X", "Void", "Void / Special")
        ));
    }
}
