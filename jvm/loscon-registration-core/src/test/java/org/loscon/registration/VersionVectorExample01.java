package org.loscon.registration;

import org.junit.Test;
import org.loscon.registration.model.Membership;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Version Vectors
jordan.brown@west.sun.com 11/28/99

To allow efficient parallel updates on the membership database, the registration
system uses a versioning scheme called "version vectors" to track changes to
the records.

Each record has a list of version numbers, one for each station.  When a
record is updated, station doing the updating increments _its_ version number,
leaving the other version numbers unchanged.

When the time comes to merge two versions of the data, the version vectors
for the two versions of the record are compared.  There are several possible
outcomes:

- Version vectors identical.
	The two versions of the record have had the same changes
	applied to them, and so are identical.
- Version vector A consists entirely of version numbers that are greater
  than or equal to version vector B.
	Version A has had all of the changes from version B applied
	to it, and more, and so A is "more recent".
- Version vector B consists entirely of version numbers that are greater
  than or equal to version vector A.
	This is the inverse of the previous case; version B is more recent.
- Version vector A has some version numbers that are greater than those
  in version B, and some that are less.
	Each version has had updates that have not been reflected in the
	other.  Conflicting changes have been made, and require
	application-specific decisions or human intervention.

The actual implementation of version vectors in the registration system is
somewhat more cryptic than this.  Each record has a VERSION field.  Each
_character_ of the VERSION field is a version number for the corresponding
station.  (That is, the first character is the version number for station 1.)
The field starts filled with spaces, and the characters are incremented
through the ASCII set.  The first time that a record is changed the character
will change to '!', the second time it will be changed to '"', and so on.

Messing with the VERSION field requires intimate understanding of this
version handling.  Generally speaking, if it is necessary to hand-edit a
record it is better to immediately update the record using the reg system
(so that it will increment an appropriate version number) than to try to
update the VERSION field by hand.

 */
public class VersionVectorExample01 {
    @Test
    public void testVersionVectorExample01 () {

        List<Membership> sourceMembershipsA = new ArrayList<Membership>(
                Arrays.asList( new Membership("One", "One")
                ));
    }
}
