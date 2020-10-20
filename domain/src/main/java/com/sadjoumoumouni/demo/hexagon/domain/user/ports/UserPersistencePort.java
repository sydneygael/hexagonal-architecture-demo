package com.sadjoumoumouni.demo.hexagon.domain.user.ports;

import java.util.List;

import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

public interface UserPersistencePort {

    User addNewUser(User user);

    User updateUserInfos(User user);

    boolean deleteUser(User user) throws DoesNotExistException;

    List<User> getAllUsers();
}
