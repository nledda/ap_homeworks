package ap_homework_5.exercise_3;

// Variant 2: Let caller handle the exception
public class Calculator_2 {
    // Method throws exception to be handled by caller
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            double result = Calculator_2.divide(3, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error caught in main: " + e.getMessage());
            // Potential recovery logic here
        }
    }
}
