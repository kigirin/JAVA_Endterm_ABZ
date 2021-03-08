package com.company.entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean gender;//variables

    public User() {

    }

    public User(String name, String surname, boolean gender) { //constructor
        setName(name);
        setSurname(surname);
        setGender(gender);
    }

    public User(int id, String name, String surname, boolean gender) { //constructor
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
    }

    public int getId() {
        return id;
    } //getr and setr

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() { //method that returns all variables
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (gender ? "Male" : "Female") +
                '}';
    }
}