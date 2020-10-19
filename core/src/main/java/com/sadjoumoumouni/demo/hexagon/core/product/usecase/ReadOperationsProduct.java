package com.sadjoumoumouni.demo.hexagon.core.product.usecase;

import java.util.List;
import java.util.Optional;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;

public interface ReadOperationsProduct {
	List<Product> getAllProducts();
	Optional<Product> getProductById(String id);
}
