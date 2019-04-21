package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class SqliteOrmliteTests {
    @Test
    public void SqliteOrmliteTestConventionProperty() throws SQLException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String testSQLiteOrmliteFilename = "testdb.sqliteormlite-testconventionproperty-" + localDateTime.toString() + ".sqlite";
        System.out.println("testSQLiteOrmliteFilename:" + testSQLiteOrmliteFilename);
        String databaseUrl = "jdbc:sqlite:" + testSQLiteOrmliteFilename;
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<ConventionProperty, String> propertiesDao = DaoManager.createDao(connectionSource, ConventionProperty.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, ConventionProperty.class);

        ConventionProperty p1 = new ConventionProperty();
        p1.setName("TestName");
        p1.setValue("TestValue");

        propertiesDao.create(p1);

        ConventionProperty p2 = propertiesDao.queryForId("TestName");
        System.out.println(p2.getName() + ":" + p2.getValue());

        connectionSource.close();
    }

    @Test
    public void SqliteOrmliteTestMembershipType() throws SQLException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String testSQLiteOrmliteFilename = "testdb.sqliteormlite-testmembershiptype-" + localDateTime.toString() + ".sqlite";
        System.out.println("testSQLiteOrmliteFilename:" + testSQLiteOrmliteFilename);
        String databaseUrl = "jdbc:sqlite:" + testSQLiteOrmliteFilename;
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<MembershipType, Integer> membershiptypeDao = DaoManager.createDao(connectionSource, MembershipType.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, MembershipType.class);

        //{registrationClass=AdultAtCon, registrationDescription=Adult, full weekend, displayOnBadge=, amount=65.00, badgeOk=true, eDate=Sat Feb 20 00:00:00 PST 2016, sDate=Tue Jan 20 00:00:00 PST 2015, key=A, metaClass=, listOrder=2.00, isAvailableThursday=true, isAvailableFriday=true, isAvailableSaturday=true, isAvailableSunday=false, hasTimestamp=false}
        MembershipType attendee = new MembershipType();
        attendee.setName("AdultAtCon");
        attendee.setDescription("Adult-full weekend");
        attendee.setAmount(new BigDecimal(65.00));

        membershiptypeDao.create(attendee);

        MembershipType membershipType = membershiptypeDao.queryForId(1);
        System.out.println(membershipType.getName() + ":" + membershipType.getDescription());

        connectionSource.close();
    }

    @Test
    public void SqliteOrmliteTestMembership() throws SQLException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String testSQLiteOrmliteFilename = "testdb.sqliteormlite-testmembership-" + localDateTime.toString() + ".sqlite";
        System.out.println("testSQLiteOrmliteFilename:" + testSQLiteOrmliteFilename);
        String databaseUrl = "jdbc:sqlite:" + testSQLiteOrmliteFilename;
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Membership, UUID> membershipDao = DaoManager.createDao(connectionSource, Membership.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Membership.class);

        Membership membership = new Membership();
        UUID uuid = UUID.randomUUID();
        membership.setUUID(uuid);
        membership.setFirstName("FirstName");
        membership.setLastName("LastName");

        membershipDao.create(membership);

        membership = membershipDao.queryForId(uuid);
        System.out.println(membership.getUUID() + ": " + membership.getFirstName() + " " + membership.getLastName());

        connectionSource.close();
    }

}
