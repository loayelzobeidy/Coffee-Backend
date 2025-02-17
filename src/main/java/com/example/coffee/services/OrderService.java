package com.example.coffee.services;

import com.example.coffee.dao.OrderDao;
import com.example.coffee.entities.Cake;
import com.example.coffee.entities.Order;
import com.example.coffee.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CakeRepository cakeRepository;
        public Order createOrder(Order order) {
            System.out.println("hello order "+order.getCakes());
            Set <Cake> cakes = new HashSet<Cake>();
            for(var cake :order.getCakes()){
                cakes.add(this.cakeRepository.findById(cake.getId()).orElseThrow());
            }
            order.setCakes(cakes);
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
