package com.sadjoumoumouni.demo.hexagon.domain.product.ports;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;

import java.util.List;

public interface DataPersistencePort {
    Product createOrUpdate(Product product);

    boolean exist(Product product);

    boolean deleteProduct(final Product product);

    List<Product> getAllProducts();
}
