package ap_homework_5.exercise_2;

public class ShippingInfo {
    private String city;
    private int zip;
    private String country;

    public ShippingInfo(String city, int zip, String country) throws InvalidShippingInfoException {
        // Validate city and zip
        if (city == null || city.trim().isEmpty()) {
            throw new InvalidShippingInfoException("City cannot be empty");
        }

        if (zip <= 0) {
            throw new InvalidShippingInfoException("Zip code must be a positive number");
        }

        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InvalidShippingInfoException {
        if (city == null || city.trim().isEmpty()) {
            throw new InvalidShippingInfoException("City cannot be empty");
        }
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) throws InvalidShippingInfoException {
        if (zip <= 0) {
            throw new InvalidShippingInfoException("Zip code must be a positive number");
        }
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }





}
