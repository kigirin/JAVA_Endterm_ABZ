package com.company.repositories.interfaces;

import com.company.entities.Order;
import java.util.List;
public interface IOrderRepository {
    boolean createOrder(Order order);
    Order getOrder(int id);
    List<Order> getAllOrders();
}