package App.financialApproval;

public class FinancialApproval {
    private int approvalId;
    private int customerId;
    private String approvalStatus;
    private String approvalDate;
    private String approvalTime;
    private String approvalAmount;


    // Create constructor, getters and setters


    // Constructor

    public FinancialApproval(int approvalId, int customerId, String approvalStatus, String approvalDate, String approvalTime, String approvalAmount) {
        this.approvalId = approvalId;
        this.customerId = customerId;
        this.approvalStatus = approvalStatus;
        this.approvalDate = approvalDate;
        this.approvalTime = approvalTime;
        this.approvalAmount = approvalAmount;
    }


    public FinancialApproval() {}


    // Getters

    public int getApprovalId() {
        return approvalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public String getApprovalAmount() {
        return approvalAmount;
    }


    // Setters

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public void setApprovalAmount(String approvalAmount) {
        this.approvalAmount = approvalAmount;
    }
}
