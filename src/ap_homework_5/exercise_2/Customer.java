package ap_homework_5.exercise_2;

public class Customer {
    private Profile profile;
    private int id;

    public Customer(Profile profile, int id) throws InvalidCustomerException {
        if (profile == null) {
            throw new InvalidCustomerException("Profile cannot be null");
            // die Nachricht haette auch in super() in der Klasse stehen koennen
        }

        if (id < 0) {
            throw new InvalidCustomerException("Customer ID cannot be negative");
        }

        this.profile = profile;
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) throws InvalidCustomerException {
        if (profile == null) {
            throw new InvalidCustomerException("Profile cannot be null");
        }
        this.profile = profile;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidCustomerException {
        if (id < 0) {
            throw new InvalidCustomerException("Customer ID cannot be negative");
        }
        this.id = id;
    }

    // Added method to respect Law of Demeter
    public String getShippingCity() {
        return profile.getShippingCity();
    }

    public String getShippingCountry() {
        return profile.getShippingInfo().getCountry();
    }

    public int getShippingZip() {
        return profile.getShippingInfo().getZip();
    }
}
