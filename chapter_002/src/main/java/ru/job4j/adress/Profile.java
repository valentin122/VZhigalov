package ru.job4j.adress;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

     public List<String> collect(List<Profile> profiles) {
        List<String> result = profiles.stream().map(
            profile -> profile.address.getCity()
        ).collect(Collectors.toList());
         return result;
    }

}
