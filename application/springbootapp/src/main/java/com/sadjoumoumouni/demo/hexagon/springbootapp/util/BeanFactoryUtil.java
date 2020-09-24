package com.sadjoumoumouni.demo.hexagon.springbootapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.ProductJpaRepository;

@Component
public class BeanFactoryUtil {

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public BeanFactoryUtil(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public ProductJpaRepository getProductJpaRepository() {
        return productJpaRepository;
    }
}
