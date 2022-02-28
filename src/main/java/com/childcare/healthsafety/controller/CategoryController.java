package com.childcare.healthsafety.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")// means http://localhost:9092/api/categories/
public class CategoryController {

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "hello world";    }

    @GetMapping(path = "/categories/")
    public String getAllCategories() {
        return "all categories";    }


}
