package szkolaTestow.moduł2;

public class Product {
    private String id;
    private double netPrice;

    public Product(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }
}
