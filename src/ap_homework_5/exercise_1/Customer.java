package ap_homework_5.exercise_1;

public class Customer {
    private Profile profile;
    private int id;

    public Customer(Profile profile, int id) {
        this.profile = profile;
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
