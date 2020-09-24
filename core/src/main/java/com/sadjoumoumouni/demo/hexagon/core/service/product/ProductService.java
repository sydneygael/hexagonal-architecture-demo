package com.sadjoumoumouni.demo.hexagon.core.service.product;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;

import java.util.List;

public interface ProductService {

    Product createOrUpdate(Product product);

    boolean deleteProduct(Product product);

    List<Product> getAllProducts();
}
