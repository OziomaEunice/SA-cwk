package App.reportAnalysis;

public class CustomerInfoReport {
    private int customerId;
    private String customerName;
    private String customerEmail;


    // Create constructor, getters and setters

    // Constructor
    public CustomerInfoReport(int customerId, String customerName, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }


    public CustomerInfoReport() {}


    // Getters

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }


    // Setters

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
