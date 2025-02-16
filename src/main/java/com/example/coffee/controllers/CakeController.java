package com.example.coffee.controllers;

import com.example.coffee.dtos.CakeDto;
import com.example.coffee.services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cakes")
public class CakeController {
    private CakeService cakeService;
    @Autowired
    public CakeController(CakeService cakeService){
        this.cakeService = cakeService;
    }
    @GetMapping("")
    public List<CakeDto> getCakes(){
        return this.cakeService.getAllCakes();
    }
}
