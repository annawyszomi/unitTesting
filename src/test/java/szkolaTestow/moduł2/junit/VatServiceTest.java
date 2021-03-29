package szkolaTestow.moduł2.junit;


import org.assertj.core.annotations.Beta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import szkolaTestow.moduł2.Product;
import szkolaTestow.moduł2.VatService;

import static org.junit.jupiter.api.Assertions.*;

public class VatServiceTest {

    VatService vatService;

    @BeforeEach
    void prepareValueService() {
        vatService = new VatService();
    }

    @Test
    void shouldCalculateGrossPriceForDefaultVat() throws Exception {

        //given
        Product product = new Product(20.0);

        //when
        double result = vatService.geGrossPriceForDefaultVat(product);

        //then
        assertEquals(24.60, result);
    }

    @Test
    void shouldGrossEqualZeroForPriceZero() throws Exception {
        //given
        Product product = new Product(0.0);

        //when
        double result = vatService.geGrossPriceForDefaultVat(product);

        //then
        assertEquals(0.0, result);
    }

    @Test
    void shouldCalculateGrossPriceFor10PercentVat() throws Exception {
        //given
        Product product = new Product(20.00);

        //when
        double result = vatService.getGrossPrice(product.getNetPrice(), 0.1);

        //then

        assertEquals(22, result);
    }

    @Test
    void shouldThrowExceptionForIncorrectVatValue() throws Exception {
        //given
        final Product product = new Product(20.00);

        //when
        //then
        assertThrows(Exception.class, () -> {
        vatService.getGrossPrice(product.getNetPrice(),1.1);
        });
    }
}