package szkolaTestow.moduł2.cz2;

public class Product {
    private String id;
    private double netPrice;
    private String type;

    public Product(double netPrice, String type) {
        this.netPrice = netPrice;
        this.type = type;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public String getType() {
        return type;
    }
}
