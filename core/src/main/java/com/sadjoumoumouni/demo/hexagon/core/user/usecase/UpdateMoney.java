package com.sadjoumoumouni.demo.hexagon.core.user.usecase;

import com.sadjoumoumouni.demo.hexagon.domain.user.entity.HandleMoneyCommand;

public interface UpdateMoney {
    boolean udpateMoney(HandleMoneyCommand command);
}
