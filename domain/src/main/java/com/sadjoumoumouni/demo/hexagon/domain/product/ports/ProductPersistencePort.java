package com.sadjoumoumouni.demo.hexagon.domain.product.ports;

import java.util.List;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;

public interface ProductPersistencePort {
    Product createOrUpdate(Product product);

    boolean exist(Product product);

    boolean deleteProduct(final Product product) throws DoesNotExistException;

    List<Product> getAllProducts();
}
