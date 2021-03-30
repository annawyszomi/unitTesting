package szkolaTestow.moduł2.cz2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class VatService {
    private static final Logger logger = LogManager.getLogger(VatService.class);
    VatProvider vatProvider;


    public VatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double geGrossPriceForDefaultVat(Product product) throws IncorrectVatException {
        logger.info("calculating gross price for default vat");
        return calculateGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }

    public double getGrossPrice(double netPrice, String type) throws IncorrectVatException {
        double vatValue = vatProvider.getVatForType(type);
        logger.info("calculating gross price for " + type);
        return calculateGrossPrice(netPrice, vatValue);

    }

    private double calculateGrossPrice(double netPrice, double vatValue) throws IncorrectVatException {
        if (vatValue > 1) {
            logger.debug("wrong value of vat =" + vatValue);
            throw new IncorrectVatException("Vat value must be lower");
        }

        return netPrice * (1 + vatValue);
    }

}


