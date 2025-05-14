package ap_homework_5.exercise_2;

public class Profile {
    private ShippingInfo shippingInfo;
    public Profile(ShippingInfo shippingInfo) throws MissingShippingInfoException {
        if (shippingInfo == null) {
            throw new MissingShippingInfoException("ShippingInfo cannot be null");
        }
        this.shippingInfo = shippingInfo;
    }
    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) throws MissingShippingInfoException {
        if (shippingInfo == null) {
            throw new MissingShippingInfoException("ShippingInfo cannot be null");
        }
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
