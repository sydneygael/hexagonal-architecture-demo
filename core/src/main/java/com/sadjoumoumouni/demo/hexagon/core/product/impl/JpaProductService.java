package com.sadjoumoumouni.demo.hexagon.core.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.JpaPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.ProductJpaRepository;
import com.sadjoumoumouni.demo.hexagon.core.product.ProductService;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;

@Service
@Transactional
public class JpaProductService implements ProductService {

    private final DataPersistencePort dataPersistencePort;

    @Autowired
    public JpaProductService(final ProductJpaRepository productJpaRepository) {
        this.dataPersistencePort = new JpaPersistenceAdapter(productJpaRepository);
    }

    @Override
    public Product createOrUpdate(Product product) {
        return dataPersistencePort.createOrUpdate(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return dataPersistencePort.deleteProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return dataPersistencePort.getAllProducts();
    }
}
