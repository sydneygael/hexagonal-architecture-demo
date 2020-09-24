package com.sadjoumoumouni.demo.hexagon.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadjoumoumouni.demo.hexagon.core.service.product.ProductService;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;

@RestController
@RequestMapping("/api/product")
public class SpringProductController {

    private final ProductService productService;

    @Autowired
    public SpringProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
