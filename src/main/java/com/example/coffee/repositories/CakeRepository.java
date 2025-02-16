package com.example.coffee.repositories;

import com.example.coffee.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Long> {
}
