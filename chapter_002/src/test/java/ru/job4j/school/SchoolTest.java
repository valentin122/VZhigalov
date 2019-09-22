package ru.job4j.school;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    School school = new School();

    List<Student> students = List.of(
            new Student("Ivanov", 99),
            new Student("Petrov", 100),
            new Student("Sidorov", 90),
            new Student("Varlamov", 80),
            new Student("Yan", 60),
            new Student("Aaron", 55),
            new Student("Bus", 49),
            new Student("Karl", 30)
    );

    @Test
    public void getStudentsA() {
        List<Student> result = school.collect(students, student -> student.getScope() >= 70);
        assertThat(result.size(), is(4));
    }
    @Test
    public void getStudentsB() {
        List<Student> result = school.collect(students, student -> 50 <= student.getScope() && student.getScope() < 70);
        assertThat(result.size(), is(2));
    }
    @Test
    public void getStudentsC() {
        List<Student> result = school.collect(students, student -> 0 < student.getScope() && student.getScope() < 50);
        assertThat(result.size(), is(2));
    }
    @Test
    public void whenScopeMreBoundThan() {
        List<Student> result = school.levelOf(students, 79);
        assertThat(result.size(), is(4));
    }
}
