package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvertTest {
    @Test
    public void when3UsersthenHash() {
        UserConvert users = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Max", "Krasnodar"));
        list.add(new User(3, "Venia", "Moscow"));
        list.add(new User(2, "Denis", "Sochi"));

        HashMap<Integer, User> result = users.process(list);
        String test = result.get(2).city;
        String expect = "Sochi";
        assertThat(test, is(expect));
    }
}
