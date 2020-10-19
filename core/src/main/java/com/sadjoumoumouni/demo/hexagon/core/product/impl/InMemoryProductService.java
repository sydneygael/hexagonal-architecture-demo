package com.sadjoumoumouni.demo.hexagon.core.product.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.InMemoryPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.core.product.ProductService;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;

@Service
public class InMemoryProductService implements ProductService {

    private final DataPersistencePort dataPersistencePort;

    public InMemoryProductService() {
        this.dataPersistencePort = new InMemoryPersistenceAdapter();
    }

    public Product createOrUpdate(Product product) {
        return dataPersistencePort.createOrUpdate(product);
    }

    public boolean deleteProduct(Product product) {
        return dataPersistencePort.deleteProduct(product);
    }

    public List<Product> getAllProducts() {
        return dataPersistencePort.getAllProducts();
    }
}
