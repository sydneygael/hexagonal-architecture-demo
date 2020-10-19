package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.ProductJpaRepository;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.ProductPersistencePort;

@Component
public class JpaPersistenceAdapter implements ProductPersistencePort {

    private final ProductJpaRepository productJpaRepository;

    public JpaPersistenceAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product createOrUpdate(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public boolean exist(Product product) {
        return productJpaRepository.exists(Example.of(product));
    }

    @Override
    public boolean deleteProduct(Product product) throws DoesNotExistException {
        try {
            productJpaRepository.delete(product);
            return true;
        } catch (Exception e) {
            throw new DoesNotExistException(e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productJpaRepository.findAll();
    }
}
