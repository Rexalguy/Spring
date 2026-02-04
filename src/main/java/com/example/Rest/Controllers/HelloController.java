package com.example.Rest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //With the RestController annotation, all controller actions become
    //Rest hence don't return the name of a view

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/cia")
    public String ciao(){
        return "Ciao!";
    }
}
