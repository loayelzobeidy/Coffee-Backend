package com.example.coffee.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    long id;
    @Column(name="total_price")
    long totalPrice;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "orders_cakes", // Name of the join table
            joinColumns = @JoinColumn(name = "order_id"), // Foreign key for Course
            inverseJoinColumns = @JoinColumn(name = "cake_id")) // Foreign key for Student
    private Set<Cake> cakes = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(Set<Cake> cakes) {
        this.cakes = cakes;
    }
}
