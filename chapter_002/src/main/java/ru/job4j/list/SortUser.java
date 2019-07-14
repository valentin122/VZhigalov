package ru.job4j.list;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> users) {
       Set<User> sorted = new TreeSet<>();
       sorted.addAll(users);
       return sorted;
    }
    public List<User> sortNameLength(List<User> users) {
        List<User> sortedByNameLength = new ArrayList<>();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.length() - o2.name.length();
            }
        });
        sortedByNameLength.addAll(users);
        return sortedByNameLength;
    }
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.name.compareTo(o2.name);
                return result != 0 ? result : Integer.compare(o1.age, o2.age);
            }
        });
        return users;
    }
}

