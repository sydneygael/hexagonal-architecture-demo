package com.sadjoumoumouni.demo.hexagon.core.service.product.impl;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.InMemoryPersistenceAdapter;
import com.sadjoumoumouni.demo.hexagon.core.service.product.ProductService;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

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
