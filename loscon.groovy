/*

References:
* https://www.baeldung.com/ormlite

* http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite.html
* http://ormlite.com/javadoc/ormlite-core/

*/

/* trying to figure out logging
System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");
//System.setProperty("com\\.j256\\.ormlite.*", "TRACE")
//System.setProperty("com.j256.ormlite.ormlite.table.TableUtils", "ERROR")
//for (key in System.properties.keySet().sort()) {
//    printf('%-30s   %s\n', key, System.properties[key])
//}
//System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "TRACE");
//System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "DEBUG");
//System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "INFO");
//System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

//System.setProperty("com\\.j256\\.ormlite.*", "TRACE")
//System.setProperty("com.j256.ormlite.stmt.mapped.BaseMappedStatement", "TRACE")
//System.setProperty("com.j256.ormlite.stmt.mapped.MappedCreate", "TRACE")
//System.setProperty("com.j256.ormlite.stmt.StatementExecutor", "TRACE")

//Logger logger = LoggerFactory.getLogger(LoggerFactory.class.getName())
Logger logger = LoggerFactory.getLogger(TableUtils.class)
logger.debug("This is a test.")
//println logger.isLevelEnabled(Log.Level.DEBUG)
println "TRACE:  " + logger.isLevelEnabled(Log.Level.TRACE)
println "DEBUG:  " + logger.isLevelEnabled(Log.Level.DEBUG)
println "WARNING:" + logger.isLevelEnabled(Log.Level.WARNING)
println "INFO:   " + logger.isLevelEnabled(Log.Level.INFO)
println "ERROR:  " + logger.isLevelEnabled(Log.Level.ERROR)
println "FATAL:  " + logger.isLevelEnabled(Log.Level.FATAL)
//println logger.class.getName()
println LoggerFactory.LogType.class.getName()
println LoggerFactory.LogType
println LoggerFactory.LogType.toString()

//println LoggerFactory.LogType.values()
//println LoggerFactory.getLogger(Item.class)
//println LoggerFactory.class.getName()
//println LoggerFactory.LogType.toString()
*/

@Grapes([
  @GrabConfig(systemClassLoader=true),
  @Grab(group='org.xerial', module='sqlite-jdbc', version='3.27.2.1'),
  @Grab(group='com.j256.ormlite', module='ormlite-jdbc', version='5.0')
])

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;


@DatabaseTable(tableName="members")
public class Member {
  @DatabaseField(generatedId=true) int memberId;
  @DatabaseField(canBeNull=false) String name;
  @DatabaseField(version=true, dataType = DataType.DATE_STRING) Date lastModified;
}

@DatabaseTable(tableName="items")
public class Item {
  @DatabaseField(generatedId=true) int itemId;
  @DatabaseField(canBeNull=false)  String title;
  @DatabaseField(version=true, dataType = DataType.DATE_STRING) Date lastModified;
}

@DatabaseTable(tableName="itemtypes")
public class ItemType {
  @DatabaseField(generatedId=true) int itemTypeId;
  @DatabaseField(canBeNull=false)  String name;
  @DatabaseField(version=true, dataType = DataType.DATE_STRING) Date lastModified;
}

@DatabaseTable(tableName="itemloans")
public class ItemLoan {
  @DatabaseField(generatedId=true) int itemLoanId;
  @DatabaseField(canBeNull=false)  int itemId;

  @DatabaseField(foreign=true, columnName="member_id")  Member member;
  @DatabaseField(foreign=true, columnName="librarian_id")  Member librarian;
  @DatabaseField(version=true, dataType = DataType.DATE_STRING) Date lastModified;
}

public class Utils {
    private static String datetimestamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss-SSS").withZone(ZoneId.systemDefault()).format(Instant.now())
    }
}

public class LASFSLibrary {
    public static JdbcPooledConnectionSource connectionSource;
    public static Dao<Member, Integer> memberDao;
    public static Dao<Item, Integer> itemDao;
    public static Dao<ItemType, Integer> itemtypeDao;
    public static Dao<ItemLoan, Integer> itemloanDao;

    public LASFSLibrary(JdbcPooledConnectionSource connectionSource) throws SQLException {
        this.connectionSource = connectionSource
    }

    public void setup() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Member.class);
        TableUtils.createTableIfNotExists(connectionSource, Item.class);
        TableUtils.createTableIfNotExists(connectionSource, ItemType.class);
        TableUtils.createTableIfNotExists(connectionSource, ItemLoan.class);

        memberDao = DaoManager.createDao(connectionSource, Member.class);

        itemDao = DaoManager.createDao(connectionSource, Item.class);
        itemtypeDao = DaoManager.createDao(connectionSource, ItemType.class);
        itemloanDao = DaoManager.createDao(connectionSource, ItemLoan.class);
    }
}

public class LASFSLibraryIntegrationTest001 {
    private static JdbcPooledConnectionSource connectionSource;
    private static LASFSLibrary lasfsLibrary;

    public void setup() throws SQLException {
        //connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:mem:myDb");
        connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:lasfslibrary-${Utils.datetimestamp()}.sqlite3");
        lasfsLibrary = new LASFSLibrary(connectionSource)
        lasfsLibrary.setup()
    }

    public void addItem() {
        Member member = new Member()
        member.name="TestMemberName01"
        lasfsLibrary.memberDao.create(member)

        Member librarian = new Member()
        librarian.name="TestLibrarianName01"
        lasfsLibrary.memberDao.create(librarian)

        Item item = new Item()
        item.title="Test01"
        lasfsLibrary.itemDao.create(item)

        ItemLoan itemLoan = new ItemLoan()
        itemLoan.librarian=librarian;
        itemLoan.member=member;

        lasfsLibrary.itemloanDao.create(itemLoan)
    }
}

l = new LASFSLibraryIntegrationTest001()
l.setup()
l.addItem()

println "Hello LASFS"
