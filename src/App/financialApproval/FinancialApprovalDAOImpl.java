package App.financialApproval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class FinancialApprovalDAOImpl implements FinancialApprovalDAO {

    @Override
    public List<FinancialApproval> getFinancialApproval() {
        // Create an array list of financial approvals
        List<FinancialApproval> financialApprovals = new ArrayList<>();


        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM financialApproval";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                FinancialApproval financialApproval = new FinancialApproval();
                financialApproval.setApprovalId(resultSet.getInt("approvalId"));
                financialApproval.setCustomerId(resultSet.getInt("customerId"));
                financialApproval.setApprovalStatus(resultSet.getString("approvalStatus"));
                financialApproval.setApprovalDate(resultSet.getString("approvalDate"));
                financialApproval.setApprovalTime(resultSet.getString("approvalTime"));
                financialApproval.setApprovalAmount(resultSet.getString("approvalAmount"));

                financialApprovals.add(financialApproval);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return financialApprovals;
    }
    
}
