package com.company.entities;

public class Order {
    private int id;
    private double cost ;
    private String point_A;
    private String point_B;
    private String date;
    private int driverID;//variable

    public Order(){

    }

    public Order(double cost , String point_A , String point_B , String date , int driverID){//constructor
        setCost(cost);
        setPoint_A(point_A);
        setPoint_B(point_B);
        setDate(date);
        setDriverID(driverID);
    }
    public Order( int id , double cost , String point_A , String point_B , String date , int driverID){ //constructor
        setId(id);
        setCost(cost);
        setPoint_A(point_A);
        setPoint_B(point_B);
        setDate(date);
        setDriverID(driverID);
    }

    public int getId() {
        return id;
    } // getr and setr

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public int getDriverID() {
        return driverID;
    }

    public String getPoint_A() {
        return point_A;
    }

    public String getPoint_B() {
        return point_B;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public void setPoint_A(String point_A) {
        this.point_A = point_A;
    }

    public void setPoint_B(String point_B) {
        this.point_B = point_B;
    }

    @Override
    public String toString(){ //method that returns variables
        return "Order id: " + getId() + ", cost" + getCost() + ", from address" + getPoint_A() + ",to address " + getPoint_B() + ", Date of ORder" + getDate() + ", Order taken driver id:" + getDriverID();
    }
}
