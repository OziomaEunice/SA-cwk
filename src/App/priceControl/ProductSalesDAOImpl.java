package App.priceControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class ProductSalesDAOImpl implements ProductSalesDAO {

    @Override
    public List<ProductSales> getProductSales() {
        // Create an array list of sales products
        List<ProductSales> sales = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM productSalesOffer";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                ProductSales sale = new ProductSales();
                sale.setProductId(resultSet.getInt("ProductID"));
                sale.setSalesOfferId(resultSet.getInt("salesOfferID"));

                sales.add(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sales;
    }
    
}
