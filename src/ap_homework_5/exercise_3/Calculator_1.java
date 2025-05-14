package ap_homework_5.exercise_3;

// Variant 1: Handle exception within the method
public class Calculator_1 {
    // Exception handled within the method
    public static double divide(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error in division: " + e.getMessage());
            return Double.NaN; // Return Not-a-Number as a signal of failure
        }
    }

    public static void main(String[] args) {
        double result = Calculator_1.divide(3, 0);
        System.out.println("Result: " + result);
    }
}
