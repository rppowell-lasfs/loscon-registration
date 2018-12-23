package org.loscon.registration.db;

import com.linuxense.javadbf.DBFReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.loscon.registration.db.dbf.DBFUtils;
import org.loscon.registration.db.dbf.models.ConventionProperty;
import org.loscon.registration.db.dbf.models.Master;
import org.loscon.registration.db.dbf.models.Member;
import org.loscon.registration.db.dbf.models.RegistrationClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class MigrateDBFToSQLiteHibernate5Tests {

    SessionFactory factory;

    @BeforeClass
    public void setup() {
        String testSQLiteDBFilename = "testdb.sqlitehibernate5.sqlite";
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        prop.setProperty("hibernate.connection.url", "jdbc:sqlite:" + testSQLiteDBFilename);
        prop.setProperty("hibernate.connection.username", "");
        prop.setProperty("hibernate.connection.password", "");
        prop.setProperty("hibernate.SQLiteDialect", "org.hibernate.SQLiteDialect.H2Dialect");
        //prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        factory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(Member.class)
                .addAnnotatedClass(Master.class)
                .addAnnotatedClass(RegistrationClass.class)
                .addAnnotatedClass(ConventionProperty.class)
                .buildSessionFactory();
    }

    @Test(singleThreaded=true)
    public void migrateDBFMemberEntries() throws Exception {
        String memberDBFFilename = "testdata/legacy/dbf/2017-05-28-members.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(memberDBFFilename)));

        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
        Assert.assertEquals(actualHeaders, Member.DBFHeaders);

        //Session session = factory.openSession();
        Object[] rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            Member member = Member.ExtractFromMemberDBFRecord(rowObjects);
            System.out.println(member.toString());
            //Transaction tx = session.beginTransaction();
            //session.persist(member);
            //tx.commit();
        }
        //session.close();
        reader.close();
    }

//    @Test(singleThreaded=true)
//    public void migrateDBFMemberEntries() throws Exception {
//        String memberDBFFilename = "testdata/legacy/dbf/2017-05-28-members.dbf";
//
//        DBFReader reader = new DBFReader(new FileInputStream(new File(memberDBFFilename)));
//
//        List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
//        Assert.assertEquals(actualHeaders, Member.DBFHeaders);
//
//        //Session session = factory.openSession();
//        Object[] rowObjects;
//
//        while( (rowObjects = reader.nextRecord()) != null) {
//            Member member = Member.ExtractFromMemberDBFRecord(rowObjects);
//            System.out.println(member.toString());
//            //Transaction tx = session.beginTransaction();
//            //session.persist(member);
//            //tx.commit();
//        }
//        //session.close();
//        reader.close();
//    }

//    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMemberEntries"})
//    public void migrateDBFMasterEntries() throws Exception {
//        String masterDbfFilename = "test-data/legacy/dbf/2017-05-28-master.dbf";
//
//        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));
//
//        if (!DBFUtils.extractTableHeaderNames(reader).equals(Master.DBFHeaders)) {
//            throw new Exception("MasterDBF Header mismatch");
//        }
//
//        Session session = factory.openSession();
//        Object[] rowObjects;
//
//        while( (rowObjects = reader.nextRecord()) != null) {
//            Master master = Master.ExtractFromDBFRecord(rowObjects);
//            //System.out.println(master.toString());
//            Transaction tx = session.beginTransaction();
//            master.ID = null;
//            session.persist(master);
//            tx.commit();
//        }
//        session.close();
//        reader.close();
//    }
//
//    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMasterEntries"})
//    public void migrateDBFClassesEntries() throws Exception {
//        String masterDbfFilename = "test-data/legacy/dbf/2017-05-28-classes.dbf";
//
//        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));
//
//        if (!DBFUtils.extractTableHeaderNames(reader).equals(RegistrationClass.DBFHeaders)) {
//            throw new Exception("ClassesDBF Header mismatch");
//        }
//
//        Session session = factory.openSession();
//        Object[] rowObjects;
//
//        while( (rowObjects = reader.nextRecord()) != null) {
//            RegistrationClass r = RegistrationClass.ExtractFromDBFRecord(rowObjects);
//            System.out.println(r.toString());
//            Transaction tx = session.beginTransaction();
//            session.persist(r);
//            tx.commit();
//        }
//        session.close();
//        reader.close();
//    }
//
//    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMasterEntries"})
//    public void migrateDBFConventionProperties() throws Exception {
//        String masterDbfFilename = "legacy/2017-05-28-regconfi.dbf";
//
//        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));
//        Properties conventionproperties = new Properties();
//
//        int numberOfFields = reader.getFieldCount();
//
//        //for( int i=0; i<numberOfFields; i++) { System.out.println(reader.getField(i).getName()); }
//
//        ConventionProperty cp;
//        Object []rowObjects;
//        rowObjects = reader.nextRecord();
//        if (rowObjects != null) {
//            Session session = factory.openSession();
//            for( int i=0; i<rowObjects.length; i++) {
//                conventionproperties.setProperty(reader.getField(i).getName(), rowObjects[i].toString());
//                Transaction tx = session.beginTransaction();
//                cp = new ConventionProperty(reader.getField(i).getName(), rowObjects[i].toString());
//                session.persist(cp);
//                tx.commit();
//            }
//            session.close();
//        }
//        //System.out.println(conventionproperties.toString());
//        reader.close();
//    }
}
