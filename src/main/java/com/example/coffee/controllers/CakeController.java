package com.example.coffee.controllers;

import com.example.coffee.dtos.CakeDto;
import com.example.coffee.dtos.CakeDtoImpl;
import com.example.coffee.entities.Cake;
import com.example.coffee.requests.CakeRequest;
import com.example.coffee.services.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public Cake createCake(@RequestBody CakeRequest cake){
        System.out.println("cake "+cake.name+" "+cake.description+" "+cake.price);
        return this.cakeService.createCake(cake);
    }
}
