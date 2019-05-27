package org.loscon.registration.db.dbf.models;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBFAnnotations {

    @Target(value = ElementType.FIELD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface DBFColumn {
        public String name();
    }

    public class DBFColumnField {
        public String name;
        public DBFColumnField (String name) {
            this.name = name;
        }
    }

    private static List<DBFColumnField> getDBFColumnFields(Class annotatedClass) {
        String headerName;
        List<DBFColumnField> entries = new ArrayList<DBFColumnField>();
        Field[] fields = annotatedClass.getFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof DBFColumn) {
                    DBFColumn dbfColumn = (DBFColumn) annotation;
                }
            }
        }
        return entries;
    }

}
