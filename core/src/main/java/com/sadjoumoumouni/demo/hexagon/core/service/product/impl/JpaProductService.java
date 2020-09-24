package com.sadjoumoumouni.demo.hexagon.core.service.product.impl;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.JpaPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.ProductJpaRepository;
import com.sadjoumoumouni.demo.hexagon.core.service.product.ProductService;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
