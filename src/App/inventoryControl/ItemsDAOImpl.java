package App.inventoryControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class ItemsDAOImpl implements ItemsDAO {

    @Override
    public List<Items> getItems() {
        // Create an array list of items
        List<Items> items = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM items";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Items item = new Items();
                item.setItemID(resultSet.getInt("id"));
                item.setItemName(resultSet.getString("name"));
                item.setItemCategory(resultSet.getString("category"));
                item.setItemPrice(resultSet.getDouble("price"));
                item.setItemDescription(resultSet.getString("description"));
                item.setSupplierOfItem(resultSet.getString("supplier"));

                items.add(item);

            }
            
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return items;
    }
    
}
