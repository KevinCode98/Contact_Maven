package model;

public class Organization extends Contact{
    private String address;

    public Organization(String name, String number, String address) {
        super(name, number, false);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String editAddress(String address) {
        this.address = address;
        return UPDATE_CONTACT;
    }
}
