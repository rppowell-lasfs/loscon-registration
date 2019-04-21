package org.loscon.registration.db.dbf;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;

import java.util.ArrayList;
import java.util.List;

public class DBFUtils {

    static public List<String> extractTableHeaderNames(DBFReader reader) throws DBFException {
        ArrayList<String> headerNames = null;
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
}
