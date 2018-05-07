package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DBFMigrateTests {

    SessionFactory factory;

    @BeforeClass
    public void setup() {
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        prop.setProperty("hibernate.connection.url", "jdbc:sqlite:testdb.sqlite");
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
        String membersDbfFilename = "legacy/2017-05-28-members.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(membersDbfFilename)));

        if (!DBFUtils.extractTableHeaderNames(reader).equals(DBFUtils.MemberDBFHeader)) {
            throw new Exception("MembersDBF Header mismatch");
        }

        Session session = factory.openSession();
        Object[] rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            Member member = DBFUtils.MemberFromMemberDBFRecord(rowObjects);
            System.out.println(member.toString());
            Transaction tx = session.beginTransaction();
            session.persist(member);
            tx.commit();
        }
        session.close();
        reader.close();
    }

    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMemberEntries"})
    public void migrateDBFMasterEntries() throws Exception {
        String masterDbfFilename = "legacy/2017-05-28-master.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));

        if (!DBFUtils.extractTableHeaderNames(reader).equals(DBFUtils.MasterDBFHeader)) {
            throw new Exception("MasterDBF Header mismatch");
        }

        Session session = factory.openSession();
        Object[] rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            Master master = DBFUtils.MasterFromMasterDBFRecord(rowObjects);
            //System.out.println(master.toString());
            Transaction tx = session.beginTransaction();
            master.ID = null;
            session.persist(master);
            tx.commit();
        }
        session.close();
        reader.close();
    }

    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMasterEntries"})
    public void migrateDBFClassesEntries() throws Exception {
        String masterDbfFilename = "legacy/2017-05-28-classes.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));

        if (!DBFUtils.extractTableHeaderNames(reader).equals(DBFUtils.RegistrationClassDBFHeader)) {
            throw new Exception("ClassesDBF Header mismatch");
        }

        Session session = factory.openSession();
        Object[] rowObjects;

        while( (rowObjects = reader.nextRecord()) != null) {
            RegistrationClass r = DBFUtils.RegistrationClassFromDBFRecord(rowObjects);
            System.out.println(r.toString());
            Transaction tx = session.beginTransaction();
            session.persist(r);
            tx.commit();
        }
        session.close();
        reader.close();
    }

    @Test(singleThreaded=true, dependsOnMethods={"migrateDBFMasterEntries"})
    public void migrateDBFConventionProperties() throws Exception {
        String masterDbfFilename = "legacy/2017-05-28-regconfi.dbf";

        DBFReader reader = new DBFReader(new FileInputStream(new File(masterDbfFilename)));
        Properties conventionproperties = new Properties();

        int numberOfFields = reader.getFieldCount();

        //for( int i=0; i<numberOfFields; i++) { System.out.println(reader.getField(i).getName()); }

        ConventionProperty cp;
        Object []rowObjects;
        rowObjects = reader.nextRecord();
        if (rowObjects != null) {
            Session session = factory.openSession();
            for( int i=0; i<rowObjects.length; i++) {
                conventionproperties.setProperty(reader.getField(i).getName(), rowObjects[i].toString());
                Transaction tx = session.beginTransaction();
                cp = new ConventionProperty(reader.getField(i).getName(), rowObjects[i].toString());
                session.persist(cp);
                tx.commit();
            }
            session.close();
        }
        //System.out.println(conventionproperties.toString());
        reader.close();
    }
}
