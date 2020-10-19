package com.sadjoumoumouni.demo.hexagon.domain.product.exception;

public class DoesNotExistException  extends Throwable {
    public DoesNotExistException(final String message) {
        super(message);
    }
}
