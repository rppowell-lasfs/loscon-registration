package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import org.loscon.registration.db.dbf.models.Master;
import org.loscon.registration.db.dbf.models.Member;
import org.loscon.registration.db.dbf.models.RegistrationClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class DBFReaderLegacyTests {

    @Test(singleThreaded=true)
    public void DumpRegConfigDBF() throws IOException {
        String classesDBF = "testdata/legacy/dbf/2017-05-28-regconfi.dbf";
        File file = new File(classesDBF);
        FileInputStream fs = new FileInputStream(new File(classesDBF));
        DBFReader reader = new DBFReader(fs);

        Properties conventionproperties = new Properties();

        System.out.println(DBFUtils.extractTableHeaderNames(reader));

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            for( int i=0; i<rowObjects.length; i++) {
                System.out.println(reader.getField(i).getName() + ": " + rowObjects[i].toString() + "(" + rowObjects[i].getClass() + ")");
                conventionproperties.setProperty(reader.getField(i).getName(), rowObjects[i].toString());
            }
            System.out.println(conventionproperties.toString());
        }

    }

    @Test(singleThreaded=true)
    public void DumpClassesDBF() throws Exception {
        String classesDBFFilename = "testdata/legacy/dbf/2017-05-28-classes.dbf";
        FileInputStream fs = new FileInputStream(new File(classesDBFFilename));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, RegistrationClass.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            RegistrationClass r = RegistrationClass.ExtractFromDBFRecord(rowObjects);
            System.out.println(r.toString());
        }

        fs.close();
    }

    @Test(singleThreaded=true)
    public void DumpMembersDBF() throws Exception {
        String memberDBFFilename = "testdata/legacy/dbf/2017-05-28-members.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(memberDBFFilename)));

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, Member.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            Member m = Member.ExtractFromMemberDBFRecord(rowObjects);
            System.out.println(m.toString());
        }
        reader.close();
    }

    @Test(singleThreaded=true)
    public void DumpMasterDBF() throws Exception {
        String masterDBFFilename = "testdata/legacy/dbf/2017-05-28-master.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, Master.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            Master m = Master.ExtractFromDBFRecord(rowObjects);
            //System.out.println(m);
        }
        fs.close();
    }

}
