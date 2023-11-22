package App.inventoryControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class Stock_LevelsDAOImpl implements Stock_LevelsDAO {

    @Override
    public List<Stock_Levels> getStocks() {
        // Create an array list of stock levels
        List<Stock_Levels> list = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM stock_levels";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Stock_Levels stock = new Stock_Levels();
                stock.setItemId(resultSet.getInt("item_id"));
                stock.setQuantity(resultSet.getInt("quantity"));

                list.add(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
