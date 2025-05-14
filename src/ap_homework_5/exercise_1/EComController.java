package ap_homework_5.exercise_1;
public class EComController {
    public static void main(String[] args) {
        ShippingInfo info = new ShippingInfo("Munich", 80331, "Germany"); Profile profile = new Profile(info);
        Customer customer = new Customer(profile, 123);

        // Original code that violates Law of Demeter
        System.out.println("Shipping to (violating Law of Demeter): " +
                customer.getProfile().getShippingInfo().getCity());

        // Fixed code that respects Law of Demeter
        System.out.println("Shipping to (respecting Law of Demeter): " +
                customer.getShippingCity());
    }
}