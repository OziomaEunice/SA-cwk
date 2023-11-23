package App.reportAnalysis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class CustomerInfoReportDAOImpl implements CustomerInfoReportDAO {

    @Override
    public List<CustomerInfoReport> getCustomerInfoReport() {
        // Create an array list of report of customer 
        List<CustomerInfoReport> list = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM customerInfoReport";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                CustomerInfoReport customerInfoReport = new CustomerInfoReport();
                customerInfoReport.setCustomerId(resultSet.getInt("id"));
                customerInfoReport.setCustomerName(resultSet.getString("name"));
                customerInfoReport.setCustomerEmail(resultSet.getString("email"));

                list.add(customerInfoReport);
            }
            
            statement.close();
            conn.close();
            

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return list;
    }
    
}
