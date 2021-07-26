package com.example.hamiltontevin_ce05.people;


public class Teacher extends People {
    private final String mCourse;
    public Teacher(String firstName, String lastName,String course) {
        super(firstName, lastName);
        mCourse = course;
    }

    @Override
    public String toString() {
        return firstName +" "+ lastName +" | " + mCourse;

    }
}
