package com.sadjoumoumouni.demo.hexagon.domain.product.exception;

public class DoesNotExistException  extends RuntimeException {
    public DoesNotExistException(final String message) {
        super(message);
    }
}
