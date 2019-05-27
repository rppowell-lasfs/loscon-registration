package org.loscon.registration;

import org.loscon.registration.db.dbf.DBFUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Properties;

public class ConventionFactory {

    public static Convention ConventionFromLegacyDBF(File regConfiDPF) throws FileNotFoundException, ParseException {
        Properties conventionProperties = DBFUtils.conventionPropertiesFromRegConfiDBF(regConfiDPF);
        Convention c = new Convention();
        c.setFromProperties(conventionProperties);

        System.out.println(conventionProperties.toString());
        return c;
    }
}
