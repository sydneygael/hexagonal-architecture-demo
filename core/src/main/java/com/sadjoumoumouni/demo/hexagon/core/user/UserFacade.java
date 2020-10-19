package com.sadjoumoumouni.demo.hexagon.core.user;

import java.util.List;
import java.util.Optional;

import com.sadjoumoumouni.demo.hexagon.core.user.usecase.AddNewUser;
import com.sadjoumoumouni.demo.hexagon.core.user.usecase.GetUsers;
import com.sadjoumoumouni.demo.hexagon.core.user.usecase.UpdateMoney;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.HandleMoneyCommand;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;
import com.sadjoumoumouni.demo.hexagon.domain.user.ports.UserPersistencePort;

public class UserFacade implements AddNewUser, GetUsers, UpdateMoney {

    UserPersistencePort userPersistencePort;

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return null;
    }

    @Override
    public User addNewUser(User user) {
        return null;
    }

    @Override
    public boolean udpateMoney(HandleMoneyCommand command) {
        return false;
    }
}
