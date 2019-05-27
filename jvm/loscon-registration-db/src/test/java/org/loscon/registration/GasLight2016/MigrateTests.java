package org.loscon.registration.GasLight2016;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.linuxense.javadbf.DBFReader;
import org.loscon.registration.Convention;
import org.loscon.registration.ConventionFactory;
import org.loscon.registration.db.dbf.DBFUtils;
import org.loscon.registration.db.dbf.models.RegClass;
import org.loscon.registration.db.sqlite.ormlite.MembershipType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MigrateTests {
    @Test
    public void openGasLight2016ConventionLegacyConfiguration() throws FileNotFoundException, ParseException {
        String regconfiDBFfilename = "../../legacy/dbf-2017-05-28/2017-05-28-regconfi.dbf";
        File regconfiDBF = new File(regconfiDBFfilename);
        Convention c = ConventionFactory.ConventionFromLegacyDBF(regconfiDBF);
    }

    @Test(singleThreaded=true)
    public void MigrateGasLight2016ConventionMembershipTypes() throws Exception, SQLException {
        String sqliteFilename = "test-" +
                DateTimeFormatter.ISO_INSTANT.format(Instant.now().truncatedTo(ChronoUnit.SECONDS)) +
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss.SSS").withZone(ZoneOffset.UTC).format(Instant.now()) +
                ".sqlite";

        String sqliteConnectionString = "jdbc:sqlite:" + sqliteFilename;

        ConnectionSource connectionSource = null;
        try {
            Dao<MembershipType, Integer> membershipTypeDao = null;

            connectionSource = new JdbcConnectionSource(sqliteConnectionString);

            membershipTypeDao = DaoManager.createDao(connectionSource, MembershipType.class);
            TableUtils.createTable(connectionSource, MembershipType.class);

            String classesDBFFilename = "../../legacy/dbf-2017-05-28/2017-05-28-classes.dbf";
            FileInputStream fs = new FileInputStream(new File(classesDBFFilename));

            DBFReader reader = null;
            reader = new DBFReader(fs);

            List<String> actualHeaders = DBFUtils.extractTableHeaderNames(reader);
            Assert.assertEquals(actualHeaders, RegClass.DBFHeaders);

            List<MembershipType> membershipTypes = new ArrayList<>();
            MembershipType membershipType = null;

            Object[] rowObjects;
            while( (rowObjects = reader.nextRecord()) != null) {
                RegClass r = RegClass.ExtractFromDBFRecord(rowObjects);
                System.out.println(r.toString());
                membershipType = new MembershipType();
                membershipType.setName(r.registrationClass);
                membershipType.setDescription(r.registrationDescription);
                membershipType.setDisplayOnBadge(r.displayOnBadge);
                membershipType.setAmount(r.amount);
                membershipTypeDao.create(membershipType);
            }
            fs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connectionSource != null) {
                connectionSource.close();
            }
        }
    }
}
