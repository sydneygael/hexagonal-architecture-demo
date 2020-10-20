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

    private final UserPersistencePort userPersistencePort;

    public UserFacade(final UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return getAllUsers().stream().filter(user -> user.getUserId().equals(userId)).findAny();
    }

    @Override
    public User addNewUser(User user) {
        return userPersistencePort.addNewUser(user);
    }

    @Override
    public boolean udpateMoney(HandleMoneyCommand command) {
        Optional<User> userById = getUserById(command.getUserId());
        userById.ifPresent( user -> user.setMoney(command.getMoney()));
        userPersistencePort.updateUserInfos(userById.get());
        return true;
    }
}
