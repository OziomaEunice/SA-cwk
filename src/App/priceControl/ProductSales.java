package App.priceControl;

public class ProductSales {
    private int productId;
    private int salesOfferId;


    // create constructor, getters and setters

    public ProductSales(int productId, int salesOfferId) {
        this.productId = productId;
        this.salesOfferId = salesOfferId;
    }

    public ProductSales() {}


    // getters

    public int getProductId() {
        return productId;
    }

    public int getSalesOfferId() {
        return salesOfferId;
    }


    // setters

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSalesOfferId(int salesOfferId) {
        this.salesOfferId = salesOfferId;
    }
}
