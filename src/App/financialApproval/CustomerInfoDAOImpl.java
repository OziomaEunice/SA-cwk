package App.financialApproval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class CustomerInfoDAOImpl implements CustomerInfoDAO {

    @Override
    public List<CustomerInfo> getCustomerInfo() {
        // Create an array list of customer info
        List<CustomerInfo> customers = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM customerInfo";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                CustomerInfo customer = new CustomerInfo();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setCustomerEmail(resultSet.getString("email"));
                customer.setCustomerPhone(resultSet.getString("phone"));
                customer.setCustomerAddress(resultSet.getString("address"));
                customer.setCustomerCity(resultSet.getString("city"));
                customer.setCustomerZipCode(resultSet.getString("zip"));
                customer.setCustomerCountry(resultSet.getString("country"));

                customers.add(customer);
            }
            
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
    
}
