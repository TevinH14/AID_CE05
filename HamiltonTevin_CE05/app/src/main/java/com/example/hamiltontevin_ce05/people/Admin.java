package com.example.hamiltontevin_ce05.people;



public class Admin extends People {
    private final String mProgram;
    public Admin(String firstName, String lastName,String program) {
        super(firstName, lastName);
        mProgram = program;
    }




    @Override
    public String toString() {
        return firstName +" "+ lastName +" | " +mProgram;
    }
}
