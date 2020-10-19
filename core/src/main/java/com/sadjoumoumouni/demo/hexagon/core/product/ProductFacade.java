package com.sadjoumoumouni.demo.hexagon.core.product;

import java.util.List;
import java.util.Optional;

import com.sadjoumoumouni.demo.hexagon.core.product.usecase.BuyProductUseCase;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.CreateOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.DeleteOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.ReadOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.UpdateOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.core.user.UserFacade;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.BuyProductCommand;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.CannotBuyProductException;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;
import com.sadjoumoumouni.demo.hexagon.domain.product.ports.ProductPersistencePort;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.HandleMoneyCommand;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

public class ProductFacade implements CreateOperationsProduct, ReadOperationsProduct, UpdateOperationsProduct, DeleteOperationsProduct, BuyProductUseCase {

    private final ProductPersistencePort productPersistencePort;
    private final UserFacade userFacade;

    public ProductFacade(ProductPersistencePort productPersistencePort, UserFacade userFacade) {
        this.productPersistencePort = productPersistencePort;
        this.userFacade = userFacade;
    }

    @Override
    public Product create(Product product) {
        return this.productPersistencePort.createOrUpdate(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.productPersistencePort.createOrUpdate(product);
    }

    @Override
    public boolean deleteProduct(Product product) throws DoesNotExistException {
        return this.productPersistencePort.deleteProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return this.getAllProducts().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void buyProduct(BuyProductCommand command) throws CannotBuyProductException {
        User user = userFacade.getUserById(command.getUserId())
                .orElseThrow(() -> new CannotBuyProductException("No User"));
        Product product = getProductById(command.getProductId())
                .orElseThrow(() -> new CannotBuyProductException("No product"));
        Double totalPrice = command.getQuantity() * product.getPrice();

        if (user.getMoney() < totalPrice) {
            throw new CannotBuyProductException("No Money , no product");
        } else {
            userFacade.udpateMoney(new HandleMoneyCommand(user.getUserId(), user.getMoney() - totalPrice));
        }
    }
}
