package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getProducts() {
        // ...
        List<Product> products = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM typeOfProduct";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getDouble("Price"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
}
