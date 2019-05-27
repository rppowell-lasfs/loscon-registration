package org.loscon.registration.GasLight2016;

import org.loscon.registration.Convention;
import org.loscon.registration.ConventionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;

public class OpenExisting {

    final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test
    public void openGasLight2016ConventionLegacyConfiguration() throws FileNotFoundException, ParseException {
        //logger.error("Error!");
        String reconfiDBF = "../../legacy/dbf-2017-05-28/2017-05-28-regconfi.dbf";
        File file = new File(reconfiDBF);
        Convention c = ConventionFactory.ConventionFromLegacyDBF(file);
    }

}
