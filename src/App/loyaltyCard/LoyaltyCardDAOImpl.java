package App.loyaltyCard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.DatabaseConnector;

public class LoyaltyCardDAOImpl implements LoyaltyCardDAO {

    @Override
    public List<LoyaltyCard> getLoyaltyCards() {
        // Create an array list of loyalty cards
        List<LoyaltyCard> loyaltyCards = new ArrayList<>();

        try(Connection conn = DatabaseConnector.getConnection();
            Statement statement = conn.createStatement()){

            String query = "SELECT * FROM loyaltyCard";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                LoyaltyCard loyaltyCard = new LoyaltyCard();
                loyaltyCard.setCustomerId(resultSet.getInt("customerId"));
                loyaltyCard.setCardId(resultSet.getInt("cardID"));
                loyaltyCard.setCardNumber(resultSet.getInt("cardNumber"));
                loyaltyCard.setTotalPoints(resultSet.getInt("pointsInCard"));
                loyaltyCard.setPoints(resultSet.getInt("pointsUsed"));

                loyaltyCards.add(loyaltyCard);
            }
            
            statement.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loyaltyCards;
    }
    
}
