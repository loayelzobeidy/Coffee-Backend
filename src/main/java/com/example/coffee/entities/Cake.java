package com.example.coffee.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Table(name = "cakes")
@Entity
public class Cake  implements MenuItem{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false)
        long id;
        String name;
        long price;
        String description;
        String imageUrl;

    @Override
    public long getId() {
        return id;
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
        return price;
    }

    @NotNull
    @Override
    public String getDescription() {
        return description;
    }

    @NotNull
    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
