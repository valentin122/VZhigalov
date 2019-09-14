package ru.job4j.adress;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile (Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

     public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(Profile :: getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
         return result;
    }
}
