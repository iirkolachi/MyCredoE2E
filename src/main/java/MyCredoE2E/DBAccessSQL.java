package MyCredoE2E;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccessSQL {
    public static Connection connection;
    public static Connection getConnection247() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection("jdbc:sqlserver://10.195.105.247; encrypt=false; trustedServerCertificate=false", "AppDb", "rKC61m20");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Connection getConnection244() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection("jdbc:sqlserver://10.195.105.244; encrypt=false; trustedServerCertificate=false", "tinatingvelesiani@credo.ge", "Friday31");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
