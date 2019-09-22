package ru.job4j.school;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private int scope;
    private String name;
    private String lastname;

    public Student(String lastname, int scope) {
        this.lastname = lastname;
        this.scope = scope;
    }

    public Student(String name, String lastname, int scope) {
        this.name = name;
        this.lastname = lastname;
        this.scope = scope;
    }

    public Student(int scope) {
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "scope is" + " " + scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
