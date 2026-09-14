import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.println("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            System.out.println("Enter operator (+, -, *, /): ");
            String operator = sc.nextLine();

            double result;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    System.out.println("Result = " + result);
                    break;

                case "-":
                    result = num1 - num2;
                    System.out.println("Result = " + result);
                    break;

                case "*":
                    result = num1 * num2;
                    System.out.println("Result = " + result);
                    break;

                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }

                    result = num1 / num2;
                    System.out.println("Result = " + result);
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number input.");
        }

        catch (ArithmeticException e) {
            System.out.println("Error: Cannot diivde by zero.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid operator.");
        }

        finally {
            System.out.println("Calculator program completed.");
            sc.close();
        }
    }
}