package ru.job4j.list;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> users) {
       Set<User> sorted = new TreeSet<>();
       users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {

                return Integer.compare(o1.age, o2.age);
            }
       });
       sorted.addAll(users);
       return sorted;
    }
}

