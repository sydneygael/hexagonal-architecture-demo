package com.sadjoumoumouni.demo.hexagon.core.product;

import java.util.List;
import java.util.Optional;

import com.sadjoumoumouni.demo.hexagon.core.product.usecase.CreateOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.DeleteOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.ReadOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.UpdateOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.DataPersistencePort;

public class ProductFacade implements
		CreateOperationsProduct, ReadOperationsProduct, UpdateOperationsProduct, DeleteOperationsProduct {

	private final DataPersistencePort dataPersistencePort;

	public ProductFacade(DataPersistencePort dataPersistencePort) {
		this.dataPersistencePort = dataPersistencePort;
	}

	@Override
	public Product create(Product product) {
		return this.dataPersistencePort.createOrUpdate(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return this.dataPersistencePort.createOrUpdate(product);
	}

	@Override
	public boolean deleteProduct(Product product) {
		return this.dataPersistencePort.deleteProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return this.getAllProducts();
	}

	@Override
	public Optional<Product> getProductById(String id) {
		return this.getAllProducts().stream().filter( p -> p.getId().equals(id)).findAny();
	}
}
