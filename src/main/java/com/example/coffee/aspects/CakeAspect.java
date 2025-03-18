package com.example.coffee.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CakeAspect {

    @Before("execution(* com.example.coffee.controllers.CakeController.getProducts(..))")
    public void logBeforeGetProducts(JoinPoint joinPoint) {
        System.out.println("---- Before calling getProducts() ----");
        System.out.println("Method Signature: " + joinPoint.getSignature());
    }
}