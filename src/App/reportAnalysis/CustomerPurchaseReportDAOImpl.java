package App.reportAnalysis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class CustomerPurchaseReportDAOImpl implements CustomerPurchaseReportDAO {

    @Override
    public List<CustomerPurchaseReport> getCustomerPurchaseReport() {
        // Create an array list of purchase report of customer
        List<CustomerPurchaseReport> result = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM customerPurchaseReport";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                CustomerPurchaseReport customerPurchaseReport = new CustomerPurchaseReport();
                customerPurchaseReport.setCustomerId(resultSet.getInt("customerId"));
                customerPurchaseReport.setPurchaseId(resultSet.getInt("purchaseID"));
                customerPurchaseReport.setPurchaseDate(resultSet.getString("purchaseDate"));
                customerPurchaseReport.setPurchaseTime(resultSet.getString("purchaseTime"));
                customerPurchaseReport.setPurchaseAmount(resultSet.getString("purchaseAmount"));
                result.add(customerPurchaseReport);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
