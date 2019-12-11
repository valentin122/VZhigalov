package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    UserStore userStore = new UserStore(10);
    User user1 = new User("1");
    User user2 = new User("2");
    User user3 = new User("3");

    @Before
    public void setUserStore() {
        userStore.add(user1);
    }

    @Test
    public void add() {
        userStore.add(user2);
        assertThat(userStore.findById("2").getId().equals("2"), is(true));
    }
    @Test
    public void replace() {
        assertThat(userStore.replace("2", user3), is(true));
    }

    @Test
    public void delete() {
        userStore.add(user3);
        assertThat(userStore.delete("3"), is(true));
    }

    @Test
    public void findById() {
        assertThat(userStore.findById("1").equals(user1), is(true));
    }
}
