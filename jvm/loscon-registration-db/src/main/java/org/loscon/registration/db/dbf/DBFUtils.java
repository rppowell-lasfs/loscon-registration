package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

public class DBFUtils {

    static public void dumpDBF(FileInputStream fileInputStream) {
        DBFReader reader = new DBFReader(fileInputStream);
        List<String> headers = extractTableHeaderNames(reader);
        System.out.println(headers);
        Object[] rowObjects;
        LinkedHashMap entries = null;
        while( (rowObjects = reader.nextRecord()) != null) {
            entries = new LinkedHashMap<String, String>();
            for (int i = 0; i < rowObjects.length; i++) {
                //if()
                entries.put(headers.get(i), rowObjects[i]);
            }
            System.out.println(entries.toString());
        }
    }

    static public List<String> extractTableHeaderNames(DBFReader reader) throws DBFException {
        List<String> headerNames = null;
        if (reader != null) {
            headerNames = new ArrayList<String>();

            // TODO: verify DBF Header & Field Types
            int i;
            for(i = 0; i<reader.getFieldCount(); i++) {
                headerNames.add(reader.getField(i).getName());
                //System.out.println(reader.getField(i).getName() + ": " + reader.getField(i).getDataType());
            }
        }
        return headerNames;
    }

    public static Properties conventionPropertiesFromRegConfiDBF(File regConfiDBF) throws FileNotFoundException {
        FileInputStream fs = new FileInputStream(regConfiDBF);
        DBFReader reader = new DBFReader(fs);

        Properties conventionproperties = new Properties();

        //System.out.println(DBFUtils.extractTableHeaderNames(reader).toString());

        Object[] rowObjects;
        while( (rowObjects = reader.nextRecord()) != null) {
            for( int i=0; i<rowObjects.length; i++) {
                //System.out.println( reader.getField(i).getName() + ": " + rowObjects[i].toString() + "(" + rowObjects[i].getClass() + ")" );
                conventionproperties.setProperty(reader.getField(i).getName(), rowObjects[i].toString());
            }
            //System.out.println(conventionproperties.toString());
        }
        return conventionproperties;
    }
}
