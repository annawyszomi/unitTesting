package szkolaTestow;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    StringCalculator calculator;

    @Test
    public void shouldReturnNumberWhenNegativeNumberGiven() {
        createCalculator();
        assertEquals(-4, calculator.add("-4"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersGiven() {
        createCalculator();
        assertEquals(100, calculator.add("99,1"));
    }

    @Test
    public void shouldReturnSumWhenThreeNumbersGiven() {
        createCalculator();
        assertEquals(3, calculator.add("1,1,1"));
    }

    @Test
    public void shouldReturnSumWhenZeroGiven() {
        createCalculator();
        assertEquals(0, calculator.add("0,0"));
    }

    @Test
    public void shouldReturnSumWhenNegativeNumberGiven() {
        createCalculator();
        assertEquals(-10, calculator.add("-8,-2"));
    }

    @Test
    public void shouldReturnSumWhenPositiveAndNegativeNumberGiven() {
        createCalculator();
        assertEquals(0,calculator.add("10,-10"));
    }

    @Test
    public void shouldReturnZeroWhenEmpty() {
        createCalculator();
        assertEquals(0,calculator.add(""));
    }


    private void createCalculator() {
        calculator = new StringCalculator();
    }
}