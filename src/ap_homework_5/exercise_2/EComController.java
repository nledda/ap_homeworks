package ap_homework_5.exercise_2;

public class EComController {
    public static void main(String[] args) {
        try {
            // Valid customer
            ShippingInfo info = new ShippingInfo("Munich", 80331, "Germany");
            Profile profile = new Profile(info);
            Customer customer = new Customer(profile, 123);
            System.out.println("Valid Customer - Shipping to: " + customer.getShippingCity());

            // Invalid city
            ShippingInfo invalidCityInfo = new ShippingInfo("", 80331, "Germany");
            // This line will not be reached due to exception

        } catch (InvalidShippingInfoException e) {
            System.out.println("Shipping Error: " + e.getMessage());
        } catch (MissingShippingInfoException e) {
            System.out.println("Profile Error: " + e.getMessage());
        } catch (InvalidCustomerException e) {
            System.out.println("Customer Error: " + e.getMessage());
        }

        try {
            // Invalid zip code
            ShippingInfo invalidZipInfo = new ShippingInfo("Berlin", -1, "Germany");
            // This line will not be reached due to exception

        } catch (InvalidShippingInfoException e) {
            System.out.println("Shipping Error: " + e.getMessage());
        }

        try {
            // Missing shipping info
            Profile invalidProfile = new Profile(null);
            // This line will not be reached due to exception

        } catch (MissingShippingInfoException e) {
            System.out.println("Profile Error: " + e.getMessage());
        }

        try {
            // Invalid customer ID
            ShippingInfo validInfo = new ShippingInfo("Berlin", 10115, "Germany");
            Profile validProfile = new Profile(validInfo);
            Customer invalidCustomer = new Customer(validProfile, -5);
            // This line will not be reached due to exception

        } catch (InvalidShippingInfoException | MissingShippingInfoException | InvalidCustomerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}