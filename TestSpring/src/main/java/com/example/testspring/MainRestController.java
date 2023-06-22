package com.example.testspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
   // @GetMapping
   // public String getHello() //uri handler
   // {
       // return "hello world ";
   // }
    @PostMapping( "/addnos")
    public String add2nos(@RequestParam("num1") int num1, @RequestParam("num2") int num2)
    {
        return "the sum of numbers is " +(num1+num2);
    }
}
