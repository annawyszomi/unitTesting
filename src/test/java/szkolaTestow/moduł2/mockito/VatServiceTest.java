package szkolaTestow.moduł2.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import szkolaTestow.moduł2.cz2.IncorrectVatException;
import szkolaTestow.moduł2.cz2.VatProvider;
import szkolaTestow.moduł2.cz2.VatService;
import szkolaTestow.moduł2.cz2.Product;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VatServiceTest {
    VatService vatService;
    VatProvider vatProvider;

    @Mock
    Logger logger;

    @Test
    void shouldCalculatePriceForDefaultPrice() throws IncorrectVatException {
        //given
        Product product = new Product(20.00, "cloth");

        when(vatProvider.getDefaultVat()).thenReturn(0.23);

        //when

        double result = vatService.geGrossPriceForDefaultVat(product);
        //then

        assertEquals(24.60, result);
    }


    @Test
    void shouldCalculateGrossPriceForBooks() throws IncorrectVatException {
        //given
        Product product = new Product(20.00, "book");

        when(vatProvider.getVatForType(product.getType())).thenReturn(0.1);
        //when
        double result = vatService.getGrossPrice(product.getNetPrice(), product.getType());

        //then
        assertEquals(22.0, result);
    }

    @Test
    void shouldThrowExceptionWhenVatVauleMoreThanOne() throws IncorrectVatException {
        //given
        Product product = new Product(20.00, "food");
        when(vatProvider.getVatForType(product.getType())).thenReturn(1.1);
        //when


        //then

        assertThrows(IncorrectVatException.class, () ->{
            vatService.getGrossPrice(product.getNetPrice(),product.getType());
        });
    }

//
//    @Test
//    void shouldDiplayLoggerMessage() throws IncorrectVatException {
//        //given
//        Product product = new Product(100.00,"electronics");
//        when(vatProvider.getVatForType(product.getType())).thenReturn(0.1);
//        //when
//        double result = vatService.getGrossPrice(product.getNetPrice(), product.getType());
//
//        //then
//        verify(logger).info("calculating gross price for " + product.getType());
//    }

    @BeforeEach
    private void setUp() {
        vatProvider = Mockito.mock(VatProvider.class);
        vatService = new VatService(vatProvider);

    }
}



















