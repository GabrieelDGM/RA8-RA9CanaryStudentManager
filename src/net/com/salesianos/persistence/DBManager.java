package net.com.salesianos.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class DBManager {
    private static ObjectContainer db;
    private static final String DB_FILE = "students.db4o";

    public static ObjectContainer open() {
        if (db == null || db.ext().isClosed()) {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            db = Db4oEmbedded.openFile(config, DB_FILE);
        }
        return db;
    }
    public static void close() {
        if (db != null) db.close();
    }

}
