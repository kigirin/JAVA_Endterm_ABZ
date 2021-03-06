package com.company.entities;

public class Car {
    private int id;
    private String model;
    private String number;
    private String colour;
    public Car(){

    }

    public Car(String model , String number , String colour){
        setModel(model);
        setNumber(number);
        setColour(colour);
    }

    public Car(int id , String model , String number , String colour){
        setId(id);
        setModel(model);
        setNumber(number);
        setColour(colour);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override

    public String toString(){
        return "Car id: " + getId() + " , model: " + getModel() + " , number of Car: " + getNumber() + " , colour is : " + getColour();
    }
}
