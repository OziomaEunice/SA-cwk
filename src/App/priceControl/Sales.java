package App.priceControl;

public class Sales {
    private int salesOfferId;
    private String nameOfSalesOffer;
    private String descriptionOfSalesOffer;


    // create constructor, getters and setters


    // constructor
    public Sales(int salesOfferId, String nameOfSalesOffer, String descriptionOfSalesOffer) {
        this.salesOfferId = salesOfferId;
        this.nameOfSalesOffer = nameOfSalesOffer;
        this.descriptionOfSalesOffer = descriptionOfSalesOffer;
    }


    public Sales() {}


    // getters
    public int getSalesOfferId() {
        return salesOfferId;
    }

    public String getNameOfSalesOffer() {
        return nameOfSalesOffer;
    }

    public String getDescriptionOfSalesOffer() {
        return descriptionOfSalesOffer;
    }


    // setters
    public void setSalesOfferId(int salesOfferId) {
        this.salesOfferId = salesOfferId;
    }

    public void setNameOfSalesOffer(String nameOfSalesOffer) {
        this.nameOfSalesOffer = nameOfSalesOffer;
    }

    public void setDescriptionOfSalesOffer(String descriptionOfSalesOffer) {
        this.descriptionOfSalesOffer = descriptionOfSalesOffer;
    }
}