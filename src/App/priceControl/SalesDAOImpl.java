package App.priceControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class SalesDAOImpl implements SalesDAO {

    @Override
    public List<Sales> getSales() {
        // Create an array list of Sales
        List<Sales> sales = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM salesOffer";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Sales sale = new Sales();
                sale.setSalesOfferId(resultSet.getInt("salesOfferID"));
                sale.setNameOfSalesOffer(resultSet.getString("salesOfferName"));
                sale.setDescriptionOfSalesOffer(resultSet.getString("Description"));

                sales.add(sale);
            }
            
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }
    
}
