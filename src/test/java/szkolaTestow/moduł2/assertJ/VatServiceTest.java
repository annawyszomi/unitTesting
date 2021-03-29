package szkolaTestow.moduł2.assertJ;

import org.junit.jupiter.api.Test;
import szkolaTestow.moduł2.Product;
import szkolaTestow.moduł2.VatService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class VatServiceTest {
    VatService vatService = new VatService();
    Product product = new Product(20.00);


//    static void prepareVatService() {
//        vatService = new VatService();
//    }

    @Test
    void shouldCalculateGrossPriceForDefaultPrice() throws Exception {

        //given


        //when
        double result = vatService.geGrossPriceForDefaultVat(product);

        //then
        assertThat(result).isEqualTo(24.60);
    }


    @Test
    void shouldCalculateGrossPriceFor10PercentVat() throws Exception {
        //given

        //when
        double result = vatService.getGrossPrice(product.getNetPrice(), 0.1);

        //then
        assertThat(result).isEqualTo(22);
    }

    @Test
    void shouldThrowExceptionForIncorrectVatValue() {
        //given

        //when

        //then
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            vatService.getGrossPrice(product.getNetPrice(), 1.1);
        });
    }
}
