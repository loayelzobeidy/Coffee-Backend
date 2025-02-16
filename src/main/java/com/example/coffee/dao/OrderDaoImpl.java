package com.example.coffee.dao;

import com.example.coffee.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; // Important!

import java.util.List;

@Repository
@Transactional // Essential for EntityManager operations
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        Query query = entityManager.createQuery("SELECT o FROM Order o");
        return query.getResultList();
    }

    @Override
    public List<Order> findComplexOrdersCriteria(long minPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> root = cq.from(Order.class);

        cq.where(cb.gt(root.get("totalPrice"), minPrice));
        return entityManager.createQuery(cq).getResultList();

    }
}