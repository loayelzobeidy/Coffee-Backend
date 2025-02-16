package com.example.coffee.services;

import com.example.coffee.dtos.CakeDto;
import com.example.coffee.dtos.CakeDtoImpl;
import com.example.coffee.entities.Cake;
import com.example.coffee.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {
    private CakeRepository cakeRepository;

            @Autowired
            public CakeService(CakeRepository cakeRepository){
                this.cakeRepository = cakeRepository;

            }
            public List<CakeDto> getAllCakes(){
                return this.cakeRepository.findAll().stream().map(this::convertEntityToDto ).toList();
            }
    public CakeDto convertEntityToDto(Cake cake){
         CakeDtoImpl cakeDtoImpl = new CakeDtoImpl();
         cakeDtoImpl.setName(cake.getName());
        cakeDtoImpl.setDescription(cake.getDescription());
        cakeDtoImpl.setImageUrl(cake.getImageUrl());

        return cakeDtoImpl;

    }
}
