package com.example.hamiltontevin_ce05.people;


public class Student extends People {
    private final int idNumber;

    public Student(String firstName, String lastName, int idNumber) {
        super(firstName, lastName);
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return  firstName +" "+ lastName +" | " +idNumber;
    }
}
