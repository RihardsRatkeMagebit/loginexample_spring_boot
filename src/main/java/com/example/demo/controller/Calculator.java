package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController

// http://localhost:8080/calculator/
@RequestMapping(value = "calculator")
public class Calculator {

    // Basic addition GET calculator
    // http://localhost:8080/calculator/?a=10&b=3
    // Result 13
    @GetMapping("add")
    public Integer add(
            @RequestParam(name = "a", defaultValue = "0") Integer a,
            @RequestParam(name = "b", defaultValue = "0") Integer b
    ) {
        return a + b;
    }


    // Basic addition GET calculator
    // http://localhost:8080/calculator/subtract?a=10&b=3
    // Result 7
    @GetMapping("subtract")
    public Integer subtract(
            @RequestParam(name = "a", defaultValue = "0") Integer a,
            @RequestParam(name = "b", defaultValue = "0") Integer b
    ) {
        return a - b;
    }

    // Basic addition GET calculator
    // http://localhost:8080/calculator/sum?a=1,2,3,4,5,6,7
    // Result 28
    @GetMapping("sum")
    public Integer sum(@RequestParam(name = "a", defaultValue = "1,2,3") int[] a) {
        return Arrays.stream(a).sum();
    }
}

