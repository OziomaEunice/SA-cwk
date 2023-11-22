package App.reportAnalysis;

public class CustomerPurchaseReport {
    private int purchaseId;
    private int customerId;
    private String purchaseDate;
    private String purchaseTime;
    private String purchaseAmount;


    // Create constructor, getters and setters

    // Constructor

    public CustomerPurchaseReport(int purchaseId, int customerId, String purchaseDate, String purchaseTime, String purchaseAmount) {
        this.purchaseId = purchaseId;
        this.customerId = customerId;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.purchaseAmount = purchaseAmount;
    }


    public CustomerPurchaseReport() {}


    // Getters

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }


    // Setters

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
