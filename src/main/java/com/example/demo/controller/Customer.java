package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class Customer {

    //http://localhost:8080/customer/list
    // Result
//    [
//
//    {
//        "name":"User-1", "age":"1"
//    },
//
//    {
//        "name":"User-2", "age":"2"
//    },
//
//    {
//        "name":"User-3", "age":"3"
//    },
//
//    {
//        "name":"User-4", "age":"4"
//    },
//
//    {
//        "name":"User-5", "age":"5"
//    },
//
//    {
//        "name":"User-6", "age":"6"
//    },
//
//    {
//        "name":"User-7", "age":"7"
//    },
//
//    {
//        "name":"User-8", "age":"8"
//    },
//
//    {
//        "name":"User-9", "age":"9"
//    },
//
//    {
//        "name":"User-10", "age":"10"
//    }]

    @GetMapping("list")
    public List<com.example.demo.model.Customer> customerList() {
        return generateTestCustomers();
    }

    private List<com.example.demo.model.Customer> generateTestCustomers() {
        List<com.example.demo.model.Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            com.example.demo.model.Customer data = new com.example.demo.model.Customer("User-" + i, Integer.toString(i));
            customers.add(data);
        }
        return customers;
    }
}
