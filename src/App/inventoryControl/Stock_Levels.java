package App.inventoryControl;

public class Stock_Levels {
    private int itemId;
    private int quantity;


    // create constructor, getters and setters


    // constructor
    public Stock_Levels(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }


    public Stock_Levels() {}


    // getters

    public int getItemId() {
        return itemId;
    }


    public int getQuantity() {
        return quantity;
    }


    // setters

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
