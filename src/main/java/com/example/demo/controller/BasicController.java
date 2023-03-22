package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

// Read more about spring-boot annotations
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.html

@RestController
@RequestMapping(value = "basic") // http://localhost:8080/basic/
public class BasicController {
    // Read more about request and their types
    // https://www.w3schools.com/tags/ref_httpmethods.asp

    // GET is used to resource from server
    @GetMapping("hello")
    public String getHelloWorld() {
        return "Hello world GET";
    }

    // POST is used to send data to server for all actions
    @PostMapping("hello")
    public String postHelloWorld(){
        return "Hello world POST";
    }

    // PUT is used to send data to a server to create/update a resource
    @PutMapping("hello")
    public String putHelloWorld(){
        return "Hello world PUT";
    }

    // DELETE is used to send data to server to delete a resource
    @DeleteMapping("hello")
    public String deleteHelloWorld(){
        return "Hello world DELETE";
    }

    // PATCH is used to send data to server to update a resource
    @PatchMapping("hello")
    public String patchHelloWorld(){
        return "Hello world PATCH";
    }


}
