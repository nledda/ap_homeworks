package ap_homework_5.presence_exercise_2;

public class CreditCardPayment implements PaymentProvider {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " via Credit Card");
        // Credit card specific implementation would go here
    }
}