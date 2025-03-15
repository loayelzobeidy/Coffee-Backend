package com.example.coffee.controllers;

import com.example.coffee.dtos.CakeDto;
import com.example.coffee.dtos.CakeDtoImpl;
import com.example.coffee.dtos.CakeFilterRequest;
import com.example.coffee.dtos.CakeSpecifications;
import com.example.coffee.entities.Cake;
import com.example.coffee.repositories.CakeRepository;
import com.example.coffee.requests.CakeRequest;
import com.example.coffee.services.CakeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cakes")
public class CakeController {
    private CakeService cakeService;
    @Autowired
    private CakeRepository cakeRepository;
    @Autowired
    public CakeController(CakeService cakeService){
        this.cakeService = cakeService;
    }
    @GetMapping("")
    public ResponseEntity<Page<Cake>> getProducts(@ModelAttribute CakeFilterRequest request) {
        Specification<Cake> spec = CakeSpecifications.filterProducts(request);

        PageRequest pageRequest;
        if(request.getSort() != null && !request.getSort().isEmpty()){
            String[] sortParams = request.getSort().split(",");
            Sort.Direction direction = Sort.Direction.fromString(sortParams[1]);
            pageRequest = PageRequest.of(request.getPage(), request.getSize(), Sort.by(direction, sortParams[0]));
        } else {
            pageRequest = PageRequest.of(request.getPage(), request.getSize());
        }

        Page<Cake> cakes = cakeRepository.findAll(spec, pageRequest);
        return ResponseEntity.ok(cakes);
    }
    @PostMapping("")
    public Cake createCake(@RequestBody CakeRequest cake){
        return this.cakeService.createCake(cake);
    }
}
