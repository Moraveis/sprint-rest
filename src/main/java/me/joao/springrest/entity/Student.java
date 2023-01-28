package me.joao.springrest.entity;

public class Student {

    private String firstName;
    private String lastNme;

    public Student() {
    }

    public Student(String firstName, String lastNme) {
        this.firstName = firstName;
        this.lastNme = lastNme;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNme() {
        return lastNme;
    }

    public void setLastNme(String lastNme) {
        this.lastNme = lastNme;
    }
}
