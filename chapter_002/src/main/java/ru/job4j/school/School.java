package ru.job4j.school;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = students.stream().filter(predicate).collect(Collectors.toList());
        return result;
    }
    public Map<String, Student> getMapOfListStudents(List<Student> students) {
        Map<String, Student> result = students.stream().distinct().collect(
                Collectors.toMap(
                        Student -> Student.getLastname(),
                        Student -> Student
                )
        );
        return result;
    }
}
