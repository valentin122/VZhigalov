package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;;

public class SortUserTest {
    SortUser sortUser = new SortUser();
    Set<User> expected  = Set.of(
            new User("Hans", 16),
            new User("Fritz", 17),
            new User("Max", 29),
            new User("Maximus", 19),
            new User("Maxim", 18)
    );
    Set<User> actual = Set.of(
            new User("Hans", 16),
            new User("Fritz", 17),
            new User("Maxim", 18),
            new User("Maximus", 19),
            new User("Max", 29)
    );
    List<User> exeptedList = new ArrayList<>();


    @Test
    public  void SortUserTest() {
        Set<User> expectedSet = sortUser.sort(expected.stream().collect(Collectors.toList()));
        System.out.println(expectedSet);
        assertThat(expectedSet.equals(actual), is(true));
    }

    @Test
    public void whenSortByNameLengthThan() {
        exeptedList.addAll(expected);
        List<User> sortedListUsersByName = sortUser.sortNameLength(exeptedList);
        System.out.println(sortedListUsersByName);
        assertThat(sortedListUsersByName.get(0).getName(), is("Max"));
    }

    @Test
    public void whenSortByAllFieldsThen() {
        List<User> unsortedList = List.of(
                new User("Hans", 16),
                new User("Fritz", 17),
                new User("Maxim", 18),
                new User("Maximus", 19),
                new User("Max", 29)
        );
        List<User> result = sortUser.sortByAllFields(unsortedList);
        System.out.println(result);
        assertThat(result.get(2).getName().equals("Maxim"), is(true));
    }
}
