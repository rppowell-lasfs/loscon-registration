package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBFReaderLegacyTests {
    @Test(singleThreaded=true)
    public void DumpClassesDBF() throws IOException {
        String classesDBF = "legacy/2017-05-28-classes.dbf";
        File file = new File(classesDBF);
        FileInputStream fs = new FileInputStream(new File(classesDBF));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        int numberOfFields = reader.getFieldCount();

        // TODO: verify ClassesDBF Header & Field Types
        DBFUtils.extractTableHeaderNames(reader);

        Object []rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            RegistrationClass r = DBFUtils.RegistrationClassFromDBFRecord(rowObjects);
            System.out.println(r.toString());
        }

        fs.close();
    }

    @Test(singleThreaded=true)
    public void DumpMasterDBF() throws Exception {
        String classesDBF = "legacy/2017-05-28-master.dbf";
        File file = new File(classesDBF);
        FileInputStream fs = new FileInputStream(new File(classesDBF));

        DBFReader reader = null;
        reader = new DBFReader(fs);

        int numberOfFields = reader.getFieldCount();

        // TODO: verify MasterDBF Header & Field Types

        for( int i=0; i<numberOfFields; i++) {
            DBFField field = reader.getField(i);
            System.out.println(field.getName());
        }

        Object []rowObjects;
        //rowObjects = reader.nextRecord();
        //if (rowObjects != null) {
        while( (rowObjects = reader.nextRecord()) != null) {
//            for( int i=0; i<rowObjects.length; i++) {
//                System.out.println(
//                        ((rowObjects[i] != null) ? rowObjects[i].getClass() : "null")
//                                + ": "
//                                + ((reader.getField(i) != null) ? reader.getField(i).getName() : "null")
//                );
//            }
            Master m = DBFUtils.MasterFromMasterDBFRecord(rowObjects);
            System.out.println(m);
        }
        fs.close();
    }

    @Test(singleThreaded=true)
    public void DumpMembersDBF() throws Exception {
        String classesDBF = "legacy/2017-05-28-members.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(classesDBF)));

        if (!DBFUtils.extractTableHeaderNames(reader).equals(DBFUtils.MemberDBFHeader)) {
            throw new Exception("MembersDBF Header mismatch");
        }

        Object[] rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            Member m = DBFUtils.MemberFromMemberDBFRecord(rowObjects);
            System.out.println(m.toString());
        }
        reader.close();
    }


    @Test(singleThreaded=true)
    public void DumpRegConfigDBF() throws IOException {
        String classesDBF = "legacy/2017-05-28-regconfi.dbf";
        File file = new File(classesDBF);
        FileInputStream fs = new FileInputStream(new File(classesDBF));

        Properties conventionproperties = new Properties();

        DBFReader reader = null;
        reader = new DBFReader(fs);

        int numberOfFields = reader.getFieldCount();

        for( int i=0; i<numberOfFields; i++) {
            DBFField field = reader.getField(i);
            System.out.println(field.getName());
        }
        Object []rowObjects;

        rowObjects = reader.nextRecord();
        if (rowObjects != null) {
            for( int i=0; i<rowObjects.length; i++) {
                conventionproperties.setProperty(reader.getField(i).getName(), rowObjects[i].toString());
            }
        }
        System.out.println(conventionproperties.toString());
    }
}
