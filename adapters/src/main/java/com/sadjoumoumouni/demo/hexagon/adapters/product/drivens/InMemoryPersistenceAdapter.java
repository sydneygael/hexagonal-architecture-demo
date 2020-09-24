package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryPersistenceAdapter implements DataPersistencePort {

    private final Map<String, Product> inMemoryDb = new HashMap<String, Product>();

    @Override
    public Product createOrUpdate(Product product) {
        inMemoryDb.put(product.getId(), product);
        return product;
    }

    @Override
    public boolean exist(Product product) {
        return inMemoryDb.containsKey(product.getId());
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (inMemoryDb.remove(product.getId()) == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(inMemoryDb.values());
    }
}
