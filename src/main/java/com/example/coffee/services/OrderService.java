package com.example.coffee.services;

import com.example.coffee.dao.OrderDao;
import com.example.coffee.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
        public Order createOrder(Order order) {
            return orderDao.save(order);
        }

        public Order getOrderById(Long id) {
            return orderDao.findById(id);
        }

        public List<Order> getAllOrders() {
            return orderDao.findAll();
        }

        public List<Order> getComplexOrdersCriteria(long minPrice) {
            return orderDao.findComplexOrdersCriteria(minPrice); // Criteria API Example
        }

    }
