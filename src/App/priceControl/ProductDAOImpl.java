package App.priceControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getProducts() {
        // Create an array list of products
        // (Help from ChatGPT)
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
            
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // When this method is called it will update the product table
    public void updateProduct(String productId, String productName, String productPrice) {
        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE typeOfProduct SET ProductName = ?, Price = ? WHERE ProductID = ?");

            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productPrice);
            preparedStatement.setString(3, productId);

            int newResults = preparedStatement.executeUpdate();
            //statement.executeUpdate(query);

            // check to confirm if changes were made
            if (newResults > 0) {
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Product not updated");
            }

            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
