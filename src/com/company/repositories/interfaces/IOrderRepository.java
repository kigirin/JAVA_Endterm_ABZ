package com.company.repositories.interfaces;
//package name com.company
import com.company.entities.Order;
//import Order class
import java.util.List;
public interface IOrderRepository {
    //createOrder method
    boolean createOrder(Order order);
    //getOrder method for reference OrderRepo
    Order getOrder(int id);
    //getAllOrders method for reference OrderRepo
    List<Order> getAllOrders();
}