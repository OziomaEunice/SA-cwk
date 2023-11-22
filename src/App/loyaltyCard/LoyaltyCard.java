package App.loyaltyCard;

public class LoyaltyCard {
    private int cardNumber;
    private int cardId;
    private int customerId;
    private int totalPoints;
    private int points;


    // Create constructor, getters and setters

    // Constructor
    public LoyaltyCard(int cardNumber, int cardId, int customerId, int totalPoints, int points) {
        this.cardNumber = cardNumber;
        this.cardId = cardId;
        this.customerId = customerId;
        this.totalPoints = totalPoints;
        this.points = points;
    }


    public LoyaltyCard() {}


    // Getters

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardId() {
        return cardId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getPoints() {
        return points;
    }


    // Setters

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
