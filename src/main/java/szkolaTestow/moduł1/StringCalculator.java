package szkolaTestow.moduł1;

public class StringCalculator {
    public int add(String input) {

        if (input.isEmpty()) {
            return 0;
        }
        else{
            String[]numbers = input.split(",");
            int result = 0;

            for (String n : numbers) {
                result += getIntFrom(n);
            }
            return result;
        }

    }

    private int getIntFrom(String number) {
        return Integer.parseInt(number);
    }
}
