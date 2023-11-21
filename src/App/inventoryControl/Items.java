package App.inventoryControl;

public class Items {
    private int itemID;
    private String itemName;
    private String itemCategory;
    private double itemPrice;
    private String itemDescription;
    private String supplierOfItem;



// create constructor, getters and setters


    // constructor
    public Items(int itemID, String itemName, String itemCategory, double itemPrice, String itemDescription, String supplierOfItem) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.supplierOfItem = supplierOfItem;
    }


    public Items() {}


    // getters
    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }


    public double getItemPrice() {
        return itemPrice;
    }


    public String getItemDescription() {
        return itemDescription;
    }


    public String getSupplierOfItem() {
        return supplierOfItem;
    }


    // setters
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }


    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }


    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    public void setSupplierOfItem(String supplierOfItem) {
        this.supplierOfItem = supplierOfItem;
    }

}