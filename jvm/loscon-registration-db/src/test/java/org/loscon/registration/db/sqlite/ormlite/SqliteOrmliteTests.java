package org.loscon.registration.db.sqlite.ormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SqliteOrmliteTests {
    @Test
    public void SqliteOrmliteTestOne () throws SQLException, IOException {
        String testSQLiteDBFilename = "testdb.sqliteormlite.sqlite";
        String databaseUrl = "jdbc:sqlite:" + testSQLiteDBFilename;
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
}
