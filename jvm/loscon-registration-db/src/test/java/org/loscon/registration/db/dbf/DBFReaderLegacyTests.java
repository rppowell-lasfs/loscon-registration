package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFReader;
import org.loscon.registration.db.dbf.models.Master;
import org.loscon.registration.db.dbf.models.Member;
import org.loscon.registration.db.dbf.models.RegClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class DBFReaderLegacyTests {

    @Test(singleThreaded=true)
    public void DumpRegConfiDBF() throws IOException {
        String classesDBF = "../../legacy/dbf-2017-05-28/2017-05-28-regconfi.dbf";
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
    public void DumpRegClassesDBF() throws Exception {
        String classesDBFFilename = "../../legacy/dbf-2017-05-28/2017-05-28-classes.dbf";
        FileInputStream fs = new FileInputStream(new File(classesDBFFilename));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, RegClass.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            RegClass r = RegClass.ExtractFromDBFRecord(rowObjects);
            System.out.println(r.toString());
        }
        fs.close();
    }

    @Test(singleThreaded=true)
    public void DumpMembersDBF() throws Exception {
        String memberDBFFilename = "../../legacy/dbf-2017-05-28/2017-05-28-members.dbf";

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
        String masterDBFFilename = "../../legacy/dbf-2017-05-28/2017-05-28-master.dbf";
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
