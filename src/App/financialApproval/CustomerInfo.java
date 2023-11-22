package App.financialApproval;

public class CustomerInfo {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String customerCity;
    private String customerZipCode;
    private String customerCountry;


    
    // Create constructor, getters and setters


    // Constructor
    public CustomerInfo(int customerId, String customerName, String customerEmail, String customerPhone, String customerAddress, String customerCity, String customerZipCode, String customerCountry) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerZipCode = customerZipCode;
        this.customerCountry = customerCountry;
    }


    public CustomerInfo() {}


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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerZipCode() {
        return customerZipCode;
    }

    public String getCustomerCountry() {
        return customerCountry;
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

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public void setCustomerZipCode(String customerZipCode) {
        this.customerZipCode = customerZipCode;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }
}
