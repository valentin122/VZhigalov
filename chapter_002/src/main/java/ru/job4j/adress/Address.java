package ru.job4j.adress;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "City: " + city + "/n"
                + "street: " + street
                + "home: " + home
                + "apartament: " + apartment;
    }
    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address) object;

        return this.city.equals(address.getCity())
                && this.street.equals(address.getStreet())
                && this.home == address.getHome()
                && this.apartment == address.getApartment();
    }
    @Override
    public int hashCode() {
        return city.hashCode() + apartment;
    }
}
