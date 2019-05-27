package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFReader;
import org.loscon.registration.db.dbf.models.Master;
import org.loscon.registration.db.dbf.models.Member;
import org.loscon.registration.db.dbf.models.RegClass;
import org.loscon.registration.db.dbf.models.RegkitMember;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class DBFReaderRegkitTests {
    @Test(singleThreaded=true)
    public void DumpRegConfiDBF() throws Exception {
        String masterDBFFilename = "../../legacy/regkit/regconfi.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));
        System.out.println("DumpRegConfiDBF()");
        DBFUtils.dumpDBF(fs);
        fs.close();
    }

    @Test(singleThreaded=true)
    public void ProcessRegConfiDBF() throws IOException {
        String reconfiDBF = "../../legacy/regkit/regconfi.dbf";
        File file = new File(reconfiDBF);
        FileInputStream fs = new FileInputStream(new File(reconfiDBF));
        DBFReader reader = new DBFReader(fs);

        Properties conventionproperties = new Properties();

        System.out.println("ProcessRegConfiDBF()");
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
        String masterDBFFilename = "../../legacy/regkit/classes.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));
        System.out.println("DumpClassesDBF()");
        DBFUtils.dumpDBF(fs);
        fs.close();
    }

    @Test(singleThreaded=true)
    public void ProcessRegClassesDBF() throws Exception {
        String classesDBFFilename = "../../legacy/regkit/classes.dbf";
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
        String masterDBFFilename = "../../legacy/regkit/members.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));
        System.out.println("DumpMembersDBF()");
        DBFUtils.dumpDBF(fs);
        fs.close();
    }


    @Test(singleThreaded=true)
    public void ProcessMembersDBF() throws Exception {
        String memberDBFFilename = "../../legacy/regkit/members.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(memberDBFFilename)));

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);

        System.out.println("ProcessMembersDBF()");
        System.out.println(actualHeaders);

        Assert.assertEquals(actualHeaders, RegkitMember.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            RegkitMember m = RegkitMember.ExtractFromMemberDBFRecord(rowObjects);
            System.out.println(m.toString());
        }
        reader.close();
    }

    @Test(singleThreaded=true)
    public void DumpMasterDBF() throws Exception {
        String masterDBFFilename = "../../legacy/regkit/master.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));
        System.out.println("DumpMasterDBF()");
        DBFUtils.dumpDBF(fs);
        fs.close();
    }

    @Test(singleThreaded=true)
    public void ProcessMasterDBF() throws Exception {
        String masterDBFFilename = "../../legacy/regkit/master.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, Master.DBFHeaders);

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            Master m = Master.ExtractFromDBFRecord(rowObjects);
            System.out.println(m);
        }
        fs.close();
    }

    @Test(singleThreaded=true)
    public void DumpLogDBF() throws Exception {
        String masterDBFFilename = "../../legacy/regkit/log.dbf";
        FileInputStream fs = new FileInputStream(new File(masterDBFFilename));
        System.out.println("DumpLogDBF()");
        DBFUtils.dumpDBF(fs);
        fs.close();
    }

}
