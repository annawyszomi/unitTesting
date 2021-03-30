package szkolaTestow.moduł2.cz1;

public class VatService {

    private double vatValue;

    public VatService() {
        this.vatValue = 0.23;
    }

    public double geGrossPriceForDefaultVat(Product product) throws Exception {
        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    public double getGrossPrice(double netPrice, double vatValue) throws Exception {
        if (vatValue > 1) {
            throw new Exception("Vat value must be less that 1");
        }
        return netPrice * (1 + vatValue);
    }
}


