package ap_homework_5.presence_exercise_2;

public class PayPalPayment implements PaymentProvider {
        @Override
        public void pay(double amount) {
            System.out.println("Processing payment of $" + amount + " via PayPal");
            // PayPal specific implementation would go here
        }
}
