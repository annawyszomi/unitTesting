package szkolaTestow.moduł1.assertJ;

import org.junit.jupiter.api.Test;
import szkolaTestow.moduł1.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator calculator;

    @Test
    public void shouldReturnNumberWhenNegativeNumberGiven() {
        createCalculator();
        assertThat(calculator.add("-4")).isEqualTo(-4);
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersGiven() {
        createCalculator();
        assertThat(calculator.add("99,1")).isEqualTo(100);
    }

    @Test
    public void shouldReturnSumWhenThreeNumbersGiven() {
        createCalculator();
        assertThat(calculator.add("1,1,1")).isEqualTo(3);
    }

    @Test
    public void shouldReturnSumWhenZeroGiven() {
        createCalculator();
        assertThat(calculator.add("0,0")).isEqualTo(0);
    }

    @Test
    public void shouldReturnSumWhenNegativeNumberGiven() {
        createCalculator();
        assertThat(calculator.add("-8,-2")).isEqualTo(-10);
    }

    @Test
    public void shouldReturnSumWhenPositiveAndNegativeNumberGiven() {
        createCalculator();
        assertThat(calculator.add("-10,10")).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroWhenEmpty() {
        createCalculator();
        assertThat(calculator.add("")).isEqualTo(0);
    }


    private void createCalculator() {
        calculator = new StringCalculator();
    }
}