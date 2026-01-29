import java.util.Scanner;

public class simplecal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        caltest calc = new caltest();
        while (true) {

            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("+") || input.equals("-")
                    || input.equals("*") || input.equals("/")
                    || input.equals("=")) {
                calc.inputOperator(input);
            } else {
                try {
                    double value = Double.parseDouble(input);
                    calc.inputNumber(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                    continue;
                }

            }
            if (calc.isError()) {
                System.out.println("Error");
            } else {
                System.out.println(calc.getValuenum());
            }
        }
        scanner.close();
    }
}
