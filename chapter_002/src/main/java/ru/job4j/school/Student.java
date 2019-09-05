package ru.job4j.school;

public class Student {
    private int scope;

    public Student (int scope) {
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
    @Override
    public String toString() {
        return "scope is" + " " + scope;
    }
}
