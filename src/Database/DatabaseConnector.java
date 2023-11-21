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


    public static void fetchDataFromProductTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Execute a query
            String query = "SELECT * FROM typeOfProduct";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                double price = resultSet.getDouble("Price");

                System.out.println("Product ID: " + productId + ", Name: " + productName + ", Price: " + price);
                // Here, you can handle the retrieved data as needed for your GUI
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //main class to execute the program
    public static void main(String[] args) {
        fetchDataFromProductTable();
    }
}