package App.loyaltyCard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> getCustomer() {
        // Create an array list of customers
        List<Customer> customers = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setCustomerAddress(resultSet.getString("address"));
                customer.setCustomerPhone(resultSet.getString("phone"));
                customer.setCustomerEmail(resultSet.getString("email"));
                customer.setCustomerCity(resultSet.getString("city"));
                customer.setCustomerZipCode(resultSet.getString("zip"));
                customer.setCustomerCountry(resultSet.getString("country"));

                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
    
}
