package szkolaTestow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldSumUpTwoNumbers() {

        //given - środowisko, w którym test będzie uruchamiany

        int first = 2;
        int second = 7;

        //when -  wywołanie metod do testów
        int result = first + second;


        //then - asercje
        assertEquals(9, result);

    }

}
