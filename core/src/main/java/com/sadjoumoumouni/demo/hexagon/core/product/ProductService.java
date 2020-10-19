package com.sadjoumoumouni.demo.hexagon.core.product;

import java.util.List;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;

public interface ProductService {

    Product createOrUpdate(Product product);

    boolean deleteProduct(Product product);

    List<Product> getAllProducts();
}
