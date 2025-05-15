package ap_homework_5.presence_exercise_2;

public class main {
        public static void main(String[] args) {
            // Test with PayPal
            PaymentProvider payPalProvider = new PayPalPayment();
            CheckOutService payPalCheckout = new CheckOutService(payPalProvider);
            System.out.println("Making a payment using PayPal:");
            payPalCheckout.processPayment(99.99);

            // Test with Credit Card
            PaymentProvider creditCardProvider = new CreditCardPayment();
            CheckOutService creditCardCheckout = new CheckOutService(creditCardProvider);
            System.out.println("\nMaking a payment using a credit card:");
            creditCardCheckout.processPayment(149.99);

            // Optional: Adding a third payment method
            // This demonstrates extending the system without modifying existing code
            System.out.println("\nAdding a new payment method (ApplePay):");
            PaymentProvider applePayProvider = new PaymentProvider() {
                @Override
                public void pay(double amount) {
                    System.out.println("Processing payment of $" + amount + " via ApplePay");
                }
            };
            CheckOutService applePayCheckout = new CheckOutService(applePayProvider);
            applePayCheckout.processPayment(199.99);
        }
}
