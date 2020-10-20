package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.ProductPersistencePort;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;
import com.sadjoumoumouni.demo.hexagon.domain.user.ports.UserPersistencePort;

@Component
public class InMemoryPersistenceAdapter implements ProductPersistencePort, UserPersistencePort {

    public static final String USER = "user";
    public static final String PRODUCT = "product";

    private Map<String, Object> inMemoryDb = new ConcurrentHashMap<>();

    @Override
    public Product createOrUpdate(Product product) {
        inMemoryDb.put(PRODUCT+product.getId(), product);
        return product;
    }

    @Override
    public boolean exist(Product product) {
        return inMemoryDb.containsKey(PRODUCT+product.getId());
    }

    @Override
    public boolean deleteProduct(Product product) throws DoesNotExistException {
        if (inMemoryDb.remove(PRODUCT+product.getId()) == null) {
            throw new DoesNotExistException("user doesn't exist");
        }
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return inMemoryDb.values().stream()
                .filter(Product.class::isInstance)
                .map(Product.class::cast)
                .collect(Collectors.toList());
    }

    @Override
    public User addNewUser(User user) {
        inMemoryDb.put(USER +user.getUserId(),user);
        return user;
    }

    @Override
    public User updateUserInfos(User user) {
        return addNewUser(user);
    }

    @Override
    public boolean deleteUser(User user) throws DoesNotExistException {
        if (inMemoryDb.remove(USER+user.getUserId()) == null) {
            throw new DoesNotExistException("user doesn't exist");
        }
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return inMemoryDb.values().stream()
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .collect(Collectors.toList());
    }
}
