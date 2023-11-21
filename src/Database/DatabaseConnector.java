package Database;

import java.sql.*;


public class DatabaseConnector{
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/dataserver_db";
    private static final String DB_username = "dataserver";
    private static final String DB_password = "dataserver";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // MariaDB JDBC Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MariaDB JDBC Driver not found");
        }
        return DriverManager.getConnection(DB_URL, DB_username, DB_password);
    }
}