package org.loscon.registration.db.sqlite.hibernate5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import javax.persistence.*;
import java.util.List;
import java.util.Properties;

/*
    // https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
    compile group: 'org.xerial', name: 'sqlite-jdbc', version: '3.21.0.1'
    // https://mvnrepository.com/artifact/com.zsoltfabok/sqlite-dialect
    compile group: 'com.zsoltfabok', name: 'sqlite-dialect', version: '1.0'
*/

public class Hibernate5SqliteProgrammaticConfigurationEmbeddedClassTest {
    @Entity
    static class EmbeddedMessage {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        @Column(nullable = false)
        String text;

        public EmbeddedMessage(String text) { setText(text); }
        public EmbeddedMessage() { }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        @Override
        public String toString() {
            return "EmbeddedMessage{" + "id=" + getId() + ", text='" + getText() + '\'' + '}';
        }
    }

    SessionFactory factory;

    @BeforeClass
    public void setup() {
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        prop.setProperty("hibernate.connection.url", "jdbc:sqlite:testdb.sqlite");
        prop.setProperty("hibernate.connection.username", "");
        prop.setProperty("hibernate.connection.password", "");
        prop.setProperty("hibernate.SQLiteDialect", "org.hibernate.SQLiteDialect.H2Dialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        factory = new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(Hibernate5SqliteProgrammaticConfigurationEmbeddedClassTest.EmbeddedMessage.class)
                .buildSessionFactory();
    }

    @Test
    public void saveEmbeddedMessage() {
        EmbeddedMessage message = new EmbeddedMessage("Hello, world");
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(message);
        tx.commit();
        session.close();
    }

    @Test(dependsOnMethods = "saveEmbeddedMessage")
    public void readEmbeddedMessage() {
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        List<EmbeddedMessage> list = (List<EmbeddedMessage>) session.createQuery("from org.loscon.registration.db.sqlite.hibernate5.Hibernate5SqliteProgrammaticConfigurationEmbeddedClassTest$EmbeddedMessage").list();
        if (list.size() > 1) {
            Assert.fail("EmbeddedMessage configuration in error; table should contain only one."
                    +" Set ddl to create-drop.");
        }
        if (list.size() == 0) {
            Assert.fail("Read of initial message failed; check saveEmbeddedMessage() for errors."
                    +" How did this test run?");
        }
        for (EmbeddedMessage m : list) {
            System.out.println(m);
        }
        session.close();
    }
}
