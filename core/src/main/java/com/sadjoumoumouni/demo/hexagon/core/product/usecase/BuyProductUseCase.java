package com.sadjoumoumouni.demo.hexagon.core.product.usecase;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.BuyProductCommand;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.CannotBuyProductException;

public interface BuyProductUseCase {
    void buyProduct(BuyProductCommand command) throws CannotBuyProductException;
}
