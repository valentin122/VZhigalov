package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SimpleMap {
    private Map<User, Object> map = new HashMap<>();


    public void test() {
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Val", 0, birthday);
        User user2 = new User("Val", 0, birthday);
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
        System.out.println(map.containsValue("second"));
    }
}
