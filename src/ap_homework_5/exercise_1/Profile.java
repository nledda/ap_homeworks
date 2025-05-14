package ap_homework_5.exercise_1;

public class Profile {
    private ShippingInfo shippingInfo;
    public Profile(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    // Added method to respect Law of Demeter
    public String getShippingCity() {
        return shippingInfo.getCity();
    }

    public String getShippingCountry() {
        return shippingInfo.getCountry();
    }
    public int getShippingZip() {
        return shippingInfo.getZip();
    }



}
