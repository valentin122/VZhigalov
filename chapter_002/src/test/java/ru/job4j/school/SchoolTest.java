package ru.job4j.school;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    School school = new School();

    List<Student> students = List.of(
            new Student(100),
            new Student(90),
            new Student(80),
            new Student(60),
            new Student(55),
            new Student(49),
            new Student(30)
    );

    @Test
    public void getStudentsA() {
        List<Student> result = school.collect(students, student -> student.getScope() >= 70);
        assertThat(result.size(), is(3));
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
}
