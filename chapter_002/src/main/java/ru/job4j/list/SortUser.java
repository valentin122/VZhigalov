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
                return o1.getName().length() - o2.getName().length();
            }
        });
        sortedByNameLength.addAll(users);
        return sortedByNameLength;
    }

    public List<User> sortByAllFields(List<User> users) {
        List<User> sortedByAllFriends = new ArrayList<>();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        sortedByAllFriends.addAll(users);
        return users;
    }
}

