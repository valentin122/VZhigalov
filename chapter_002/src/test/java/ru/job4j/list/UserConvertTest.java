package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvertTest {
    @Test
    public void when3UsersThenHash() {
        UserConvert users = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Max", 21, "Moscow"));
        list.add(new User(3, "Venia", 20, "Sochi"));
        list.add(new User(2, "Denis", 25, "Voronezh"));

        HashMap<Integer, User> result = users.process(list);
        String test = result.get(2).getCity();
        String expect = "Voronezh";
        assertThat(test, is(expect));
    }
}
