package ap_homework_5.presence_exercise_2;

public class CheckOutService {
    private PaymentProvider paymentProvider;
    //sowohl PayPal als auch CreditCard oder ApplePay... koennen hier gespeichert werden

    // Constructor injection of the payment provider
    public CheckOutService(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    public void processPayment(double amount) {
        // Additional business logic can go here
        paymentProvider.pay(amount);
    }
}