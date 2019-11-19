package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userHashMap = new HashMap<>();
        for (User user : list) {
            userHashMap.put(user.getId(), user);
        }
        return userHashMap;
    }
}
