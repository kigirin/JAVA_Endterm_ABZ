package com.company.entities;

public class Driver {
    private int id;
    private String name;
    private String surname;
    private String PhoneNumber;
    private int CarID;

    public Driver(int id, String name, String surname, String phoneNumber, String carID) {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCarID() {
        return CarID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Driver(String name, String surname, String PhoneNumber, int CarID) {
        setName(name);
        setSurname(surname);
        setCarID(CarID);
        setPhoneNumber(PhoneNumber);
    }

    public Driver (int id, String name, String surname,String PhoneNumber, int CarID){
        setName(name);
        setSurname(surname);
        setId(id);
        setPhoneNumber(PhoneNumber);
        setCarID(CarID);

    }
    @Override
    public String toString() {
        return "Driver id: " + getId() + "; name: " + getName() + "; surname: " + getSurname() + "; PhoneNumber: " + getPhoneNumber() + "; CarID: " + getCarID();
    }

}
