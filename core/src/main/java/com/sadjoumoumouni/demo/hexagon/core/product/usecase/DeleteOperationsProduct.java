package com.sadjoumoumouni.demo.hexagon.core.product.usecase;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;

public interface DeleteOperationsProduct {
	boolean deleteProduct(Product product) throws DoesNotExistException;
}
