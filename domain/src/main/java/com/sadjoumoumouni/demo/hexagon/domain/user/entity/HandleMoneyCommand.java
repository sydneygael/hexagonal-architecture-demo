package com.sadjoumoumouni.demo.hexagon.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HandleMoneyCommand {
    private String userId;
    private Double money;
}
