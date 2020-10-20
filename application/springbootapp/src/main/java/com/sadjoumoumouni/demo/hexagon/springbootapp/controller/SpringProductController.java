package com.sadjoumoumouni.demo.hexagon.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadjoumoumouni.demo.hexagon.core.product.ProductFacade;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.BuyProductUseCase;
import com.sadjoumoumouni.demo.hexagon.core.product.usecase.ReadOperationsProduct;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.BuyProductCommand;
import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.CannotBuyProductException;

@RestController
@RequestMapping("/api/product")
public class SpringProductController {

    private final ReadOperationsProduct readOperationsProduct;
    private final BuyProductUseCase buyProductUseCase;

    @Autowired
    public SpringProductController(final ProductFacade productFacade) {
        this.readOperationsProduct = productFacade;
        this.buyProductUseCase = productFacade;
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return readOperationsProduct.getAllProducts();
    }

    @PostMapping(value="/buyProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buyProduct(@RequestBody BuyProductCommand productCommand) {
        try{
            buyProductUseCase.buyProduct(productCommand);
            return ResponseEntity.ok("buy succes");
        }
        catch (CannotBuyProductException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
