package com.sadjoumoumouni.demo.hexagon.domain.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyProductCommand {
    private String userId;
    private String productId;
    private Integer quantity;
}
