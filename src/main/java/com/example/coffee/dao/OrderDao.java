package com.example.coffee.dao;

import com.example.coffee.entities.Order;
import java.util.List;

public interface OrderDao {
    Order save(Order order);
    Order findById(Long id);
    List<Order> findAll();
    public List<Order> findComplexOrdersCriteria(long minPrice);
}