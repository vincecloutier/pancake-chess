public class Address {
    public String streetAddress;
    public String city;
    public String stateOrProvince;
    public String postalCode;

    public Address(String streetAddress, String city, String stateOrProvince, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
